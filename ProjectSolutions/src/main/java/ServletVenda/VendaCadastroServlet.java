package ServletVenda;

import DAO.VendaDAO;
import Model.Venda;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guilherme.psilva103
 */
@WebServlet(name = "VendaCadastroServlet", urlPatterns = {"/venda/create_venda"})
public class VendaCadastroServlet extends HttpServlet {

    private void processaRequisicao(String metodoHttp, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String vCodProduto = request.getParameter("codigoProduto");
        String vIdFuncionario = request.getParameter("idFuncionario");
        String vCpfCliente = request.getParameter("cpfCliente");
        String vCodFilial = request.getParameter("codigoFilial");
        String vQuantidade = request.getParameter("quantidade");

        boolean error = false;
        if (vCodProduto == null) {
            error = true;
            request.setAttribute("codProdutoErro", "Não há produto cadastrado para concluir a venda");
        }
        if (vIdFuncionario == null) {
            error = true;
            request.setAttribute("idFuncErro", "Não há usuario cadastrado para concluir a a venda");
        }
        if (vCodFilial == null) {
            error = true;
            request.setAttribute("codFilialErro", "Não há filial cadastrado para concluir a a venda");
        }
        if (vQuantidade == null) {
            error = true;
            request.setAttribute("quantidadeErro", "Não há filial cadastrada para concluir a a venda");
        }

        if (error) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/venda/cadastro_vendas.jsp");
            dispatcher.forward(request, response);
        } else {
            Venda venda = new Venda(vCodProduto, vIdFuncionario, vCodFilial, vQuantidade);
            if (vCpfCliente.length() != 0) {
                venda.setCpfCliente(vCpfCliente);
            }
            boolean httpOK = VendaDAO.salvarVenda(venda);

            if (httpOK) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/venda/cadastro_vendas.jsp");
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/venda/cadastro_vendas.jsp");
                dispatcher.forward(request, response);
            }
        }
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
