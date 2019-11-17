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
@WebServlet(name = "VendaSelectServlet", urlPatterns = {"/venda/select_vendas"})
public class VendaSelectServlet extends HttpServlet {

    private void processaRequisicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idUsuario = request.getParameter("idUsuario");

        ArrayList<Venda> pedidos = VendaDAO.getPedidosVenda(Integer.parseInt(idUsuario));
        ArrayList<Venda> produtos = new ArrayList<>();

        for (Venda pedido : pedidos) {
            ArrayList<Venda> produtosVenda = VendaDAO.getProdutosPedidos(pedido.getIdVenda());
            for (Venda produto : produtosVenda) {
                produtos.add(produto);
            }
        }
        
        for (Venda pedido : pedidos) {
            System.out.println("Pedido " + pedido.getIdVenda() + " : " + pedido.toString());
        }
        
        for (Venda produto : produtos) {
            System.out.println("Produto " + produto.getIdVenda() + " : " + produto.toString());
        }

        request.setAttribute("listaPedidos", pedidos);
        request.setAttribute("listaProdutos", produtos);
        request.setAttribute("perfil", "pedidos");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/ti/perfil.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processaRequisicao(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processaRequisicao(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

}
