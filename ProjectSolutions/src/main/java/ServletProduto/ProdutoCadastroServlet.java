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
 * @author guilher.rsvieira
 */
@WebServlet(name = "ProdutoCadastroServlet", urlPatterns = {"/produtos/cadastro_produto"})
public class ProdutoCadastroServlet  extends HttpServlet {
    private void processaRequisicao(String metodoHttp, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fNome = request.getParameter("nome");
        String fDescricao = request.getParameter("descricao");
        String fTipo = request.getParameter("tipo");
        String fCodigoFilial = request.getParameter("filial");
        String fQuantidadeEstoque = request.getParameter("quantidadeEstoque");
        String fValorUnitario = request.getParameter("valorUnitario");
       

        boolean error = false;
        if (fNome.length() == 0) {
            error = true;
            request.setAttribute("nomeErro", "Nome não informado");
        }
        if (fDescricao.length() == 0) {
            error = true;
            request.setAttribute("descricaoErro", "Descrição não informada");
        }
        if (fTipo.length() == 0) {
            error = true;
            request.setAttribute("tipoErro", "Tipo não informado");
        }
        if (fCodigoFilial.length() == 0) {
            error = true;
            request.setAttribute("codigoFilialErro", "Código da Filial não informado");
        }
        if (fQuantidadeEstoque.length() == 0) {
            error = true;
            request.setAttribute("quantidadeEstoqueErro", "Quantidade em estoque não informada");
        }
        if (fValorUnitario.length() == 0) {
            error = true;
            request.setAttribute("valorUnitarioErro", "Valor unitário não informado");
        }
        

        if (error) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/produtos/cadastro_produtos.jsp");
            dispatcher.forward(request, response);
        } else {
            Produto produtos = new Produto(fNome, fDescricao, fTipo, Integer.parseInt(fCodigoFilial), Integer.parseInt(fQuantidadeEstoque) ,Double.parseDouble(fValorUnitario));
            boolean httpOK = ProdutoDAO.salvarProduto(produtos);

            if (httpOK) {
                ArrayList<Produto> produto = ProdutoDAO.getProdutos();
                request.setAttribute("lista", produto);
                
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
