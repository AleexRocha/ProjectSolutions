package ServletLogin;

import DAO.UsuarioDAO;
import Model.Produto;
import Model.Usuario;
import static Utils.Criptografia.criptografar;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Yoshioka
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/venda/valida_usuario"})
public class LoginServlet extends HttpServlet {

    private void processaRequisicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uEmail = request.getParameter("email");
        String uSenha = request.getParameter("password");
        RequestDispatcher dispatcher;

        boolean formularioOK = validaCamposForm(request);
        if (!formularioOK) {
            HashMap<String, String> camposInvalidos = InformaCamposIncorretos(request);
            if (camposInvalidos.get("emailError") != null) {
                request.setAttribute("emailError", camposInvalidos.get("emailError"));
            }
            if (camposInvalidos.get("senhaError") != null) {
                request.setAttribute("senhaError", camposInvalidos.get("senhaError"));
                request.setAttribute("loginError", camposInvalidos.get("loginError"));
            }
            request.setAttribute("varMsgError", true);
            request.setAttribute("msg", "Campo de E-mail ou Senha inválidos");
            dispatcher = request.getRequestDispatcher("/login/login.jsp");
        } else {
            String senhaCriptografada = criptografar(uSenha);

            boolean httpOK = UsuarioDAO.getLogin(uEmail, senhaCriptografada);

            if (httpOK) {
                HttpSession sessao = setSessao(request.getParameter("email"), request);

                if (sessao.getAttribute("nomeSetor").equals("Cliente")) {
                    ArrayList<Produto> produtos = DAO.ProdutoDAO.getProdutos();
                    request.setAttribute("listaProdutos", produtos);
                    dispatcher = request.getRequestDispatcher("../produtos/index.jsp");
                } else {
                    ArrayList<Produto> produtos = DAO.ProdutoDAO.getProdutos();
                    request.setAttribute("listaProdutos", produtos);
                    dispatcher = request.getRequestDispatcher("../produtos/listagem_produtos.jsp");
                }
            } else {
                request.setAttribute("varMsgError", true);
                request.setAttribute("msg", "Usuário ou Senha não existem.");

                request.setAttribute("loginError", uEmail);

                dispatcher = request.getRequestDispatcher("/login/login.jsp");
            }
        }

        dispatcher.forward(request, response);
    }

    private boolean validaCamposForm(HttpServletRequest request) {
        String uEmail = request.getParameter("email");
        String uSenha = request.getParameter("password");

        return !((uEmail.length() == 0) || (uSenha.length() == 0));
    }

    private HashMap<String, String> InformaCamposIncorretos(HttpServletRequest request) {
        HashMap<String, String> camposInvalidos = new HashMap<>();
        String uEmail = request.getParameter("email");
        String uSenha = request.getParameter("password");

        if (uEmail.length() == 0) {
            camposInvalidos.put("emailError", "O e-mail é obrigatório");
            return camposInvalidos;
        }
        if (uSenha.length() == 0) {
            camposInvalidos.put("senhaError", "A senha é obrigatória");
            camposInvalidos.put("loginError", uEmail);
        }
        return camposInvalidos;
    }

    private HttpSession setSessao(String emailUser, HttpServletRequest request) {
        Usuario infoSessao = UsuarioDAO.getInfoSessao(emailUser);
        HttpSession sessao = request.getSession();
        ArrayList<Produto> produtosAux = (ArrayList<Produto>) sessao.getAttribute("produtosCarrinho");
        if (produtosAux == null || produtosAux.isEmpty()) {
            ArrayList<Produto> produtos = new ArrayList<>();
            sessao.setAttribute("produtosCarrinho", produtos);
        }
        sessao.setAttribute("cdFuncionario", infoSessao.getCodigoUsuario());
        sessao.setAttribute("nomeUsuario", infoSessao.getNome());
        sessao.setAttribute("nomeSetor", infoSessao.getNomeSetor());
        sessao.setAttribute("cdSetor", infoSessao.getSetor());
        sessao.setAttribute("emailUsuario", emailUser);
        sessao.setAttribute("cpfUsuario", infoSessao.getCpf());

        return sessao;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        processaRequisicao(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        processaRequisicao(req, resp);
    }
}
