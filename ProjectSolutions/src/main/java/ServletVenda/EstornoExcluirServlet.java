package ServletVenda;

import DAO.VendaDAO;
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
@WebServlet(name = "EstornoExcluirServlet", urlPatterns = {"/venda/delete_venda"})
public class EstornoExcluirServlet extends HttpServlet {

    protected void processaRequisicao(String HttpMethod, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fCodigo = request.getParameter("excluirID");

        boolean error = false;
        if (fCodigo == null) {
            error = true;
            request.setAttribute("codigoErro", "Codigo não informado");
        }

        if (error) {
            ArrayList<Venda> produtosVenda = VendaDAO.getProdutosVenda();

            if (produtosVenda.isEmpty()) {
                Venda uv = new Venda();

                uv.setNomeProduto("Não há produtos cadastrados");
                produtosVenda.add(uv);

                request.setAttribute("listaProdutos", produtosVenda);
            } else {
                request.setAttribute("listaProdutos", produtosVenda);
            }

            request.setAttribute("varMsgErro", true);
            request.setAttribute("msg", "Erro ao estornar a venda, selecione uma venda.");

            RequestDispatcher dispatcher = request.getRequestDispatcher("/venda/estorno.jsp");
            dispatcher.forward(request, response);
        } else {
            boolean httpOk = VendaDAO.excluirVenda(Integer.parseInt(fCodigo));
            if (httpOk) {
                ArrayList<Venda> produtosVenda = VendaDAO.getProdutosVenda();

                if (produtosVenda.isEmpty()) {
                    Venda uv = new Venda();

                    uv.setNomeProduto("Não há produtos cadastrados");
                    produtosVenda.add(uv);

                    request.setAttribute("listaProdutos", produtosVenda);
                } else {
                    request.setAttribute("listaProdutos", produtosVenda);
                }

                request.setAttribute("varMsgErro", true);
                request.setAttribute("msg", "Estorno realizado com sucesso.");

                RequestDispatcher dispatcher = request.getRequestDispatcher("/venda/estorno.jsp");
                dispatcher.forward(request, response);
            } else {
                ArrayList<Venda> produtosVenda = VendaDAO.getProdutosVenda();

                if (produtosVenda.isEmpty()) {
                    Venda uv = new Venda();

                    uv.setNomeProduto("Não há produtos cadastrados");
                    produtosVenda.add(uv);

                    request.setAttribute("listaProdutos", produtosVenda);
                } else {
                    request.setAttribute("listaProdutos", produtosVenda);
                }

                RequestDispatcher dispatcher = request.getRequestDispatcher("/venda/estorno.jsp");
                dispatcher.forward(request, response);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processaRequisicao("GET", request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processaRequisicao("POST", request, response);
    }
}
