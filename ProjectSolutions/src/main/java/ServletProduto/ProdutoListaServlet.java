package ServletProduto;

import DAO.ProdutoDAO;
import Model.Produto;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guilherme.pereira
 */
@WebServlet(name = "ProdutoListaServlet", urlPatterns = {"/produtos/listagem_produtos"})
public class ProdutoListaServlet extends HttpServlet {

    private void processaRequisicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<Produto> produtos = ProdutoDAO.getProdutos();
        request.setAttribute("listaProdutos", produtos);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/produtos/listagem_produtos.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processaRequisicao(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processaRequisicao(req, resp);
    }

}
