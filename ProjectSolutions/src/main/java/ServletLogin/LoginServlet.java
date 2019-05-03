/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletLogin;

/**
 *
 * @author guilherme.psilva103
 */
import DAO.ProdutoDAO;
import DAO.UsuarioDAO;
import Model.Produto;
import Model.Usuario;
import SessaoAuth.UsuarioSistema;
import SessaoAuthService.UsuarioSistemaService;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fernando.tsuda
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/produtos/listagem_produtos"})
public class LoginServlet extends HttpServlet {

    private void processaRequisicao(String metodoHttp, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        
        boolean httpOK = UsuarioDAO.getLogin();

        if (httpOK) {
            ArrayList<Produto> produto = ProdutoDAO.getProdutos();
            request.setAttribute("lista", produto);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/venda/cadastro_vendas.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
            dispatcher.forward(request, response);
        }

//        RequestDispatcher dispatcher = request.getRequestDispatcher("/produtos/listagem_produtos.jsp");
//        dispatcher.forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processaRequisicao("GET", req, resp); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processaRequisicao("POST", req, resp); //To change body of generated methods, choose Tools | Templates.
    }

}
