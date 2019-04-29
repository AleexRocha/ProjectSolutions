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
 * @author alexsander.mrocha
 */
@WebServlet(name = "RelatorioServlet", urlPatterns = {"/venda/gerar_relatorio"})
public class RelatorioServlet extends HttpServlet {

    private void processaRequisicao(String metodoHttp, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String where[] = new String[3];
        where[0] = request.getParameter("filial");
        where[1] = request.getParameter("dataDe");
        where[2] = request.getParameter("dataAte");

        ArrayList<Relatorio> relatorio = RelatorioDAO.getRelatorio(where);
        request.setAttribute("lista", relatorio);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/venda/relatorio.jsp");
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
