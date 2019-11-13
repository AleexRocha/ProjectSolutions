package ServletVenda;

import DAO.VendaDAO;
import Model.Venda;

import com.google.gson.Gson;
import java.io.BufferedReader;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author guilherme.psilva103
 */
@WebServlet(name = "VendaCadastroServlet", urlPatterns = {"/venda/create_venda"})
public class VendaCadastroServlet extends HttpServlet {

    private void processaRequisicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Gson gson = new Gson();
        Venda venda = new Venda();
        Venda produtosCarrinho[];

        StringBuilder ajax = new StringBuilder();
        BufferedReader reader = request.getReader();

        String linha;
        while ((linha = reader.readLine()) != null) {
            ajax.append(linha);
        }

        String json = ajax.toString();
        produtosCarrinho = gson.fromJson(json, Venda[].class);

        int quantidadeTotalVenda = 0;
        int valorTotalVenda = 0;

        for (Venda pc : produtosCarrinho) {
            quantidadeTotalVenda += pc.getQuantidadeUnitarioProduto();
            valorTotalVenda += pc.getValorTotalProduto();
        }

        DateFormat dateFormatCodigoVenda = new SimpleDateFormat("ddMMyyyyHHmmss");
        DateFormat dateFormatDataVenda = new SimpleDateFormat("dd:MM:yyyy HH:mm:ss");
        Date date = new Date();
        String hashVenda = dateFormatCodigoVenda.format(date);
        String dataVenda = dateFormatDataVenda.format(date);

        HttpSession userLogado = request.getSession();
        int codigoUsuario = (int) userLogado.getAttribute("cdFuncionario");

        String codigo = hashVenda.concat(String.valueOf(codigoUsuario));
        
        venda.setCodigoVenda(codigo);
        venda.setQuantidadeTotalVenda(quantidadeTotalVenda);
        venda.setValorTotalVenda(valorTotalVenda);
        venda.setDataVenda(dataVenda);
        venda.setIdUsuario(codigoUsuario);
        venda.setIdStatus(1);
        venda.setIdPagamento(1);

        int codigoVenda = VendaDAO.salvarVenda(venda);

        if (codigoVenda != 0) {
            for (int i = 0; i < produtosCarrinho.length; i++) {
                produtosCarrinho[i].setIdVenda(1);
            }

            boolean httpOk = VendaDAO.salvarProdutoVenda(produtosCarrinho);

            if (httpOk) {
                request.setAttribute("venda", "Produto salvo com sucesso, o codigo da venda é: " + hashVenda + String.valueOf(codigoUsuario));
                RequestDispatcher dispatcher = request.getRequestDispatcher("/ti/perfil");
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
