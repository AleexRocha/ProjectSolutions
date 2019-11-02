package DAO;

import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Alexsander Rocha
 */
public class EnderecoDAO {

    private static final Database db = new Database();

    public static boolean salvarEndereco(Usuario u) {
        Connection conn = db.obterConexao();

        try {
            PreparedStatement query = conn.prepareStatement("INSERT INTO tbl_endereco"
                    + " (logradouro, numero, bairro, cidade, estado, cep, tipo, fk_usuario)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?);");

            query.setString(1, u.getLogradouro());
            query.setInt(2, u.getNumero());
            query.setString(3, u.getBairro());
            query.setString(4, u.getCidade());
            query.setString(5, u.getEstado());
            query.setString(6, u.getCep());
            query.setString(7, u.getTipoEndereco());
            query.setInt(8, u.getCodigoUsuario());

            query.executeUpdate();

            conn.close();
        } catch (SQLException e) {
            System.out.println(e);

            return false;
        }
        return true;
    }

    public static boolean alterarEndereco(Usuario u) {
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("UPDATE tbl_endereco"
                    + " SET logradouro = ? , numero = ?, bairro = ?, cidade = ?, estado = ?, cep = ?, tipo = ?"
                    + " WHERE id_endereco = ?;");

            query.setString(1, u.getLogradouro());
            query.setInt(2, u.getNumero());
            query.setString(3, u.getBairro());
            query.setString(4, u.getCidade());
            query.setString(5, u.getEstado());
            query.setString(6, u.getCep());
            query.setString(7, u.getTipoEndereco());
            query.setInt(8, u.getCodigoEndereco());

            query.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }

        return true;
    }

    public static Usuario getEnderecoUser(int codigoEndereco) {
        Usuario endereco = null;
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT *"
                    + " FROM tbl_usuario AS u"
                    + " INNER JOIN tbl_endereco AS e"
                    + " ON u.id_usuario = e.fk_usuario"
                    + " WHERE e.id_endereco = ?;");

            query.setInt(1, codigoEndereco);
            ResultSet rs = query.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Usuario e = new Usuario(
                            rs.getInt(8),
                            rs.getString(9),
                            rs.getInt(10),
                            rs.getString(11),
                            rs.getString(12),
                            rs.getString(13),
                            rs.getString(14),
                            rs.getString(15),
                            rs.getInt(16)
                    );
                    e.setCodigoUsuario(rs.getInt(1));
                    e.setSetor(rs.getInt(6));
                    
                    endereco = e;
                }
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return endereco;
    }

    public static ArrayList<Usuario> getEnderecosUser(int codigoUsuario) {
        ArrayList<Usuario> enderecos = new ArrayList<>();
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT *"
                    + " FROM tbl_usuario AS u"
                    + " INNER JOIN tbl_endereco AS e"
                    + " ON u.id_usuario = e.fk_usuario"
                    + " WHERE u.id_usuario = ?;");

            query.setInt(1, codigoUsuario);
            ResultSet rs = query.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Usuario endereco = new Usuario(
                            rs.getInt(8),
                            rs.getString(9),
                            rs.getInt(10),
                            rs.getString(11),
                            rs.getString(12),
                            rs.getString(13),
                            rs.getString(14),
                            rs.getString(15),
                            rs.getInt(16)
                    );
                    endereco.setCodigoUsuario(rs.getInt(1));
                    endereco.setSetor(rs.getInt(6));
                    
                    enderecos.add(endereco);
                }
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return enderecos;
    }
}
