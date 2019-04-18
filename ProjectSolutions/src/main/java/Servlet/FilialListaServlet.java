package Servlet;

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
 * @author guilherme.pereira
 */
@WebServlet(name = "FilialListaServlet", urlPatterns = {"/ti/listagem_filiais"})
public class FilialListaServlet extends HttpServlet {

    private void processaRequisicao(String metodoHttp, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<Filial> filiais = FilialDAO.getFiliais();
        String codigo = "", logradouro = "", numero = "", cep = "", bairro = "", estado = "", cidade = "", telefone = "";
        if (filiais.size() > 0) {
            for (int i = 0; i < 1; i++) {
                codigo = String.valueOf(filiais.get(i).getCodigo());
                logradouro = filiais.get(i).getLogradouro();
                numero = String.valueOf(filiais.get(i).getNumero());
                cep = filiais.get(i).getCep();
                bairro = filiais.get(i).getBairro();
                estado = filiais.get(i).getEstado();
                cidade = filiais.get(i).getCidade();
                telefone = filiais.get(i).getTelefone();
                request.setAttribute("lista", filiais);

            }

            request.setAttribute("lista", filiais);
            request.setAttribute("metodoHttp", metodoHttp);
            request.setAttribute("codigo", codigo);
            request.setAttribute("logradouro", logradouro);
            request.setAttribute("numero", numero);
            request.setAttribute("cep", cep);
            request.setAttribute("bairro", bairro);
            request.setAttribute("estado", estado);
            request.setAttribute("cidade", cidade);
            request.setAttribute("telefone", telefone);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/resultado_lista.jsp");
            dispatcher.forward(request, response);

        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/ti/cadastro_filiais.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processaRequisicao("GET", req, resp); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processaRequisicao("POST", req, resp); //To change body of generated methods, choose Tools | Templates.
    }

}
