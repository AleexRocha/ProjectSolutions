package ServletProduto;

import DAO.EnderecoDAO;
import DAO.ProdutoDAO;
import Model.Produto;
import Model.Usuario;

import java.io.IOException;
import java.text.DecimalFormat;
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
 * @author nicolas.yoshioka
 */
@WebServlet(name = "ProdutoCarrinhoServlet", urlPatterns = {"/produtos/carrinho_produtos"})
public class ProdutoCarrinhoServlet extends HttpServlet {

    private void processaRequisicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessao = request.getSession();
        String id = (String) request.getParameter("addCarrinho");
        String metodo = request.getParameter("metodo");
        String codigoProduto = request.getParameter("codigoProduto");
        String quantidadeAddDescricao = request.getParameter("quantidadeAdd");

        Produto produto = new Produto();

        String removerId = request.getParameter("idRemover");
        if (removerId != null && !removerId.isEmpty()) {
            ArrayList<Produto> produtosCarrinho = (ArrayList<Produto>) sessao.getAttribute("produtosCarrinho");
            ArrayList<Produto> produtosInfo = new ArrayList<>();
            DecimalFormat df = new DecimalFormat("#,###.00");

            for (Produto prod : produtosCarrinho) {
                if (removerId.equals(String.valueOf(prod.getCodigo()))) {
                    produtosCarrinho.remove(prod);
                    break;
                }
            }

            sessao.removeAttribute("produtosCarrinho");
            sessao.setAttribute("produtosCarrinho", produtosCarrinho);

            int i = 0;
            double subtotal = 0;
            for (Produto prod : produtosCarrinho) {
                Produto pro = ProdutoDAO.getProduto(prod.getCodigo());
                pro.setQuantidadeEstoque(produtosCarrinho.get(i).getQuantidadeEstoque());

                String valorTotal = String.format("%.2f", pro.getValorUnitario() * produtosCarrinho.get(i).getQuantidadeEstoque());
                String newValorUnitario = String.format("%.2f", pro.getValorUnitario());
                pro.setIdCarrinho(i + 1);
                pro.setCodigo(prod.getCodigo());
                pro.setValorCarrinho(newValorUnitario);
                pro.setValorTotal(valorTotal);

                subtotal += Double.parseDouble(valorTotal.replace(",", "."));

                produtosInfo.add(pro);

                i++;
            }
            if ((sessao.getAttribute("cdFuncionario") == null) || (sessao.getAttribute("cdFuncionario").equals(""))) {
                request.setAttribute("varMsgTabela", false);
                request.setAttribute("varMsgEndereco", true);
                request.setAttribute("msg", "Faça login para calcular o frete.");
            } else if ((produtosCarrinho.isEmpty())) {
                request.setAttribute("varMsgTabela", true);
                request.setAttribute("msg", "Adicione produtos ao carrinho para ver aqui");
            } else {
                int codigoUsuario = (int) sessao.getAttribute("cdFuncionario");
                ArrayList<Usuario> enderecos = EnderecoDAO.getEnderecosEntregaUser(codigoUsuario);
                request.setAttribute("enderecosEntrega", enderecos);
                request.setAttribute("varMsgTabela", false);
            }
            request.setAttribute("subtotal", df.format(subtotal));
            request.setAttribute("produtosCarrinho", produtosInfo);
            if (produtosInfo.isEmpty()) {
                request.setAttribute("varMsgTabela", true);
                request.setAttribute("msg", "Adicione produtos ao carrinho para ve-los aqui.");
            }
            RequestDispatcher dipatcher = request.getRequestDispatcher("/produtos/carrinho.jsp");
            dipatcher.forward(request, response);
        } else {
            if (metodo.equals("index")) {
                produto.setCodigo(Integer.parseInt(id));
                produto.setQuantidadeEstoque(1);
            } else {
                produto.setCodigo(Integer.parseInt(codigoProduto));
                produto.setQuantidadeEstoque(Integer.parseInt(quantidadeAddDescricao));
            }

            if (sessao.getAttribute("nomeSetor") == null) {
                sessao = setSessao(request);
                ArrayList<Produto> produtosCarrinho = new ArrayList<>();
                produtosCarrinho.add(produto);
                sessao.setAttribute("produtosCarrinho", produtosCarrinho);
            } else if (sessao.getAttribute("nomeSetor").equals("Cliente")) {
                ArrayList<Produto> produtosCarrinho = (ArrayList<Produto>) sessao.getAttribute("produtosCarrinho");
                produtosCarrinho.add(produto);
                sessao.removeAttribute("produtosCarrinho");
                sessao.setAttribute("produtosCarrinho", produtosCarrinho);
            } else {
                ArrayList<Produto> produtosCarrinho = (ArrayList<Produto>) sessao.getAttribute("produtosCarrinho");
                produtosCarrinho.add(produto);
                sessao.removeAttribute("produtosCarrinho");
                sessao.setAttribute("produtosCarrinho", produtosCarrinho);
            }

            if (metodo.equals("index")) {
                ArrayList<Produto> produtos = ProdutoDAO.getProdutos();
                request.setAttribute("listaProdutos", produtos);
                request.setAttribute("varMsg", true);
                request.setAttribute("msg", "Adicionado no carrinho com sucesso");
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            } else {
                Produto prod = ProdutoDAO.getProduto(Integer.parseInt(codigoProduto));
                request.setAttribute("produto", prod);
                request.setAttribute("varMsg", true);
                request.setAttribute("msg", "Adicionado no carrinho com sucesso");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/produtos/descricao_produto.jsp");
                dispatcher.forward(request, response);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processaRequisicao(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processaRequisicao(req, resp);
    }

    private HttpSession setSessao(HttpServletRequest request) {
        HttpSession sessao = request.getSession();
        ArrayList<Produto> produtosCarrinho = new ArrayList<>();
        sessao.setAttribute("produtosCarrinho", produtosCarrinho);
        sessao.setAttribute("cdFuncionario", "");
        sessao.setAttribute("nomeUsuario", "");
        sessao.setAttribute("nomeSetor", "");
        sessao.setAttribute("cdSetor", "");
        sessao.setAttribute("emailUsuario", "");
        sessao.setAttribute("cpfUsuario", "");

        return sessao;
    }

}
