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
            String checkout = request.getParameter("checkout");
            if (checkout == null) {
                double calcSubtotal = 0;
                String subtotal;
                if ((sessao.getAttribute("cdFuncionario") == null) || (sessao.getAttribute("cdFuncionario").equals(""))) {
                    request.setAttribute("varMsgEndereco", true);
                    request.setAttribute("msg", "Faça login para calcular o frete.");
                } else {
                    int codigoUsuario = (int) sessao.getAttribute("cdFuncionario");
                    ArrayList<Usuario> enderecos = EnderecoDAO.getEnderecosEntregaUser(codigoUsuario);
                    request.setAttribute("enderecosEntrega", enderecos);
                }
                int i = 0;
                for (Produto prod : produtosCarrinho) {
                    Produto produto = ProdutoDAO.getProduto(prod.getCodigo());
                    produto.setQuantidadeEstoque(produtosCarrinho.get(i).getQuantidadeEstoque());

                    String valorTotal = String.format("%.2f", produto.getValorUnitario() * produtosCarrinho.get(i).getQuantidadeEstoque());
                    String newValorUnitario = String.format("%.2f", produto.getValorUnitario());
                    produto.setIdCarrinho(i + 1);
                    produto.setCodigo(prod.getCodigo());
                    produto.setValorCarrinho(newValorUnitario);
                    produto.setValorTotal(valorTotal);

                    calcSubtotal += Double.parseDouble(valorTotal.replace(",", "."));

                    produtosInfo.add(produto);

                    i++;
                }

                subtotal = String.valueOf(calcSubtotal).replace(".", ",");

                request.setAttribute("subtotal", subtotal);
                request.setAttribute("varMsgTabela", false);
                request.setAttribute("produtosCarrinho", produtosInfo);
                RequestDispatcher dipatcher = request.getRequestDispatcher("/produtos/carrinho.jsp");
                dipatcher.forward(request, response);
            } else if ((sessao.getAttribute("cdFuncionario") == null) || (sessao.getAttribute("cdFuncionario").equals(""))) {
                request.setAttribute("varMsgError", true);
                request.setAttribute("msg", "Faça login para continuar");
                RequestDispatcher dipatcher = request.getRequestDispatcher("/login/login.jsp");
                dipatcher.forward(request, response);
            } else {
                ArrayList<Produto> checkoutInfo = new ArrayList<>();
                int codigoUsuario = (int) sessao.getAttribute("cdFuncionario");

                int i = 0;
                for (Produto prod : produtosCarrinho) {
                    Produto p = ProdutoDAO.getProduto(prod.getCodigo());
                    p.setQuantidadeEstoque(produtosCarrinho.get(i).getQuantidadeEstoque());

                    String valorTotal = String.format("%.2f", p.getValorUnitario() * produtosCarrinho.get(i).getQuantidadeEstoque());
                    String newValorUnitario = String.format("%.2f", p.getValorUnitario());
                    p.setCodigo(prod.getCodigo());
                    p.setValorUnitario(Double.parseDouble(newValorUnitario.replace(",", ".")));
                    p.setValorTotal(valorTotal);

                    checkoutInfo.add(p);

                    i++;
                }

                ArrayList<Pagamento> pagamentos = UsuarioDAO.getPagamentosCadastrados(codigoUsuario);
                ArrayList<Usuario> enderecos = EnderecoDAO.getEnderecosEntregaUser(codigoUsuario);

                request.setAttribute("produtosCarrinho", checkoutInfo);
                request.setAttribute("metodosPagamento", pagamentos);
                request.setAttribute("enderecosEntrega", enderecos);

                RequestDispatcher dipatcher = request.getRequestDispatcher("/produtos/checkout.jsp");
                dipatcher.forward(request, response);
            }
        } else {
            request.setAttribute("varMsgTabela", true);
            request.setAttribute("msg", "Adicione produtos ao carrinho para ve-los aqui.");
            RequestDispatcher dipatcher = request.getRequestDispatcher("/produtos/carrinho.jsp");
            dipatcher.forward(request, response);
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
