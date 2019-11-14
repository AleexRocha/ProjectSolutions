/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletVenda;

import DAO.UsuarioDAO;
import Model.Pagamento;
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
 * @author guilherme.pereira
 */
@WebServlet(name = "PagamentoCadastroServlet", urlPatterns = {"/ti/pagamento_cadastro"})
public class PagamentoCadastroServlet extends HttpServlet {

    private void processaRequisicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        int codigoUsuario = (int) session.getAttribute("cdFuncionario");
        String codPagamento = request.getParameter("codigoPagamento");
        String numeroPag = request.getParameter("numeroCartao");
        String nomeTitular = request.getParameter("nomeTitular");
        String dataVencimento = request.getParameter("dataVencimento");
        String ccv = request.getParameter("codigoSeguranca");
        boolean httpOK = true;

        if (codPagamento == null) {
            httpOK = false;
            request.setAttribute("pagamentoErro", "Selecione o tipo do pagamento");
        }
        if (numeroPag.equals("")) {
            httpOK = false;
            request.setAttribute("numPagErro", "Por favor, preencha o campo");
        }
        if (nomeTitular.equals("")) {
            httpOK = false;
            request.setAttribute("titularErro", "Por favor, preencha o campo");
        }
        if (dataVencimento.equals("")) {
            httpOK = false;
            request.setAttribute("dtVencimemntoErro", "Por favor, preencha o campo");
        }
        if (ccv.equals("")) {
            httpOK = false;
            request.setAttribute("ccvErro", "Por favor, preencha o campo");
        }

        if (httpOK) {
            Pagamento pagamento = new Pagamento(Integer.parseInt(codPagamento), null, numeroPag, nomeTitular, dataVencimento, ccv);
            boolean result = UsuarioDAO.salvarMetodoPagamento(pagamento, codigoUsuario);
            request.setAttribute("varMsg", true);
            request.setAttribute("msg", "Pagamento cadastrado com sucesso");
            if (!result) {
                request.setAttribute("varMsgError", true);
                request.setAttribute("msg", "Não foi possivel cadastrar o método de pagamento");
            }
        } else {
            request.setAttribute("varMsgError", true);
            request.setAttribute("msg", "Falha ao cadastrar, verifique os campos e tente novamente");
        }

        ArrayList<Pagamento> pagamentosDisponiveis = UsuarioDAO.getPagamentosDisponiveis();
        ArrayList<Pagamento> pagamentosCadastrados = UsuarioDAO.getPagamentosCadastrados(codigoUsuario);

        request.setAttribute("pagamentosList", pagamentosDisponiveis);
        request.setAttribute("pagamentosCadastrados", pagamentosCadastrados);
        request.setAttribute("perfil", "pagamento");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/ti/perfil.jsp");
        dispatcher.forward(request, response);
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
