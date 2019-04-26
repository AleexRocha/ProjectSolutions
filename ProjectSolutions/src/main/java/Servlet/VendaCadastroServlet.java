package Servlet;

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
        if (vCodProduto.length() == 0) {
            error = true;
            request.setAttribute("codProdutoErro", "Codigo do Produto não informado");
        }
        if (vIdFuncionario.length() == 0) {
            error = true;
            request.setAttribute("idFuncErro", "ID do Funcionario não informado");
        }
        if (vCodFilial.length() == 0) {
            error = true;
            request.setAttribute("codFilialErro", "Codigo da Filial não informado");
        }
        if (vQuantidade.length() == 0) {
            error = true;
            request.setAttribute("quantidadeErro", "Quantidade não informada");
        }

        if (error) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/venda/cadastro_vendas.jsp");
            dispatcher.forward(request, response);
        } else {
            Venda venda = new Venda(Integer.parseInt(vCodProduto), Integer.parseInt(vIdFuncionario), Integer.parseInt(vCodFilial), Integer.parseInt(vQuantidade));
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
