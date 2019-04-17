/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.FilialDAO;
import Model.Filial;
import java.io.IOException;
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
@WebServlet(name = "FilialServlet", urlPatterns = {"/ti/editar_filial"})
public class FilialEditarServlet extends HttpServlet{

    private void processaRequisicao(String metodoHttp, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fCd_filial = String.valueOf(request.getParameter("codigo_filial"));
        
        Filial filial = FilialDAO.getFilial(Integer.parseInt(fCd_filial));
       

        /*if (httpOK) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ti/listagem_filiais.jsp");
        dispatcher.forward(request, response);
        } else {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ti/cadastro_filiais.jsp");
        dispatcher.forward(request, response);
        }*/

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
