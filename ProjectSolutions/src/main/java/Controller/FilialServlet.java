/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.FilialDAO;
import Model.Filial;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guilherme.psilva103
 */
@WebServlet(name = "FilialServlet", urlPatterns = {"/ti/cdfilial"})
public class FilialServlet extends HttpServlet {

    private void processaRequisicao(String metodoHttp, HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        
        String fLogradouro = request.getParameter("logradouro");
        String fNumero = String.valueOf(request.getParameter("numero"));
        String fCep = request.getParameter("cep");
        String fBairro = request.getParameter("bairro");
        String fCidade = request.getParameter("cidade");
        String fEstado = request.getParameter("estado");
        String fTelefone = request.getParameter("telefone");
        
        
        Filial filial = new Filial(fLogradouro, Integer.parseInt(fNumero), fCep, fBairro, fCidade, fEstado, fTelefone);
        boolean httpOK = FilialDAO.salvarFilial(filial);

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
