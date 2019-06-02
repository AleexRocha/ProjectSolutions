package ServletVenda;

import DAO.RelatorioDAO;
import DAO.VendaDAO;
import Model.Relatorio;
import Model.Venda;
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
 * @author Alexsander Rocha
 */
@WebServlet(name = "EstornoListaSelect", urlPatterns = {"/venda/select_estorno"})
public class EstornoListaSelect extends HttpServlet {

    private void processaRequisicao(String metodoHttp, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String eCodProduto = request.getParameter("codigoProduto");
        String eCodFilial = request.getParameter("codigoFilial");
        String eCpfCliente = request.getParameter("cpfCliente");

        boolean error = false;
        if (eCodProduto != null) {
            ArrayList<Relatorio> estorno = RelatorioDAO.getEstornoProduto(eCodProduto);
            request.setAttribute("listaEstornos", estorno);
        } else if (eCodFilial != null) {
            ArrayList<Relatorio> estorno = RelatorioDAO.getEstornoFilial(eCodFilial);
            request.setAttribute("listaEstornos", estorno);
        } else if (!eCpfCliente.equalsIgnoreCase("")) {
            ArrayList<Relatorio> estorno = RelatorioDAO.getEstornoCpf(eCpfCliente);
            request.setAttribute("listaEstornos", estorno);
        } else {
            error = true;
        }

        if (error) {
            ArrayList<Venda> produtosVenda = VendaDAO.getProdutosVenda();
            ArrayList<Venda> filiaisVenda = VendaDAO.getFiliaisVenda();

            if (produtosVenda.isEmpty()) {
                Venda uv = new Venda();

                uv.setNomeProduto("Não há produtos cadastrados");
                produtosVenda.add(uv);

                request.setAttribute("listaProdutos", produtosVenda);
            } else {
                request.setAttribute("listaProdutos", produtosVenda);
            }

            if (filiaisVenda.isEmpty()) {
                Venda uv = new Venda();

                uv.setNomeFilial("Não há filiais cadastradas");
                filiaisVenda.add(uv);

                request.setAttribute("listaFiliais", filiaisVenda);
            } else {
                request.setAttribute("listaFiliais", filiaisVenda);
            }

            request.setAttribute("varMsg", true);
            request.setAttribute("msg", "Escolha um filtro para gerar o relátorio.");
        } else {
            ArrayList<Venda> produtosVenda = VendaDAO.getProdutosVenda();
            ArrayList<Venda> filiaisVenda = VendaDAO.getFiliaisVenda();

            if (produtosVenda.isEmpty()) {
                Venda uv = new Venda();

                uv.setNomeProduto("Não há produtos cadastrados");
                produtosVenda.add(uv);

                request.setAttribute("listaProdutos", produtosVenda);
            } else {
                request.setAttribute("listaProdutos", produtosVenda);
            }

            if (filiaisVenda.isEmpty()) {
                Venda uv = new Venda();

                uv.setNomeFilial("Não há filiais cadastradas");
                filiaisVenda.add(uv);

                request.setAttribute("listaFiliais", filiaisVenda);
            } else {
                request.setAttribute("listaFiliais", filiaisVenda);
            }
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/venda/estorno.jsp");
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
