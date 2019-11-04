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

        Venda venda = new Venda();
        Gson gson = new Gson();
        BufferedReader reader = request.getReader();

        DateFormat dateFormat = new SimpleDateFormat("ddMMyyyyHHmmss");
        Date date = new Date();
        String horarioVenda = dateFormat.format(date);

        HttpSession userLogado = request.getSession();
        int codigoUsuario = (int) userLogado.getAttribute("cdFuncionario");
        String cpfUsuario = (String) userLogado.getAttribute("cpfUsuario");

//        String json = gson.toJson(reader.readLine());
        venda = gson.fromJson(reader.readLine(), Venda.class);
        venda.setCodigoVenda(Long.parseLong(horarioVenda + codigoUsuario));
        venda.setCodigoUsuario(codigoUsuario);
        venda.setCpfUsuario(cpfUsuario);
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
