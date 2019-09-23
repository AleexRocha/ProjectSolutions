package ServletProduto;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Produto;


/**
 * Servlet implementation class ProdutoGetDescricaoServlet
 */
@WebServlet(name = "GetInfoProduto", urlPatterns = {"/produtos/visualizar_descricao"})
public class ProdutoGetDescricaoServlet extends HttpServlet {
       
    private void processaRequisicao(String metodoHttp, HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
    	int codigoProduto = Integer.parseInt(request.getParameter("visualizarPorId"));
    	Produto produto = DAO.ProdutoDAO.getProduto(codigoProduto);
    	
    	request.setAttribute("produto", produto);
    	
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/produtos/descricao_produto.jsp");
        dispatcher.forward(request, response);
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  processaRequisicao("POST", req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  processaRequisicao("POST", req, resp);
	}

}