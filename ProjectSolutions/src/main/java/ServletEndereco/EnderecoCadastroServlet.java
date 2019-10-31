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

        String eUsuario = request.getParameter("codigoUsuario");
        String eCep = request.getParameter("cep");
        String eLogradouro = request.getParameter("logradouro");
        String eNumero = request.getParameter("numero");
        String eBairro = request.getParameter("bairro");
        String eCidade = request.getParameter("cidade");
        String eEstado = request.getParameter("estado");
        String eTipo = request.getParameter("tipoEndereco");

        boolean error = false;
        if (eUsuario.length() == 0) {
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

            request.setAttribute("codigo", eUsuario);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/ti/cadastro_endereco.jsp");
            dispatcher.forward(request, response);
        } else {
            Usuario usuario = new Usuario(Integer.parseInt(eUsuario), eLogradouro, Integer.parseInt(eNumero), eBairro, eCidade, eEstado, eCep, eTipo, Integer.parseInt(eUsuario));
            boolean httpOk = EnderecoDAO.salvarEndereco(usuario);

            if (httpOk) {
                HttpSession sessao = request.getSession();
                if ((sessao.getAttribute("nomeSetor") == null) || (!sessao.getAttribute("nomeSetor").equals("Cliente"))) {
                    ArrayList<Usuario> usuarios = UsuarioDAO.getUsuarios();
                    request.setAttribute("listaUsuarios", usuarios);

                    request.setAttribute("varMsg", true);
                    request.setAttribute("msg", "Cadastro de usuário realizado com sucesso!");

                    RequestDispatcher dispatcher = request.getRequestDispatcher("/ti/listagem_usuarios.jsp");
                    dispatcher.forward(request, response);
                } else {
                    ArrayList<Produto> produtos = ProdutoDAO.getProdutos();
                    request.setAttribute("listaProdutos", produtos);
                    request.setAttribute("varMsg", true);
                    request.setAttribute("msg", "Cadastro realizado com sucesso!");

                    RequestDispatcher dispatcher = request.getRequestDispatcher("../produtos/index.jsp");
                    dispatcher.forward(request, response);
                }
            } else {
                request.setAttribute("codigo", eUsuario);

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
