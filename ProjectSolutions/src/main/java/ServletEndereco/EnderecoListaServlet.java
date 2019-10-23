package ServletEndereco;

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
@WebServlet(name = "EnderecoListaServlet", urlPatterns = {"/ti/get_endereco"})
public class EnderecoListaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cCodigo = request.getParameter("idUsuario");

        Usuario usuario = UsuarioDAO.getEnderecoUser(Integer.parseInt(cCodigo));

        request.setAttribute("codigoUsuario", cCodigo);
        request.setAttribute("codigoEndereco", usuario.getCodigoEndereco());
        request.setAttribute("cep", usuario.getCep());
        request.setAttribute("numero", usuario.getNumero());
        request.setAttribute("logradouro", usuario.getLogradouro());
        request.setAttribute("bairro", usuario.getBairro());
        request.setAttribute("cidade", usuario.getCidade());
        request.setAttribute("estado", usuario.getEstado());
        request.setAttribute("tipoEndereco", usuario.getTipoEndereco());

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
