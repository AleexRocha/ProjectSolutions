package ServletProduto;

import DAO.FilialDAO;
import DAO.ImagemDAO;
import DAO.ProdutoDAO;

import Model.Filial;
import Model.Imagem;
import Model.Produto;

import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guilher.rsvieira
 */
@MultipartConfig
@WebServlet(name = "ProdutoCadastroServlet", urlPatterns = {"/produtos/cadastro_produto"})
public class ProdutoCadastroServlet extends HttpServlet {

    private void processaRequisicao(String metodoHttp, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean formularioOK = validaCamposForm(request);
        request.setCharacterEncoding("UTF-8");
        String fIdImagem = request.getParameter("codigoImagem");

        if (fIdImagem == null) {
            request.setAttribute("varMsg", true);
            request.setAttribute("msg", "Salve uma imagem para cadastrar um produto");

            ArrayList<Filial> filiais = FilialDAO.getFiliais();
            request.setAttribute("listaFiliais", filiais);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/produtos/cadastro_produtos.jsp");
            dispatcher.forward(request, response);
        }

        String fNome = request.getParameter("nome");
        String fDescricao = request.getParameter("descricao");
        String fTipo = request.getParameter("tipo");
        String fCodigoFilial = request.getParameter("codigoFilial");
        String fQuantidadeEstoque = request.getParameter("quantidadeEstoque");
        String fValorUnitario = request.getParameter("valorUnitario");
        String valorReplace;
        valorReplace = fValorUnitario.replace("R$", "");
        valorReplace = valorReplace.replace(",", ".");
        fValorUnitario = valorReplace;

        if (!formularioOK) {
            HashMap<String, String> camposInvalidos = informaCamposIncorretos(request);
            if (camposInvalidos.get("nomeErro") != null) {
                request.setAttribute("nomeErro", camposInvalidos.get("nomeErro"));
            }
            if (camposInvalidos.get("tipoErro") != null) {
                request.setAttribute("tipoErro", camposInvalidos.get("tipoErro"));
            }
            if (camposInvalidos.get("CodigoFilialErro") != null) {
                request.setAttribute("codigoFilialErro", camposInvalidos.get("codigoFilialErro"));
            }
            if (camposInvalidos.get("quantidadeEstoqueErro") != null) {
                request.setAttribute("quantidadeEstoqueErro", camposInvalidos.get("quantidadeEstoqueErro"));
            }
            if (camposInvalidos.get("valorUnitarioErro") != null) {
                request.setAttribute("valorUnitarioErro", camposInvalidos.get("valorUnitarioErro"));
            }

            ArrayList<Filial> filiais = FilialDAO.getFiliais();
            request.setAttribute("listaFiliais", filiais);

            request.setAttribute("listaImagens", fIdImagem);
            request.setAttribute("id", fIdImagem);

            request.setAttribute("varMsg", true);
            request.setAttribute("msg", "Erro ao realizar o cadastro, verifique os campos e tente novamente.");

            RequestDispatcher dispatcher = request.getRequestDispatcher("/produtos/cadastro_produtos.jsp");
            dispatcher.forward(request, response);
        } else {
            int idProduto = 0;
            boolean httpOK = false;

            Produto produtos = new Produto(fNome, fTipo, Integer.parseInt(fCodigoFilial), Integer.parseInt(fQuantidadeEstoque), Double.parseDouble(fValorUnitario));
            if (fDescricao.length() != 0) {
                produtos.setDescricao(fDescricao);
            }
//            boolean httpOK = ProdutoDAO.salvarProduto(produtos);
            idProduto = ProdutoDAO.salvarProduto(produtos);
            if (idProduto > 0) {
                Imagem imagem = new Imagem(Integer.parseInt(fIdImagem), idProduto);
                httpOK = ImagemDAO.atualizaProdutoImagem(imagem);
            }

            if (httpOK) {
                ArrayList<Produto> produto = ProdutoDAO.getProdutos();
                request.setAttribute("listaProdutos", produto);

                request.setAttribute("varMsg", true);
                request.setAttribute("msg", "Cadastro realizado com sucesso.");

                RequestDispatcher dispatcher = request.getRequestDispatcher("/produtos/listagem_produtos.jsp");
                dispatcher.forward(request, response);
            } else {
                ArrayList<Filial> filiais = FilialDAO.getFiliais();
                request.setAttribute("listaFiliais", filiais);

                request.setAttribute("varMsg", true);
                request.setAttribute("msg", "Erro ao realizar o cadastro no banco de dados, verifique os campos e tente novamente.");

                request.setAttribute("listaImagens", fIdImagem);
                request.setAttribute("id", fIdImagem);

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

    private boolean validaCamposForm(HttpServletRequest request) {
        String fNome = request.getParameter("nome");
        String fTipo = request.getParameter("tipo");
        String fCodigoFilial = request.getParameter("codigoFilial");
        String fQuantidadeEstoque = request.getParameter("quantidadeEstoque");
        String fValorUnitario = request.getParameter("valorUnitario");

        if (fNome.length() == 0) {
            return false;
        }
        if (fTipo == null) {
            return false;
        }
        if (fCodigoFilial == null) {
            return false;
        }
        if (fQuantidadeEstoque.length() == 0) {
            return false;
        }
        if (fValorUnitario.length() == 0) {
            return false;
        }

        return true;
    }

    private HashMap<String, String> informaCamposIncorretos(HttpServletRequest request) {
        HashMap<String, String> camposInvalidos = new HashMap();
        String fNome = request.getParameter("nome");
        String fTipo = request.getParameter("tipo");
        String fCodigoFilial = request.getParameter("codigoFilial");
        String fQuantidadeEstoque = request.getParameter("quantidadeEstoque");
        String fValorUnitario = request.getParameter("valorUnitario");

        if (fNome.length() == 0) {
            camposInvalidos.put("nomeErro", "Nome não informado");
        }
        if (fTipo == null) {
            camposInvalidos.put("tipoErro", "Tipo não informado");
        }
        if (fCodigoFilial == null) {
            camposInvalidos.put("codigoFilialErro", "Filial não informada");
        }
        if (fQuantidadeEstoque.length() == 0) {
            camposInvalidos.put("quantidadeEstoqueErro", "Quantidade em estoque não informada");
        }
        if (fValorUnitario.length() == 0) {
            camposInvalidos.put("valorUnitarioErro", "Valor unitário não informado");
        }

        return camposInvalidos;
    }

}
