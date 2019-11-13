package ServletUsuario;

import DAO.UsuarioDAO;
import Model.Usuario;

import java.io.IOException;

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
@WebServlet(name = "UsuarioPerfilServlet", urlPatterns = {"/ti/perfil"})
public class UsuarioPerfilServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cCodigo = request.getParameter("perfil");

        Usuario usuario = UsuarioDAO.getUsuario(Integer.parseInt(cCodigo));

        request.setAttribute("codigoUsuario", usuario.getCodigoUsuario());
        request.setAttribute("nome", usuario.getNome());
        request.setAttribute("cpf", usuario.getCpf());
        request.setAttribute("email", usuario.getEmail());
        request.setAttribute("nomeSetor", usuario.getNomeSetor());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/ti/perfil.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
