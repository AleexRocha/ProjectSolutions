package Controller;

import DAO.UsuarioDAO;
import Model.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author daniel
 */
public class UsuarioController {

    /**
     *
     * @param uNome - String
     * @param uEmail - String
     * @param uSenha - String
     * @param uCodigoFilial - int
     * @param uSetor - String
     * @return
     */
    public static boolean salvarUsuario(String uNome, String uEmail, String uSenha, int uCodigoFilial, int uSetor) throws SQLException {
        Usuario u = new Usuario(uNome, uEmail, uSenha, uCodigoFilial, uSetor);
        return UsuarioDAO.salvarUsuario(u);
    }

    /**
     * @param uCodigo - int
     * @return
     *
     */
    public static boolean excluirUsuario(int uCodigo) throws SQLException {
        return UsuarioDAO.excluirUsuario(uCodigo);
    }

    /**
     *
     * @param uCodigo - int
     * @param uNome - String
     * @param uEmail - String
     * @param uSenha - String
     * @param uCodigoFilial - int
     * @param uSetor - String
     * @return
     */
    public static boolean atualizarUsuario(int uCodigo, String uNome, String uEmail, String uSenha, int uCodigoFilial, int uSetor) throws SQLException {
        Usuario u = new Usuario(uNome, uEmail, uSenha, uCodigoFilial, uSetor);
        u.setCodigo(uCodigo);
        return UsuarioDAO.alterarUsuario(u);
    }

    public static ArrayList<String[]> getUsuario() throws SQLException {
        ArrayList<Usuario> usuarios = UsuarioDAO.getUsuarios();
        ArrayList<String[]> listaUsuarios = new ArrayList<>();

        for (int i = 0; i < usuarios.size(); i++) {
            listaUsuarios.add(
                    new String[]{
                        String.valueOf(usuarios.get(i).getCodigo()),
                        usuarios.get(i).getNome(),
                        usuarios.get(i).getEmail(),
                        usuarios.get(i).getSenha(),
                        String.valueOf(usuarios.get(i).getCodigoFilial()),
                        String.valueOf(usuarios.get(i).getSetor()),});
        }
        return listaUsuarios;
    }
}
