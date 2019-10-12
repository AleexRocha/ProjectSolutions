package ServletUsuario;

import DAO.UsuarioDAO;
import Model.Usuario;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alexsander Rocha
 */
@WebServlet(name = "UsuarioSelectServlet", urlPatterns = {"/ti/formulario_usuarios"})
public class UsuarioSelectItensCadastro extends HttpServlet {

    private void processaRequisicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean cliente = true;
        HttpSession sessao = request.getSession();

        if (sessao == null) {
            request.setAttribute("cliente", cliente);
        } else {
            cliente = false;
            request.setAttribute("cliente", cliente);

            ArrayList<Usuario> setores = UsuarioDAO.getSetoresCadastro();
            request.setAttribute("listaSetores", setores);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ti/cadastro_usuarios.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processaRequisicao(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processaRequisicao(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

}
