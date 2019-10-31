package DAO;

import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
            query.setInt(8, u.getCodigo());

            query.executeUpdate();

            conn.close();
        } catch (SQLException e) {
            System.out.println(e);

            return false;
        }
        return true;
    }

    public static Usuario getEnderecoUser(int codigoUsuario) {
        Usuario endereco = null;
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT *"
                    + " FROM tbl_usuario AS u"
                    + " INNER JOIN tbl_endereco AS e"
                    + " ON u.id_usuario = e.id_endereco"
                    + " WHERE u.id_usuario = ?;");

            query.setInt(1, codigoUsuario);
            ResultSet rs = query.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Usuario e = new Usuario(
                            rs.getInt(1),
                            rs.getString(9),
                            rs.getInt(10),
                            rs.getString(11),
                            rs.getString(12),
                            rs.getString(13),
                            rs.getString(14),
                            rs.getString(15),
                            rs.getInt(16)
                    );

                    endereco = e;
                    endereco.setCodigoEndereco(e.getCodigo());
                }
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return endereco;
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
            query.setInt(8, u.getCodigo());

            query.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }

        return true;
    }
}
