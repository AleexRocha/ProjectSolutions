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
 * @author guilherme.pereira
 */
@WebServlet(name = "ProdutoEditarServlet", urlPatterns = {"/produtos/editar_produto"})
public class ProdutoEditarServlet extends HttpServlet {

    private void processaRequisicao(String metodoHttp, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fCodigo = request.getParameter("codigoProduto");
        String fNome = request.getParameter("nome");
        String fDescricao = request.getParameter("descricao");
        String fTipo = request.getParameter("tipo");
        String fCodigoFilial = request.getParameter("codigoFilial");
        String fQuantidadeEstoque = request.getParameter("quantidadeEstoque");
        String fValorUnitario = request.getParameter("valorUnitario");

        boolean error = false;
        if (fCodigo.length() == 0) {
            error = true;
            request.setAttribute("codigoErro", "Codigo não informado");
        }
        if (fNome.length() == 0) {
            error = true;
            request.setAttribute("nomeErro", "Nome não informado");
        }
        if (fDescricao.length() == 0) {
            error = true;
            request.setAttribute("descricaoErro", "Descricao não informado");
        }
        if (fTipo.length() == 0) {
            error = true;
            request.setAttribute("TipoErro", "tipo não informado");
        }
        if (fCodigoFilial.length() == 0) {
            error = true;
            request.setAttribute("filialErro", "Filial não informado");
        }
        if (fQuantidadeEstoque.length() == 0) {
            error = true;
            request.setAttribute("quantidadeEstoqueErro", "QuantidadeEstoque não informada");
        }
        if (fValorUnitario.length() == 0) {
            error = true;
            request.setAttribute("valorUnitarioErro", "Valor Unitario não informado");
        }

        if (error) {
            Produto produto = ProdutoDAO.getProduto(Integer.parseInt(fCodigo));

            request.setAttribute("acao", "editar");
            request.setAttribute("codigo", produto.getCodigo());
            request.setAttribute("nome", produto.getNome());
            request.setAttribute("descricao", produto.getDescricao());
            request.setAttribute("tipo", produto.getTipo());
            request.setAttribute("codigoFilial", produto.getCodigoFilial());
            request.setAttribute("quantidadeEstoque", produto.getQuantidadeEstoque());
            request.setAttribute("valorUnitario", produto.getValorUnitario());

            RequestDispatcher dispatcher = request.getRequestDispatcher("/produtos/cadastro_produtos.jsp");
            dispatcher.forward(request, response);

        } else {
            Produto produto = new Produto(fNome, fDescricao, fTipo,Integer.parseInt(fCodigoFilial) , Integer.parseInt(fQuantidadeEstoque), Double.parseDouble(fValorUnitario));
            produto.setCodigo(Integer.parseInt(fCodigo));
            boolean httpOK = ProdutoDAO.atualizarProduto(produto);

            if (httpOK) {
                ArrayList<Produto> produtos = ProdutoDAO.getProdutos();
                request.setAttribute("lista", produtos);

                RequestDispatcher dispatcher = request.getRequestDispatcher("/produtos/listagem_produtos.jsp");
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/produtos/cadastro_produtos.jsp");
                dispatcher.forward(request, response);
            }
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
