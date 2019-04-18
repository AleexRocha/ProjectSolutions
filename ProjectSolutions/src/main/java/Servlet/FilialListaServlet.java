/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.FilialDAO;
import Model.Filial;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
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
@WebServlet(name = "FilialListaServlet", urlPatterns = {"/ti/listagem_filiais"})
public class FilialListaServlet extends HttpServlet {

    private void processaRequisicao(String metodoHttp, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<Filial> filiais = FilialDAO.getFiliais();

        if (filiais.size() > 0) {

            request.setAttribute("lista", filiais);
            request.setAttribute("metodoHttp", metodoHttp);
            /*request.setAttribute("codigo", filiais.get(i).getCodigo());
                request.setAttribute("logradouro", filiais.get(i).getLogradouro());
                request.setAttribute("numero", filiais.get(i).getNumero());
                request.setAttribute("cep", filiais.get(i).getCep());
                request.setAttribute("bairro", filiais.get(i).getBairro());
                request.setAttribute("estado", filiais.get(i).getEstado());
                request.setAttribute("cidade", filiais.get(i).getCidade());
                request.setAttribute("telefone", filiais.get(i).getTelefone());*/

            RequestDispatcher dispatcher = request.getRequestDispatcher("/ti/listagem_filiais.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/ti/cadastro_filiais.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processaRequisicao("GET", req, resp); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processaRequisicao("POST", req, resp); //To change body of generated methods, choose Tools | Templates.
    }

}
