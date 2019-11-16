package ServletVenda;

import DAO.UsuarioDAO;
import DAO.VendaDAO;
import Model.Pagamento;
import Model.Venda;

import com.google.gson.Gson;
import java.io.BufferedReader;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

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
        int idEndereco = 0;
        int idRecebidoPagamento = 0;
        for (Venda pc : produtosCarrinho) {
            quantidadeTotalVenda += pc.getQuantidadeUnitarioProduto();
            valorTotalVenda += pc.getValorTotalProduto();
            idEndereco = pc.getIdEndereco();
            idRecebidoPagamento = pc.getIdPagamento();
        }

        DateFormat dateFormatCodigoVenda = new SimpleDateFormat("ddMMyyyyHHmmss");
        DateFormat dateFormatDataVenda = new SimpleDateFormat("dd:MM:yyyy HH:mm:ss");
        Date date = new Date();
        String hashVenda = dateFormatCodigoVenda.format(date);
        String dataVenda = dateFormatDataVenda.format(date);

        HttpSession userLogado = request.getSession();
        int codigoUsuario = (int) userLogado.getAttribute("cdFuncionario");
        int idPagamento = 0;
        if (idRecebidoPagamento == 99) {
            Random gerador = new Random();
            String numeroBoleto = "";
            for (int i = 0; i < 48; i++) {
                int numero = gerador.nextInt(10);
                char c = (char) numero;
                numeroBoleto.concat(String.valueOf(c));
            }
            Pagamento pagamento = new Pagamento(numeroBoleto, codigoUsuario);
            idPagamento = UsuarioDAO.salvarBoletoPagamento(pagamento);
        } else {
            idPagamento = idRecebidoPagamento;
        }

        venda.setCodigoVenda(hashVenda.concat(String.valueOf(codigoUsuario)));
        venda.setQuantidadeTotalVenda(quantidadeTotalVenda);
        venda.setValorTotalVenda(valorTotalVenda);
        venda.setValorFrete(valorTotalVenda);
        venda.setDataVenda(dataVenda);
        venda.setIdEndereco(idEndereco);
        venda.setIdUsuario(codigoUsuario);
        venda.setIdStatus(1);
        venda.setIdPagamento(idPagamento);

        int codigoVenda = VendaDAO.salvarVenda(venda);

        if (codigoVenda != 0) {
            for (int i = 0; i < produtosCarrinho.length; i++) {
                produtosCarrinho[i].setIdVenda(codigoVenda);
            }

            boolean httpOk = VendaDAO.salvarProdutoVenda(produtosCarrinho);

            if (httpOk) {
                response.setContentType("application/json");
                response.setCharacterEncoding("utf-8");
                response.getWriter().write(hashVenda.concat(String.valueOf(codigoUsuario)));
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
