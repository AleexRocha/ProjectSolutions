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
 * @author alexs
 */
@WebServlet(name = "VendaStatusServlet", urlPatterns = {"/venda/status_pedidos"})
public class VendaStatusServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idPedido = request.getParameter("idPedido");
        String idStatus = request.getParameter("idStatus");

        if (idPedido != null) {
            if (idStatus == null) {
                request.setAttribute("varMsgErro", true);
                request.setAttribute("msg", "Selecione um status para a alteração");
            } else {
                boolean httpOk = VendaDAO.alterarStatusPedido(Integer.parseInt(idPedido), Integer.parseInt(idStatus));

                if (httpOk) {
                    request.setAttribute("varMsg", true);
                    request.setAttribute("msg", "Status alterado com sucesso!");
                } else {
                    request.setAttribute("varMsgErro", true);
                    request.setAttribute("msg", "Erro ao alterar o status do pedido!");
                }
            }
        }

        ArrayList<Venda> pedidos = VendaDAO.getTodosPedidos();
        ArrayList<Venda> produtos = new ArrayList<>();

        for (Venda pedido : pedidos) {
            ArrayList<Venda> produtosVenda = VendaDAO.getProdutosPedidos(pedido.getIdVenda());
            for (Venda produto : produtosVenda) {
                produtos.add(produto);
            }
        }

        request.setAttribute("listaPedidos", pedidos);
        request.setAttribute("listaProdutos", produtos);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/produtos/status_pedidos.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
