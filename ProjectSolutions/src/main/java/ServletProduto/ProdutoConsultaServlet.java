/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletProduto;

import DAO.ProdutoDAO;
import Model.Produto;
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
 * @author guilherme.psilva103
 */
@WebServlet(name = "ProdutoConsultarServlet", urlPatterns = {"/produtos/descricao"})
public class ProdutoConsultaServlet extends HttpServlet {

    private void processaRequisicao(String metodoHttp, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String codigoProuto = request.getParameter("consultarID");

        Produto produtoConsulta = ProdutoDAO.getProduto(Integer.parseInt(codigoProuto));

        if (produtoConsulta != null) {
            request.setAttribute("infosProduto", produtoConsulta);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/produtos/descricao_produto.jsp");
            dispatcher.forward(request, response);
        } else {
            ArrayList<Produto> produtos = ProdutoDAO.getProdutos();
            request.setAttribute("listaProdutos", produtos);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/produtos/listagem_produtos.jsp");
            dispatcher.forward(request, response);
        }
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
