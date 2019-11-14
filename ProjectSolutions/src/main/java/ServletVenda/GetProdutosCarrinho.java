/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletVenda;

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

        for (Produto produto : produtosCarrinho) {
            produtosInfo.add(ProdutoDAO.getProduto(produto.getCodigo()));
            System.out.println("Log-prtint: " + produto.getNome());
            System.out.println("Log-prtint: " + produto.getQuantidadeEstoque());
        }
        
        RequestDispatcher dipatcher = request.getRequestDispatcher("/venda/carrinho.jsp");
        dipatcher.forward(request, response);
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
