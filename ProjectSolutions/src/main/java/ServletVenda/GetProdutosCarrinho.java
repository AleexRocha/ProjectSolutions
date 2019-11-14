/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletVenda;

import DAO.ProdutoDAO;
import Model.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nicolas.hgyoshioka
 */
@WebServlet(name = "GetProdutosCarrinho", urlPatterns = {"/venda/carrinho"})
public class GetProdutosCarrinho extends HttpServlet {

    protected void processaRequisicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessao = request.getSession();
        ArrayList<Produto> produtosCarrinho = (ArrayList<Produto>) sessao.getAttribute("produtosCarrinho");
        ArrayList<Produto> produtosInfo = new ArrayList<>();
        
        for (int i = 0; i < produtosCarrinho.size(); i++) {
            produtosInfo.add(ProdutoDAO.getProduto(produtosCarrinho.get(i).getCodigo()));
            System.out.println(produtosInfo.get(i).getNome());
        }
       
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processaRequisicao(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processaRequisicao(request, response);
    }
}
