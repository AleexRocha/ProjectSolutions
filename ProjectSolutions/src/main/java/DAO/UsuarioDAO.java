package DAO;

import Model.Filial;
import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author alexsander.mrocha
 */
public class UsuarioDAO {

    private static final Database db = new Database();

    public static boolean salvarUsuario(Usuario u) {
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("INSERT INTO "
                    + " tbl_usuario(nome, email, senha, fk_filial, fk_setor) "
                    + "VALUES (?, ?, ?, ?, ?);");

            query.setString(1, u.getNome());
            query.setString(2, u.getEmail());
            query.setString(3, u.getSenha());
            query.setInt(4, u.getCodigoFilial());
            query.setInt(5, u.getSetor());

            int rs = query.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }

        return true;
    }

    public static boolean alterarUsuario(Usuario u) {
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("UPDATE"
                    + " tbl_usuario SET (nome = ?, email = ?, senha = ?, fk_filial = ?, setor = ?);");

            query.setString(1, u.getNome());
            query.setString(2, u.getEmail());
            query.setString(3, u.getSenha());
            query.setInt(4, u.getCodigoFilial());
            query.setInt(5, u.getSetor());

            int rs = query.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }

        return true;
    }

    public static boolean excluirUsuario(int uCodigo) {
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("DELETE FROM tbl_usuario WHERE id_usuario = ?");

            query.setInt(1, uCodigo);

            query.execute();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }

        return true;
    }

    public static ArrayList<Usuario> getUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM tbl_usuario "
                    + " INNER JOIN tbl_setor "
                    + " ON tbl_usuario.fk_setor = tbl_setor.id_setor;");

            ResultSet rs = query.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    usuarios.add(new Usuario(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getInt(5),
                            rs.getInt(6)
                    ));

                }
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return usuarios;
    }
    
    public static ArrayList<Usuario> getUsuario(int codigoUsuario) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM tbl_usuario "
                    + " INNER JOIN tbl_setor "
                    + " ON tbl_usuario.fk_setor = tbl_setor.id_setor"
                    + "WHERE id_usuario = ? ;");

            query.setInt(1, codigoUsuario);
            ResultSet rs = query.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    usuarios.add(new Usuario(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getInt(5),
                            rs.getInt(6)
                    ));

                }
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return usuarios;
    }

//    public static ArrayList<Usuario> getItemUsuario(int codigo) {
//        ArrayList<Usuario> usuarios = new ArrayList<>();
//        Connection conn = db.obterConexao();
//        try {
//            PreparedStatement query = conn.prepareStatement("SELECT * FROM"
//                    + " tbl_usuario WHERE id_usuario= ?;");
//
//            query.setInt(1, codigo);
//            ResultSet rs = query.executeQuery();
//
//            if (rs != null) {
//                while (rs.next()) {
//                    usuario = new Usuario(
//                            rs.getInt(1),
//                            rs.getString(2),
//                            rs.getString(3),
//                            rs.getString(4),
//                            rs.getInt(5),
//                            rs.getInt(6)
//                    );
//                }
//            }
//            conn.close();
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//
//        return usuario;
//    }

}
