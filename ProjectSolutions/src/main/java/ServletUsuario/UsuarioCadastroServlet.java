package ServletUsuario;

import DAO.UsuarioDAO;
import Model.Usuario;
import Utils.CpfValidator;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UsuarioCadastroServlet", urlPatterns = {"/ti/create_usuario"})
public class UsuarioCadastroServlet extends HttpServlet {

    private void processaRequisicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String cNome = request.getParameter("nome");
        String cEmail = request.getParameter("email");
        String cSenha = request.getParameter("senha");
        String cConfirmacaoSenha = request.getParameter("confirmarSenha");
        String cCpf = request.getParameter("cpf");
        String cSetor = request.getParameter("codigoSetor");
        String cCliente = request.getParameter("cliente");

        boolean error = false;
        if (cNome.length() == 0) {
            error = true;
            request.setAttribute("nomeErro", "Nome não informado");
        }
        if (cCpf.length() == 0 || !(cCpf.length() == 11)) {
            error = true;
            request.setAttribute("cpfErro", "O CPF deve conter 11 dígitos!");
        } else if (!CpfValidator.validaCpf(cCpf)) {
            error = true;
            request.setAttribute("cpfErro", "CPF contem caracteres inválidos!");
        }
        if (cEmail.length() == 0) {
            error = true;
            request.setAttribute("emailErro", "Email não informado");
        }
        if (cSenha.length() == 0) {
            error = true;
            request.setAttribute("senhaErro", "Senha não informada");
        }
        if (cConfirmacaoSenha.length() == 0) {
            error = true;
            request.setAttribute("cSenhaError", "Por Favor, Confirme a Senha digitada acima");
        }
        if ((cCliente == null) || (cCliente.length() == 0)) {
            if (cSetor == null) {
                error = true;
                request.setAttribute("setorErro", "Setor não informado");
            }
        }
        if (!error) {
            if (!cConfirmacaoSenha.equals(cSenha)) {
                error = true;
                request.setAttribute("varMsgError", true);
                request.setAttribute("cSenhaError", "Senhas não Coincidem");
                request.setAttribute("msg", "Senha e Confirmação de Senha são diferentes");
            }

            ArrayList<Usuario> infoBd = UsuarioDAO.getUsuarios();
            for (Usuario u : infoBd) {
                if (u.getEmail().equalsIgnoreCase(cEmail)) {
                    error = true;
                    request.setAttribute("emailErro", "O Email já foi cadastrado");
                    break;
                } else if (u.getCpf().equalsIgnoreCase(cCpf)) {
                    error = true;
                    request.setAttribute("cpfErro", "O CPF já foi cadastrado");
                    break;
                }
            }
        }

        if (error) {
            ArrayList<Usuario> setores = UsuarioDAO.getSetoresCadastro();
            request.setAttribute("listaSetores", setores);

            request.setAttribute("cliente", false);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/ti/cadastro_usuarios.jsp");
            dispatcher.forward(request, response);
        } else {
            int eIdUsuario;
            Usuario usuario = new Usuario(cNome, cEmail, cSenha, cCpf, Integer.parseInt(cSetor));
            eIdUsuario = UsuarioDAO.salvarUsuario(usuario);

            if (eIdUsuario > 0) {
                request.setAttribute("varMsg", true);
                request.setAttribute("msg", "Usuário cadastrado com sucesso! Cadastre agora um endereço.");

                request.setAttribute("codigo", eIdUsuario);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/ti/cadastro_endereco.jsp");
                dispatcher.forward(request, response);
            } else {
                if ((cCliente == null) || (cCliente.length() == 0)) {
                    request.setAttribute("varMsgError", true);
                    request.setAttribute("msg", "Erro ao realizar o cadastro, verifique os campos e tente novamente.");

                    request.setAttribute("cliente", false);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/ti/cadastro_usuarios.jsp");
                    dispatcher.forward(request, response);
                } else {
                    request.setAttribute("varMsgError", true);
                    request.setAttribute("msg", "Erro ao realizar o cadastro, tente novamente.");

                    RequestDispatcher dispatcher = request.getRequestDispatcher("/ti/cadastro_usuarios.jsp");
                    dispatcher.forward(request, response);
                }
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processaRequisicao(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processaRequisicao(req, resp);
    }

}
