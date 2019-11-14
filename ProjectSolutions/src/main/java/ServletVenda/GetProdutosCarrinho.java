/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletVenda;

import DAO.EnderecoDAO;
import DAO.ProdutoDAO;
import DAO.UsuarioDAO;
import Model.Pagamento;
import Model.Produto;
import Model.Usuario;
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

        if (produtosCarrinho != null) {
            String teste = request.getParameter("botao");
            if (teste.equalsIgnoreCase("1")) {
                ArrayList<Produto> checkoutInfo = new ArrayList<>();
                for (int i = 0; i < produtosCarrinho.size(); i++) {
                    Produto p = ProdutoDAO.getProduto(i);
                    checkoutInfo.add(p);
                }
                int codigoUsuario = (int) sessao.getAttribute("cdFuncionario");
                ArrayList<Pagamento> pagamentos = UsuarioDAO.getPagamentosCadastrados(codigoUsuario);
                ArrayList<Usuario> enderecos = EnderecoDAO.getEnderecosEntregaUser(codigoUsuario);

                request.setAttribute("produtosCarringo", checkoutInfo);
                request.setAttribute("metodosPagamento", pagamentos);
                request.setAttribute("enderecosEntrega", enderecos);

                RequestDispatcher dipatcher = request.getRequestDispatcher("/produtos/checkout.jsp");
                dipatcher.forward(request, response);
            } else {
                int i = 0;
                for (Produto prod : produtosCarrinho) {
                    Produto produto = ProdutoDAO.getProduto(prod.getCodigo());
                    produto.setQuantidadeEstoque(produtosCarrinho.get(i).getQuantidadeEstoque());

                    String valorTotal = String.format("%.2f", produto.getValorUnitario() * produtosCarrinho.get(i).getQuantidadeEstoque());
                    String newValorUnitario = String.format("%.2f", produto.getValorUnitario());
                    produto.setCodigo(prod.getCodigo());
                    produto.setValorCarrinho(newValorUnitario);
                    produto.setValorTotal(valorTotal);

                    produtosInfo.add(produto);

                    i++;
                }

                request.setAttribute("produtosCarrinho", produtosInfo);
                RequestDispatcher dipatcher = request.getRequestDispatcher("/produtos/carrinho.jsp");
                dipatcher.forward(request, response);
            }
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
