package ServletProduto;

import DAO.ProdutoDAO;
import Model.Produto;
import java.io.IOException;
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
@WebServlet(name = "ProdutoEditarServlet", urlPatterns = {"/produtos/dados_produto"})
public class ProdutoEditarServlet extends HttpServlet {

    private void processaRequisicao(String metodoHttp, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String pCodigo = request.getParameter("codigo");
        Produto produto = ProdutoDAO.getProduto(Integer.parseInt(pCodigo));

        request.setAttribute("acao", "editar");
        request.setAttribute("codigo", produto.getCodigo());
        request.setAttribute("nome", produto.getNome());
        request.setAttribute("descricao", produto.getDescricao());
        request.setAttribute("tipo", produto.getTipo());
        request.setAttribute("quantidadeEstoque", produto.getQuantidadeEstoque());
        request.setAttribute("valorUnitario", produto.getValorUnitario());
        /*request.setAttribute("estado", filial.getEstado());
        request.setAttribute("telefone", filial.getTelefone());
*/
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ti/cadastro_filiais.jsp");
        dispatcher.forward(request, response);

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