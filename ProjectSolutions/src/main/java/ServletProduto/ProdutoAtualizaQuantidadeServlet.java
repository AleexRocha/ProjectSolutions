package ServletProduto;

import Model.Produto;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author alexsander.mrocha
 */
@WebServlet(name = "ProdutoAtualizaQuantidadeServlet", urlPatterns = {"/produto/atualiza_quantidade"})
public class ProdutoAtualizaQuantidadeServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Gson gson = new Gson();
        Produto produto[];

        StringBuilder ajax = new StringBuilder();
        BufferedReader reader = request.getReader();

        String linha;
        while ((linha = reader.readLine()) != null) {
            ajax.append(linha);
        }

        String json = ajax.toString();
        produto = gson.fromJson(json, Produto[].class);

        HttpSession sessao = request.getSession();
        ArrayList<Produto> produtos = (ArrayList<Produto>) sessao.getAttribute("produtosCarrinho");

        for (int i = 0; i < produtos.size(); i++) {
            if (produto[i].getCodigo() == produtos.get(i).getCodigo()) {
                produtos.get(i).setQuantidadeEstoque(produto[i].getQuantidadeEstoque());
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
