package ServletLogin;

import DAO.UsuarioDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Yoshioka
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/venda/valida_usuario"})
public class LoginServlet extends HttpServlet {

    private void processaRequisicao(String metodoHttp, HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String uEmail = request.getParameter("email");
        String uSenha = request.getParameter("password");

        boolean error = false;
        if (uEmail.length() == 0) {
            request.setAttribute("emailError", "Campo email obrigatório");
            error = true;
        }
        if (uSenha.length() == 0) {
            request.setAttribute("senhaError", "Campo senha obrigatório");
            request.setAttribute("emailUser", uEmail);
            request.setAttribute("loginError", "Login ou senha inválidos");
            error = true;
        }
        if (error) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login/index.jsp");
            dispatcher.forward(request, response);
        
        } else {
            boolean httpOK = UsuarioDAO.getLogin(uEmail, uSenha);

            if (httpOK) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/venda/cadastro_vendas");
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("loginError", "Login ou senha inválidos");
                request.setAttribute("emailUser", uEmail);
                
                RequestDispatcher dispatcher = request.getRequestDispatcher("/login/index.jsp");
                dispatcher.forward(request, response);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        processaRequisicao("GET", req, resp); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        processaRequisicao("POST", req, resp); //To change body of generated methods, choose Tools | Templates.
    }

}
