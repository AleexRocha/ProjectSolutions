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
@WebServlet(name = "EstornoListaSelect", urlPatterns = {"/venda/select_estorno"})
public class EstornoListaSelect extends HttpServlet {

    private void processaRequisicao(String metodoHttp, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String eCodProduto = request.getParameter("codigoProduto");
        String eCodFilial = request.getParameter("codigoFilial");
        String eCpfCliente = request.getParameter("cpfCliente");

        if (eCodProduto != null) {
            ArrayList<Relatorio> estorno = RelatorioDAO.getEstornoProduto(eCodProduto);
            request.setAttribute("listaEstorno", estorno);
        } else if (eCodFilial  != null) {
            ArrayList<Relatorio> estorno = RelatorioDAO.getEstornoFilial(eCodFilial);
            request.setAttribute("listaEstorno", estorno);
        } else if (!eCpfCliente.equalsIgnoreCase("")) {
            ArrayList<Relatorio> estorno = RelatorioDAO.getEstornoCpf(eCpfCliente);
            request.setAttribute("listaEstorno", estorno);
        } else {
            request.setAttribute("varMsg", true);
            request.setAttribute("msg", "Escolha um filtro para gerar o relátorio.");
        }
        
//        if (!eCodProduto.equalsIgnoreCase("")) {
//            ArrayList<Relatorio> estorno = RelatorioDAO.getEstornoProduto(eCodProduto);
//            request.setAttribute("listaEstorno", estorno);
//        } else if (!eCodFilial.equalsIgnoreCase("")) {
//            ArrayList<Relatorio> estorno = RelatorioDAO.getEstornoFilial(eCodFilial);
//            request.setAttribute("listaEstorno", estorno);
//        } else if (!eCpfCliente.equalsIgnoreCase("")) {
//            ArrayList<Relatorio> estorno = RelatorioDAO.getEstornoCpf(eCpfCliente);
//            request.setAttribute("listaEstorno", estorno);
//        } else {
//            ArrayList<Relatorio> estorno = RelatorioDAO.getEstornoGeral();
//            request.setAttribute("listaEstorno", estorno);
//        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/venda/estorno.jsp");
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
