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
@WebServlet(name = "ProdutoCadastroServlet", urlPatterns = {"/produtos/cadastro_produto"})
public class ProdutoCadastroServlet extends HttpServlet {

    private void processaRequisicao(String metodoHttp, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fNome = request.getParameter("nome");
        String fDescricao = request.getParameter("descricao");
        String fTipo = request.getParameter("tipo");
        String fCodigoFilial = request.getParameter("codigoFilial");
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
        if (fCodigoFilial == null) {
            error = true;
            request.setAttribute("codigoFilialErro", "Filial não informada");
        }
        if (fQuantidadeEstoque.length() == 0) {
            error = true;
            request.setAttribute("quantidadeEstoqueErro", "Quantidade em estoque não informada");
        }
        if (fValorUnitario.length() == 0) {
            error = true;
            request.setAttribute("valorUnitarioErro", "Valor unitário não informado");
        } else {
            String valorReplace;
            valorReplace = fValorUnitario.replace("R$", "");
            valorReplace = valorReplace.replace(",", ".");

            fValorUnitario = valorReplace;
        }

        if (error) {
            ArrayList<Filial> filiais = FilialDAO.getFiliais();
            request.setAttribute("listaFiliais", filiais);

            request.setAttribute("varMsg", true);
            request.setAttribute("msg", "Erro ao realizar o cadastro, verifique os campos e tente novamente.");

            RequestDispatcher dispatcher = request.getRequestDispatcher("/produtos/cadastro_produtos.jsp");
            dispatcher.forward(request, response);
        } else {
            Produto produtos = new Produto(fNome, fDescricao, fTipo, Integer.parseInt(fCodigoFilial), Integer.parseInt(fQuantidadeEstoque), Double.parseDouble(fValorUnitario));
            boolean httpOK = ProdutoDAO.salvarProduto(produtos);

            if (httpOK) {
                ArrayList<Produto> produto = ProdutoDAO.getProdutos();
                request.setAttribute("lista", produto);

                request.setAttribute("varMsg", true);
                request.setAttribute("msg", "Cadastro realizado com sucesso.");

                RequestDispatcher dispatcher = request.getRequestDispatcher("/produtos/listagem_produtos.jsp");
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("varMsg", true);
                request.setAttribute("msg", "Erro ao realizar o cadastro no banco de dados, verifique os campos e tente novamente.");

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
