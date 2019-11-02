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
@WebServlet(name = "EnderecoEditarCadastro", urlPatterns = {"/ti/update_endereco"})
public class EnderecoEditarCadastro extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String uCodigoUsuario = request.getParameter("codigoUsuario");
        String uSetorUsuario = request.getParameter("valorSetor");
        String eEndereco = request.getParameter("codigoEndereco");
        String eCep = request.getParameter("cep");
        String eLogradouro = request.getParameter("logradouro");
        String eNumero = request.getParameter("numero");
        String eBairro = request.getParameter("bairro");
        String eCidade = request.getParameter("cidade");
        String eEstado = request.getParameter("estado");
        String eTipo = request.getParameter("tipoEndereco");

        boolean error = false;
        if (eEndereco.length() == 0) {
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
            Usuario usuario = EnderecoDAO.getEnderecoUser(Integer.parseInt(uCodigoUsuario));

            request.setAttribute("codigoUsuario", usuario.getCodigoUsuario());
            request.setAttribute("valorSetor", uSetorUsuario);
            request.setAttribute("codigoEndereco", usuario.getCodigoEndereco());
            request.setAttribute("cep", usuario.getCep());
            request.setAttribute("logradouro", usuario.getLogradouro());
            request.setAttribute("numero", usuario.getNumero());
            request.setAttribute("bairro", usuario.getBairro());
            request.setAttribute("cidade", usuario.getCidade());
            request.setAttribute("estado", usuario.getEstado());
            request.setAttribute("tipoEndereco", usuario.getTipoEndereco());

            request.setAttribute("acao", "editar");

            request.setAttribute("varMsgError", true);
            request.setAttribute("msg", "Erro ao editar o endereço, verifique os campos e tente novamente.");

            RequestDispatcher dispatcher = request.getRequestDispatcher("/ti/cadastro_endereco.jsp");
            dispatcher.forward(request, response);
        } else {
            Usuario usuario = new Usuario(Integer.parseInt(eEndereco), eLogradouro, Integer.parseInt(eNumero), eBairro, eCidade, eEstado, eCep, eTipo, Integer.parseInt(uCodigoUsuario));
            usuario.setCodigoUsuario(Integer.parseInt(uCodigoUsuario));

            boolean httpOk = EnderecoDAO.alterarEndereco(usuario);

            if (httpOk) {
                ArrayList<Usuario> enderecos = EnderecoDAO.getEnderecosUser(Integer.parseInt(uCodigoUsuario));

                request.setAttribute("listaEnderecos", enderecos);

                request.setAttribute("perfil", "endereco");

                request.setAttribute("varMsg", true);
                request.setAttribute("msg", "Endereço editado com sucesso.");

                RequestDispatcher dispatcher = request.getRequestDispatcher("/ti/perfil.jsp");
                dispatcher.forward(request, response);
            }
        }
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
