package ServletEndereco;

import DAO.EnderecoDAO;

import Model.Usuario;

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
@WebServlet(name = "EnderecoListaServlet", urlPatterns = {"/ti/get_endereco"})
public class EnderecoListaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cCodigo = request.getParameter("idUsuario");

        ArrayList<Usuario> enderecos = EnderecoDAO.getEnderecosUser(Integer.parseInt(cCodigo));

        request.setAttribute("listaEnderecos", enderecos);

        request.setAttribute("perfil", "endereco");
        
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
