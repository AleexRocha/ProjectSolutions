package Controller;

import DAO.RelatorioDAO;
import Model.Relatorio;
import Utils.Validacao;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alexsander.mrocha
 */
@WebServlet(name = "RelatorioServlet", urlPatterns = {"/venda/relatorio"})
public class RelatorioServlet extends HttpServlet {

    private void processaRequisicao(String metodoHttp, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String rFilial = request.getParameter("filial");
        String rDataDe = request.getParameter("dataDe");
        String rDataAte = request.getParameter("dataAte");

        ArrayList<Relatorio> relatorioGerado = new ArrayList<>();
        relatorioGerado = RelatorioDAO.getRelatorios();

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
