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

/**
 *
 * @author guilherme.pereira
 */
@WebServlet(name = "PagamentoListaCadastrados", urlPatterns = {"/ti/pagamento_listagem"})
public class PagamentoListaCadastrados extends HttpServlet {
 
    private void processaRequisicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String idUsuario = request.getParameter("idUsuario");
        ArrayList<Pagamento> pagamentosCadastrados = UsuarioDAO.getPagamentosCadastrados(Integer.parseInt(idUsuario));
        request.setAttribute("pagamentosCadastrados", pagamentosCadastrados);
        
        ArrayList<Pagamento> pagamentosDisponiveis = UsuarioDAO.getPagamentosDisponiveis(true);
        request.setAttribute("pagamentosList", pagamentosDisponiveis);
        
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
