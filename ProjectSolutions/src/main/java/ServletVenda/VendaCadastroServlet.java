package ServletVenda;

import DAO.VendaDAO;
import Model.Venda;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guilherme.psilva103
 */
@WebServlet(name = "VendaCadastroServlet", urlPatterns = {"/venda/create_venda"})
public class VendaCadastroServlet extends HttpServlet {

    private void processaRequisicao(String metodoHttp, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String vCodProduto[] = (String[]) request.getParameterValues("codigoProduto");
        String vIdFuncionario = request.getParameter("idFuncionario");
        String vCpfCliente = request.getParameter("cpfCliente");
        String vCodFilial = request.getParameter("codigoFilial");
        String vQuantidade[] = (String[]) request.getParameterValues("quantidade");

        boolean error = false;
        if (vCodProduto == null) {
            error = true;
            request.setAttribute("codProdutoErro", "Produto invalido!");
        } else if (vCodProduto.equals("")) {
            error = true;
            request.setAttribute("codProdutoErro", "Produto invalido!");
        }
        if (vIdFuncionario == null) {
            error = true;
            request.setAttribute("idFuncErro", "Usuario invalido");
        } else if (vIdFuncionario.equalsIgnoreCase("0")) {
            error = true;
            request.setAttribute("idFuncErro", "Usuario invalido");
        }
        if (vCodFilial == null) {
            error = true;
            request.setAttribute("codFilialErro", "Filial invalida");
        } else if (vCodFilial.equalsIgnoreCase("0")) {
            error = true;
            request.setAttribute("codFilialErro", "Filial invalida");
        }
        if (vQuantidade == null) {
            error = true;
            request.setAttribute("quantidadeErro", "Quantidade invalida");
        } else if (vQuantidade.equals("")) {
            error = true;
            request.setAttribute("quantidadeErro", "Quantidade invalida");
        }

        if (error) {
            ArrayList<Venda> produtosVenda = VendaDAO.getProdutosVenda();
            ArrayList<Venda> usuariosVenda = VendaDAO.getUsuariosVenda();
            ArrayList<Venda> filiaisVenda = VendaDAO.getFiliaisVenda();

            if (produtosVenda.isEmpty()) {
                Venda uv = new Venda();

                uv.setNomeProduto("Não há produtos cadastrados");
                produtosVenda.add(uv);

                request.setAttribute("listaProdutos", produtosVenda);
            } else {
                request.setAttribute("listaProdutos", produtosVenda);
            }

            if (usuariosVenda.isEmpty()) {
                Venda uv = new Venda();

                uv.setNomeFuncionario("Não há usuarios cadastrados");
                usuariosVenda.add(uv);

                request.setAttribute("listaUsuarios", usuariosVenda);
            } else {
                request.setAttribute("listaUsuarios", usuariosVenda);
            }

            if (filiaisVenda.isEmpty()) {
                Venda uv = new Venda();

                uv.setNomeFilial("Não há filiais cadastradas");
                filiaisVenda.add(uv);

                request.setAttribute("listaFiliais", filiaisVenda);
            } else {
                request.setAttribute("listaFiliais", filiaisVenda);
            }

            request.setAttribute("varMsgE", true);
            request.setAttribute("msg", "Erro ao realizar o cadastro, verifique os campos e tente novamente.");

            RequestDispatcher dispatcher = request.getRequestDispatcher("/venda/cadastro_vendas.jsp");
            dispatcher.forward(request, response);
        } else {
            int[] cdProd = Arrays.stream(vCodProduto).mapToInt(Integer::parseInt).toArray();
            int[] qtdVenda = Arrays.stream(vQuantidade).mapToInt(Integer::parseInt).toArray();
            Venda venda = new Venda(cdProd, Integer.parseInt(vIdFuncionario), Integer.parseInt(vCodFilial), qtdVenda);
            if (vCpfCliente.length() != 0) {
                venda.setCpfCliente(vCpfCliente);
            }

            boolean httpOK = VendaDAO.salvarVenda(venda);
            if (httpOK) {
                request.setAttribute("varMsgS", true);
                request.setAttribute("msg", "Venda realizada com sucesso.");

                ArrayList<Venda> produtosVenda = VendaDAO.getProdutosVenda();
                request.setAttribute("listaProdutos", produtosVenda);

                RequestDispatcher dispatcher = request.getRequestDispatcher("/venda/cadastro_vendas.jsp");
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("varMsgE", true);
                request.setAttribute("msg", "Erro ao realizar o cadastro no banco de dados, verifique os campos e tente novamente.");

                RequestDispatcher dispatcher = request.getRequestDispatcher("/venda/cadastro_vendas.jsp");
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
