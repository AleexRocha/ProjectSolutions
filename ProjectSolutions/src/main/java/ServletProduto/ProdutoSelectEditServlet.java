package ServletProduto;

import DAO.FilialDAO;
import DAO.ProdutoDAO;
import Model.Filial;
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
 * @author guilher.rsvieira
 */
@WebServlet(name = "ProdutoSelectEdit", urlPatterns = {"/produtos/dados_produto"})
public class ProdutoSelectEditServlet extends HttpServlet {

    private void processaRequisicao(String metodoHttp, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String pCodigo = request.getParameter("editarID");
        
        Produto produto = ProdutoDAO.getProduto(Integer.parseInt(pCodigo));
        ArrayList<Filial> filiais = FilialDAO.getFiliais();
        request.setAttribute("listaFiliais", filiais);
        
        request.setAttribute("acao", "editar");
        request.setAttribute("codigo", produto.getCodigo());
        request.setAttribute("nome", produto.getNome());
        request.setAttribute("descricao", produto.getDescricao());
        request.setAttribute("tipo", produto.getTipo());
        request.setAttribute("tipoCadastrado", produto.getTipo());
        request.setAttribute("cdFilialCadastrada", produto.getCodigoFilial());
        request.setAttribute("nomeFilialCadastrada", filiais.get(produto.getCodigoFilial()).getNomeFilial());
        request.setAttribute("listaFiliais", filiais);
        request.setAttribute("qtd_estoque", produto.getQuantidadeEstoque());
        request.setAttribute("valor_unidade", produto.getValorUnitario());        
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/produtos/cadastro_produtos.jsp");
        dispatcher.forward(request, response);
        
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