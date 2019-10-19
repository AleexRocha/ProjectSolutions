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
        } else if (cNome.length() < 5) {
            error = true;
            request.setAttribute("nomeErro", "Nome deve conter 5 caracteres");
        }
//         if (cCpf.length() == 0) {
//            error = true;
//            request.setAttribute("cpfErro", "CPF não informado");
//        } 
//         if(!CpfValidator.validaCpf(cCpf)){
//             error = true;
//             request.setAttribute("cpfErro", "CPF inválido!");
//         }
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
        }

        if (error) {
            ArrayList<Usuario> setores = UsuarioDAO.getSetoresCadastro();
            request.setAttribute("listaSetores", setores);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/ti/cadastro_usuarios.jsp");
            dispatcher.forward(request, response);
        } else {
            Usuario usuario = new Usuario(cNome, cEmail, cSenha, cCpf, Integer.parseInt(cSetor));
            boolean httpOK = UsuarioDAO.salvarUsuario(usuario);

            if (httpOK) {
                if ((cCliente == null) || (cCliente.length() == 0)) {
                    ArrayList<Usuario> usuarios = UsuarioDAO.getUsuarios();
                    request.setAttribute("listaUsuarios", usuarios);

                    request.setAttribute("varMsg", true);
                    request.setAttribute("msg", "Cadastro realizado com sucesso.");

                    RequestDispatcher dispatcher = request.getRequestDispatcher("/ti/listagem_usuarios.jsp");
                    dispatcher.forward(request, response);
                } else {
                    request.setAttribute("varMsg", true);
                    request.setAttribute("msg", "Cadastro realizado com sucesso.");

                    RequestDispatcher dispatcher = request.getRequestDispatcher("../login/index.jsp");
                    dispatcher.forward(request, response);
                }
            } else {
                if ((cCliente == null) || (cCliente.length() == 0)) {
                    request.setAttribute("varMsgError", true);
                    request.setAttribute("msg", "Erro ao realizar o cadastro, verifique os campos e tente novamente.");

                    RequestDispatcher dispatcher = request.getRequestDispatcher("/ti/cadastro_usuarios.jsp");
                    dispatcher.forward(request, response);
                } else {
                    request.setAttribute("varMsgError", true);
                    request.setAttribute("msg", "Erro ao realizar o cadastro, tente novamente.");

                    RequestDispatcher dispatcher = request.getRequestDispatcher("../login/index.jsp");
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
