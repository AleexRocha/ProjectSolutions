package ServletVenda;

import DAO.RelatorioDAO;
import Model.Relatorio;
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
 * @author Alexsander Rocha
 */
@WebServlet(name = "ExtornoListaSelect", urlPatterns = {"/select_extorno"})
public class ExtornoListaSelect extends HttpServlet {

    private void processaRequisicao(String metodoHttp, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String eCodProduto = request.getParameter("codigoProduto");
        String eCodFilial = request.getParameter("codigoFilial");
        String eCpfCliente = request.getParameter("cpfCliente");

        if (!eCodProduto.equalsIgnoreCase("")) {
            ArrayList<Relatorio> extorno = RelatorioDAO.getExtornoProduto(eCodProduto);
            request.setAttribute("listaExtorno", extorno);
        } else if (!eCodFilial.equalsIgnoreCase("")) {
            ArrayList<Relatorio> extorno = RelatorioDAO.getExtornoFilial(eCodFilial);
            request.setAttribute("listaExtorno", extorno);
        } else if (!eCpfCliente.equalsIgnoreCase("")) {
            ArrayList<Relatorio> extorno = RelatorioDAO.getExtornoCpf(eCpfCliente);
            request.setAttribute("listaExtorno", extorno);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/venda/extorno.jsp");
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
