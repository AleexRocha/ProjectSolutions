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

/**
 *
 * @author guilherme.pereira
 */
@WebServlet(name = "UsuarioEditarServlet", urlPatterns = {"/ti/editar_usuario"})
public class UsuarioEditarServlet extends HttpServlet {

    private void processaRequisicao(String metodoHttp, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cCodigo = request.getParameter("codigoFilial");
        String cNome = request.getParameter("nome");
        String cEmail = request.getParameter("email");
        String cSenha = request.getParameter("senha");
        String cSetor = request.getParameter("setor");
        String cFilial = request.getParameter("filial");

        boolean error = false;
        if (cNome.length() == 0) {
            error = true;
            request.setAttribute("nomeErro", "Nome não informado");
        }
        if (cEmail.length() == 0) {
            error = true;
            request.setAttribute("emailErro", "Email não informado");
        }
        if (cSenha.length() == 0) {
            error = true;
            request.setAttribute("senhaErro", "Senha não informada");
        }
        if (cSetor.length() == 0) {
            error = true;
            request.setAttribute("setorErro", "Setor não informado");
        }
        if (cFilial.length() == 0) {
            error = true;
            request.setAttribute("filialErro", "Filial não informada");
        }

        if (error) {
            ArrayList<Usuario> usuario = UsuarioDAO.getUsuario(Integer.parseInt(cCodigo));

            request.setAttribute("acao", "editar");
            request.setAttribute("codigo", usuario.getCodigo());
            request.setAttribute("nome", usuario.getNome());
            request.setAttribute("email", usuario.getEmail());
            request.setAttribute("setor", usuario.getSetor());
            request.setAttribute("filial", usuario.getCodigoFilial());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/ti/cadastro_usuarios.jsp");
            dispatcher.forward(request, response);

        } else {
            Usuario usuario = new Usuario(cNome, cEmail, cSenha, Integer.parseInt(cSetor), Integer.parseInt(cFilial));
            usuario.setCodigo(Integer.parseInt(cCodigo));
            boolean httpOK = UsuarioDAO.alterarUsuario(usuario);

            if (httpOK) {
                ArrayList<Usuario> usuarios = UsuarioDAO.getUsuarios();
                request.setAttribute("lista", usuarios);

                RequestDispatcher dispatcher = request.getRequestDispatcher("/ti/listagem_usuarios.jsp");
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/ti/cadastro_usuarios.jsp");
                dispatcher.forward(request, response);
            }
        }

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
