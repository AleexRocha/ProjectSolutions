package ServletFilial;

import DAO.FilialDAO;
import Model.Filial;
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
 * @author guilherme.psilva103
 */
@WebServlet(name = "FilialExcluirServlet", urlPatterns = {"/ti/excluir_filial"})
public class FilialExcluirServlet extends HttpServlet {

    protected void processaRequisicao(String HttpMethod, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fCodigo = request.getParameter("excluirID");
        boolean httpOk = FilialDAO.excluirFilial(Integer.parseInt(fCodigo));

        if (httpOk) {
            ArrayList<Filial> filiais = FilialDAO.getFiliais();
            request.setAttribute("lista", filiais);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("/ti/listagem_filiais.jsp");
            dispatcher.forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processaRequisicao("GET", request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processaRequisicao("POST", request, response);
    }

}
