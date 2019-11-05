package ServletVenda;

import Model.Venda;

import com.google.gson.Gson;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.Reader;
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
        Venda venda = new Venda();

        StringBuilder ajax = new StringBuilder();
        BufferedReader reader = request.getReader();

        String linha;
        while ((linha = reader.readLine()) != null) {
            ajax.append(linha);
        }

        System.out.println("AJAX: " + ajax);
        String json = ajax.toString();
        System.out.println("JSON: " + json);

        venda = gson.fromJson(json, Venda.class);

        System.out.println(venda.toString());

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
