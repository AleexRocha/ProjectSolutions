package ServletProduto;

import DAO.ImagemDAO;
import Model.Imagem;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Alexsander Rocha
 */
@MultipartConfig
@WebServlet(name = "ProdutoUploadImagemServlet", urlPatterns = {"/produtos/upload"})
public class ProdutoUploadImagemServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean error = false;
        ArrayList caminhos = new ArrayList();
        ArrayList nomesArquivos = new ArrayList();

        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        if (isMultipart) {
            // Create a factory for disk-based file items
            FileItemFactory factory = new DiskFileItemFactory();

            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);

            try {
                // Parse the request
                List items = upload.parseRequest(request);
                Iterator iterator = items.iterator();
                while (iterator.hasNext()) {
                    FileItem item = (FileItem) iterator.next();
                    if (!item.isFormField()) {
                        String fileName = item.getName();
                        String root = getServletContext().getRealPath("/");
                        File path = new File(root + "../../src/main/uploads/images");

                        if (!path.exists()) {
                            boolean status = path.mkdirs();
                        }

                        File uploadedFile = new File(path + "/" + fileName);
                        item.write(uploadedFile);
                        caminhos.add(uploadedFile.getCanonicalPath());
                        nomesArquivos.add(fileName);
                    }
                }
            } catch (FileUploadException e) {
                System.out.println(e);
                error = true;
            } catch (Exception e) {
                System.out.println(e);
                error = true;
            }
        } else {
            error = true;
        }

        if (error) {
            request.setAttribute("varMsg", true);
            request.setAttribute("msg", "Erro ao salvar a imagem.");

            RequestDispatcher dispatcher = request.getRequestDispatcher("/produtos/cadastro_produtos.jsp");
            dispatcher.forward(request, response);
        } else {
            int fIdImagem = 0;
            if (caminhos.size() > 0 && nomesArquivos.size() > 0) {
                for (int i = 0; i < caminhos.size(); i++) {
                    Imagem imagem = new Imagem(nomesArquivos.get(i).toString(), caminhos.get(i).toString());
                    fIdImagem = ImagemDAO.salvarImagem(imagem);
                    if (fIdImagem == 0) {
                        request.setAttribute("varMsg", true);
                        request.setAttribute("msg", "Erro ao salvar a imagem.");

                        RequestDispatcher dispatcher = request.getRequestDispatcher("/produtos/cadastro_produtos.jsp");
                        dispatcher.forward(request, response);
                    }
                    request.setAttribute("listaImagens", fIdImagem);
                    request.setAttribute("id", fIdImagem);
                }
                request.setAttribute("varMsg", true);
                request.setAttribute("msg", "Imagem salva com sucesso!");

                RequestDispatcher dispatcher = request.getRequestDispatcher("/produtos/cadastro_produtos.jsp");
                dispatcher.forward(request, response);
            }
        }
    }
}
