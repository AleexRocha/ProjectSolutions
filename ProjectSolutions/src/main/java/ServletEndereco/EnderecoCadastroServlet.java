package ServletEndereco;

import DAO.EnderecoDAO;
import DAO.ProdutoDAO;
import DAO.UsuarioDAO;

import Model.Produto;
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
@WebServlet(name = "EnderecoCadastroServlet", urlPatterns = {"/ti/create_endereco"})
public class EnderecoCadastroServlet extends HttpServlet {

    protected void processaRequisicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String uCodigoUsuario = request.getParameter("codigoUsuario");
        String uSetorUsuario = request.getParameter("valorSetor");
        String eCep = request.getParameter("cep");
        String eLogradouro = request.getParameter("logradouro");
        String eComplemento = request.getParameter("complemento");
        String eNumero = request.getParameter("numero");
        String eBairro = request.getParameter("bairro");
        String eCidade = request.getParameter("cidade");
        String eEstado = request.getParameter("estado");
        String eTipo = request.getParameter("tipoEndereco");

        HttpSession sessao = request.getSession();

        boolean error = false;
        if (uCodigoUsuario.length() == 0) {
            error = true;
            request.setAttribute("codigoErro", "Codigo do usuario não informado!");
        }
        if (eCep.length() == 0 || !(eCep.length() == 8)) {
            error = true;
            request.setAttribute("cepErro", "CEP não informado ou fora do padrão de 8 digitos!");
        }
        if (eLogradouro.length() == 0) {
            error = true;
            request.setAttribute("logradouroErro", "Logradouro não informado!");
        }
        if (eNumero.length() == 0) {
            error = true;
            request.setAttribute("numeroErro", "Número não informado!");
        }
        if (eBairro.length() == 0) {
            error = true;
            request.setAttribute("bairroErro", "Bairro não informado!");
        }
        if (eCidade.length() == 0) {
            error = true;
            request.setAttribute("cidadeErro", "Cidade não informada!");
        }
        if (eEstado.length() == 0) {
            error = true;
            request.setAttribute("estadoErro", "Estado não informado!");
        }
        if (eTipo == null) {
            error = true;
            request.setAttribute("tipoErro", "Tipo do endereço não informado!");
        }

        if (error) {
            request.setAttribute("varMsgError", true);
            request.setAttribute("msg", "Erro ao recuperar os dados, verifique os campos e tente novamente");

            request.setAttribute("codigoUsuario", uCodigoUsuario);
            request.setAttribute("valorSetor", uSetorUsuario);

            request.setAttribute("cep", eCep);
            request.setAttribute("logradouro", eLogradouro);
            request.setAttribute("numero", eNumero);
            request.setAttribute("bairro", eBairro);
            request.setAttribute("cidade", eCidade);
            request.setAttribute("estado", eEstado);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/ti/cadastro_endereco.jsp");
            dispatcher.forward(request, response);
        } else {
            Usuario usuario = new Usuario(Integer.parseInt(uCodigoUsuario), eLogradouro, eComplemento, Integer.parseInt(eNumero), eBairro, eCidade, eEstado, eCep, eTipo, Integer.parseInt(uCodigoUsuario));
            boolean httpOk = EnderecoDAO.salvarEndereco(usuario);

            if (httpOk) {
                if (uSetorUsuario.equals("1") || uSetorUsuario.equals("2")) {
                    ArrayList<Usuario> usuarios = UsuarioDAO.getUsuarios();
                    request.setAttribute("listaUsuarios", usuarios);

                    request.setAttribute("varMsg", true);
                    request.setAttribute("msg", "Cadastro de usuário realizado com sucesso!");

                    RequestDispatcher dispatcher = request.getRequestDispatcher("/ti/listagem_usuarios.jsp");
                    dispatcher.forward(request, response);
                } else if (sessao.getAttribute("nomeSetor") == null) {
                    request.setAttribute("varMsg", true);
                    request.setAttribute("msg", "Cadastro realizado com sucesso!");

                    RequestDispatcher dispatcher = request.getRequestDispatcher("../login/login.jsp");
                    dispatcher.forward(request, response);
                } else {
                    ArrayList<Produto> produtos = ProdutoDAO.getProdutos();
                    request.setAttribute("listaProdutos", produtos);

                    request.setAttribute("varMsg", true);
                    request.setAttribute("msg", "Cadastro realizado com sucesso!");
                    request.setAttribute("perfil", "endereco");

                    ArrayList<Usuario> enderecos = EnderecoDAO.getEnderecosUser(Integer.parseInt(uCodigoUsuario));
                    request.setAttribute("listaEnderecos", enderecos);

                    RequestDispatcher dispatcher = request.getRequestDispatcher("../ti/perfil.jsp");
                    dispatcher.forward(request, response);
                }
            } else {
                request.setAttribute("codigoUsuario", uCodigoUsuario);
                request.setAttribute("valorSetor", uSetorUsuario);

                request.setAttribute("varMsgError", true);
                request.setAttribute("msg", "Erro ao salvar os dados de endereço");

                RequestDispatcher dispatcher = request.getRequestDispatcher("/ti/cadastro_endereco.jsp");
                dispatcher.forward(request, response);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processaRequisicao(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processaRequisicao(request, response);
    }
}
