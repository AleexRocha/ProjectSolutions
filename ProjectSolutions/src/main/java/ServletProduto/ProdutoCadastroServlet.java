package ServletProduto;

import DAO.FilialDAO;
import DAO.ProdutoDAO;

import Model.Filial;
import Model.Produto;

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
 * @author guilher.rsvieira
 */
@MultipartConfig
@WebServlet(name = "ProdutoCadastroServlet", urlPatterns = {"/produtos/cadastro_produto"})
public class ProdutoCadastroServlet extends HttpServlet {

    private void processaRequisicao(String metodoHttp, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String fNome = request.getParameter("nome");
        String fDescricao = request.getParameter("descricao");
        String fTipo = request.getParameter("tipo");
        String fCodigoFilial = request.getParameter("codigoFilial");
        String fQuantidadeEstoque = request.getParameter("quantidadeEstoque");
        String fValorUnitario = request.getParameter("valorUnitario");
//        String fimagem = fcaminhoImagem;

        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        String fcaminhoImagem = uploadImagem(isMultipart, request);

        boolean error = false;
        if (fNome.length() == 0) {
            error = true;
            request.setAttribute("nomeErro", "Nome não informado");
        }
        if (fTipo == null) {
            error = true;
            request.setAttribute("tipoErro", "Tipo não informado");
        }
        if (fCodigoFilial == null) {
            error = true;
            request.setAttribute("codigoFilialErro", "Filial não informada");
        }
        if (fQuantidadeEstoque.length() == 0) {
            error = true;
            request.setAttribute("quantidadeEstoqueErro", "Quantidade em estoque não informada");
        }
        if (fValorUnitario.length() == 0) {
            error = true;
            request.setAttribute("valorUnitarioErro", "Valor unitário não informado");
        } //        if (fimagem.length() == 0) {
        //            error = true;
        //            request.setAttribute("caminhoImagemErro", "Imagem não informada");
        //        }
        else {
            String valorReplace;
            valorReplace = fValorUnitario.replace("R$", "");
            valorReplace = valorReplace.replace(",", ".");

            fValorUnitario = valorReplace;
        }

        if (error) {
            ArrayList<Filial> filiais = FilialDAO.getFiliais();
            request.setAttribute("listaFiliais", filiais);

            request.setAttribute("varMsg", true);
            request.setAttribute("msg", "Erro ao realizar o cadastro, verifique os campos e tente novamente.");

            RequestDispatcher dispatcher = request.getRequestDispatcher("/produtos/cadastro_produtos.jsp");
            dispatcher.forward(request, response);
        } else {
            Produto produtos = new Produto(fNome, fTipo, Integer.parseInt(fCodigoFilial), Integer.parseInt(fQuantidadeEstoque), Double.parseDouble(fValorUnitario));

//            produtos.setImagem(fimagem);
            if (fDescricao.length() != 0) {
                produtos.setDescricao(fDescricao);
            }
            boolean httpOK = ProdutoDAO.salvarProduto(produtos);

            if (httpOK) {
                ArrayList<Produto> produto = ProdutoDAO.getProdutos();
                request.setAttribute("listaProdutos", produto);

                request.setAttribute("varMsg", true);
                request.setAttribute("msg", "Cadastro realizado com sucesso.");

                RequestDispatcher dispatcher = request.getRequestDispatcher("/produtos/listagem_produtos.jsp");
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("varMsg", true);
                request.setAttribute("msg", "Erro ao realizar o cadastro no banco de dados, verifique os campos e tente novamente.");

                RequestDispatcher dispatcher = request.getRequestDispatcher("/produtos/cadastro_produtos.jsp");
                dispatcher.forward(request, response);
            }
        }
    }

    private String uploadImagem(boolean isMultipart, HttpServletRequest request) {
        String caminhoSalvo = null;

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
                        System.out.println();
                        if (!path.exists()) {
                            boolean status = path.mkdirs();
                        }

                        File uploadedFile = new File(path + "/" + fileName);
                        caminhoSalvo = uploadedFile.getCanonicalPath();
                        System.out.println(caminhoSalvo);
                        item.write(uploadedFile);
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return caminhoSalvo;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processaRequisicao("GET", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processaRequisicao("POST", req, resp);
    }

}
