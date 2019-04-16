/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.UsuarioDAO;
import Model.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guilherme.pereira
 */
@WebServlet(name = "CadastroUsuario", urlPatterns = {"/ti/cadastro_usuario"})
public class UsuarioServlet extends HttpServlet{
    
    private void processaRequisicao(String metodoHttp, HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        
         
        String uCodigoUsuario = String.valueOf(request.getParameter("codigoUsuario"));
        String uNome = request.getParameter("nome");
        String uEmail = request.getParameter("email");
        String uSenha = request.getParameter("senha");
        String uConfirmaSenha = request.getParameter("confirmarSenha");
        String uSetor = request.getParameter("setor");
        String uFilial = request.getParameter("filial");
        
        
        Usuario user = new Usuario(uNome, uEmail, uSenha, Integer.parseInt(uFilial), Integer.parseInt(uSetor));
        boolean httpOK = UsuarioDAO.salvarUsuario(user);

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
