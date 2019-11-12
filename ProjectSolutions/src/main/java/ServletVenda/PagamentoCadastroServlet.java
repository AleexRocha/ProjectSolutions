/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletVenda;

import DAO.UsuarioDAO;
import Model.Pagamento;
import java.io.IOException;
import java.io.PrintWriter;
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
        int codPagamento = Integer.parseInt(request.getParameter("codigoPagamento"));
        String numeroPag = request.getParameter("numeroCartao");
        String nomeTitular = request.getParameter("nomeTitular");
        String dataVencimento = request.getParameter("dataVencimento");
        String ccv = request.getParameter("codigoSeguranca");
        
        Pagamento pagamento = new Pagamento(codPagamento, null, numeroPag, nomeTitular, dataVencimento, ccv);
        
        
        
        boolean result = UsuarioDAO.salvarMetodoPagamento(pagamento, codigoUsuario);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/venda/pagamento_cadastro.jsp");
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
