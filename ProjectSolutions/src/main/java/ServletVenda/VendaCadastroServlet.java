package ServletVenda;

import Model.Venda;

import com.google.gson.Gson;
import java.io.BufferedReader;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        Venda venda[];

        StringBuilder ajax = new StringBuilder();
        BufferedReader reader = request.getReader();

        String linha;
        while ((linha = reader.readLine()) != null) {
            ajax.append(linha);
        }

        String json = ajax.toString();
        System.out.println("JSON: " + json);
        venda = gson.fromJson(json, Venda[].class);

        for (int i = 0; i < venda.length; i++) {
            System.out.println(venda[i].toString());
        }

        DateFormat dateFormat = new SimpleDateFormat("dd:MM:yyyy_HH:mm:ss");
        Date date = new Date();
        String horarioVenda = dateFormat.format(date);

        HttpSession userLogado = request.getSession();
        int codigoUsuario = (int) userLogado.getAttribute("cdFuncionario");
        String cpfUsuario = (String) userLogado.getAttribute("cpfUsuario");

        System.out.println("\n NOVOS PRODUTOS");

        for (int i = 0; i < venda.length; i++) {
            venda[i].setCodigoVenda(horarioVenda+codigoUsuario);
            venda[i].setIdUsuario(codigoUsuario);
            System.out.println(venda[i].toString());
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
