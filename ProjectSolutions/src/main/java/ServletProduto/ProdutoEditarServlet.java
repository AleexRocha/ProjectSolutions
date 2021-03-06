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

    private void processaRequisicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String fCodigo = request.getParameter("codigoProduto");
        String fNome = request.getParameter("nome");
        String fDescricao = request.getParameter("descricao");
        String fTipo = request.getParameter("tipo");
        String fQuantidadeEstoque = request.getParameter("quantidadeEstoque");
        String fValorUnitario = request.getParameter("valorUnitario");

        boolean error = false;
        if (fCodigo.length() == 0) {
            error = true;
            request.setAttribute("codigoErro", "Código não informado");
        }
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
            request.setAttribute("TipoErro", "Tipo não informado");
        }
        if (fQuantidadeEstoque.length() == 0) {
            error = true;
            request.setAttribute("quantidadeEstoqueErro", "Quantidade Estoque não informada");
        }
        if (fValorUnitario.length() == 0) {
            error = true;
            request.setAttribute("valorUnitarioErro", "Valor Unitário não informado");
        } else {
            String valorReplace;
            valorReplace = fValorUnitario.replace("R$", "");
            valorReplace = valorReplace.replace(",", ".");

            fValorUnitario = valorReplace;
        }

        if (error) {
            Produto produto = ProdutoDAO.getProduto(Integer.parseInt(fCodigo));

            request.setAttribute("acao", "editar");
            request.setAttribute("codigo", produto.getCodigo());
            request.setAttribute("nome", produto.getNome());
            request.setAttribute("descricao", produto.getDescricao());
            request.setAttribute("tipo", produto.getTipo());
            request.setAttribute("tipoCadastrado", produto.getTipo());
            request.setAttribute("qtd_estoque", produto.getQuantidadeEstoque());

            String valor_unitario = String.valueOf(produto.getValorUnitario()).replace(".", ",");
            request.setAttribute("valor_unidade", "R$" + valor_unitario);

            request.setAttribute("varMsg", true);
            request.setAttribute("msg", "Erro ao editar o produto, verifique os campos e tente novamente.");

            RequestDispatcher dispatcher = request.getRequestDispatcher("/produtos/cadastro_produtos.jsp");
            dispatcher.forward(request, response);
        } else {
            Produto produto = new Produto(fNome, fTipo, Integer.parseInt(fQuantidadeEstoque), Double.parseDouble(fValorUnitario));
            if (fDescricao.length() != 0) {
                produto.setDescricao(fDescricao);
            }
            produto.setCodigo(Integer.parseInt(fCodigo));
            boolean httpOK = ProdutoDAO.atualizarProduto(produto);

            if (httpOK) {
                ArrayList<Produto> produtos = ProdutoDAO.getProdutos();
                request.setAttribute("listaProdutos", produtos);

                request.setAttribute("varMsg", true);
                request.setAttribute("msg", "Produto editado com sucesso.");

                RequestDispatcher dispatcher = request.getRequestDispatcher("/produtos/listagem_produtos.jsp");
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("varMsg", true);
                request.setAttribute("msg", "Erro ao salvar edição no banco de dados, verifique os campos e tente novamente.");

                RequestDispatcher dispatcher = request.getRequestDispatcher("/produtos/cadastro_produtos.jsp");
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

}
