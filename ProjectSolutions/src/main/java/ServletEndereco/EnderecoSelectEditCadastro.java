package ServletEndereco;

import DAO.EnderecoDAO;

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
@WebServlet(name = "EnderecoSelectEditCadastro", urlPatterns = {"/ti/select_endereco"})
public class EnderecoSelectEditCadastro extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cCodigo = request.getParameter("idUsuario");

        Usuario usuario = EnderecoDAO.getEnderecoUser(Integer.parseInt(cCodigo));

        request.setAttribute("codigoUsuario", usuario.getCodigoUsuario());
        request.setAttribute("valorSetor", usuario.getSetor());
        request.setAttribute("codigoEndereco", usuario.getCodigoEndereco());
        request.setAttribute("complemento", usuario.getComplemento());
        request.setAttribute("cep", usuario.getCep());
        request.setAttribute("numero", usuario.getNumero());
        request.setAttribute("logradouro", usuario.getLogradouro());
        request.setAttribute("bairro", usuario.getBairro());
        request.setAttribute("cidade", usuario.getCidade());
        request.setAttribute("estado", usuario.getEstado());
        request.setAttribute("tipoEndereco", usuario.getTipoEndereco());

        request.setAttribute("acao", "editar");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/ti/cadastro_endereco.jsp");
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
