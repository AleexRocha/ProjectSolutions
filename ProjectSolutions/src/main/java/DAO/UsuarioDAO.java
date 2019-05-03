package DAO;

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

            conn.close();
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
                    + " tbl_usuario SET nome = ?, email = ?, senha = ?, fk_filial = ?, fk_setor = ? where id_usuario = ?;");

            query.setString(1, u.getNome());
            query.setString(2, u.getEmail());
            query.setString(3, u.getSenha());
            query.setInt(4, u.getCodigoFilial());
            query.setInt(5, u.getSetor());
            query.setInt(6, u.getCodigo());

            int rs = query.executeUpdate();
            conn.close();
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
            PreparedStatement query = conn.prepareStatement("SELECT id_usuario, nome, email, senha,"
                    + " fk_filial, fk_setor, nome_setor, concat(cidade, \" - \", estado)\n"
                    + " FROM tbl_usuario INNER JOIN tbl_setor ON "
                    + " tbl_usuario.fk_setor = tbl_setor.id_setor inner join tbl_filial on tbl_usuario.fk_filial = tbl_filial.id_filial;");

            ResultSet rs = query.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Usuario user = new Usuario(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getInt(5),
                            rs.getInt(6)
                    );
                    user.setNomeSetor(rs.getString(7));
                    user.setNomeFilial(rs.getString(8));
                    usuarios.add(user);

                }
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return usuarios;
    }

    public static Usuario getUsuario(int codigoUsuario) {
        Usuario usuarios = null;
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT id_usuario, nome, email, senha,"
                    + " fk_filial, fk_setor, nome_setor, concat(cidade, \" - \", estado)\n"
                    + " FROM tbl_usuario INNER JOIN tbl_setor ON "
                    + " tbl_usuario.fk_setor = tbl_setor.id_setor inner join tbl_filial on tbl_usuario.fk_filial = tbl_filial.id_filial "
                    + " where id_usuario = ? ;");

            query.setInt(1, codigoUsuario);
            ResultSet rs = query.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Usuario user = new Usuario(rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getInt(5),
                            rs.getInt(6));
                    user.setNomeSetor(rs.getString(7));
                    user.setNomeFilial(rs.getString(8));
                    usuarios = user;
                }
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return usuarios;
    }

    public static ArrayList<Usuario> getSetoresCadastro() {
        ArrayList<Usuario> setores = new ArrayList<>();
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT id_setor, nome_setor FROM tbl_setor;");

            ResultSet rs = query.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Usuario user = new Usuario();
                    user.setSetor(rs.getInt(1));
                    user.setNomeSetor(rs.getString(2));
                    setores.add(user);
                }
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return setores;
    }

    public static ArrayList<Usuario> getFiliaisCadastro() {
        ArrayList<Usuario> filiais = new ArrayList<>();
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT id_filial, CONCAT(cidade, \" - \", estado) FROM tbl_filial;");

            ResultSet rs = query.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Usuario user = new Usuario();
                    user.setCodigoFilial(rs.getInt(1));
                    user.setNomeFilial(rs.getString(2));
                    filiais.add(user);
                }
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return filiais;
    }
// getLogin(String usuario)
    public static boolean getLogin(String email, String senha) {
       
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM tbl_usuario WHERE email=? AND senha =?;");
            query.setString(1,email);
            query.setString(2, senha);
            ResultSet rs = query.executeQuery();
            if (rs.next()) {
                return true;
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return false;
    }

//    public static ArrayList<Usuario> getLogin() {
//        ArrayList<Usuario> usuario = new ArrayList<>();
//        Connection conn = db.obterConexao();
//        try {
//            PreparedStatement query = conn.prepareStatement("select * from tbl_usuario where email=? and senha =?;");
//            query.setString(1, usuario.getEmail());
//            query.setString(2, usuario.getSenha());
//            ResultSet rs = query.executeQuery();
//            if (rs != null) {
//                Usuario user = new Usuario();
//                user.setEmail(rs.getString(1));
//                user.setSenha(rs.getString(2));
//                Usuario.add(user);
//
//            }
//            conn.close();
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//
//        return false;
}
