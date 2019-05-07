package DAO;

import Model.Filial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author alexsander.mrocha
 */
public class FilialDAO {

    private static final Database db = new Database();

    public static boolean salvarFilial(Filial f) {
        Connection conn = db.obterConexao();

        try {
            PreparedStatement query = conn.prepareStatement("INSERT INTO"
                    + " tbl_filial (logradouro, numero, cep, bairro, cidade, estado, telefone)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?);");

            query.setString(1, f.getLogradouro());
            query.setInt(2, f.getNumero());
            query.setString(3, f.getCep());
            query.setString(4, f.getBairro());
            query.setString(5, f.getCidade());
            query.setString(6, f.getEstado());
            query.setString(7, f.getTelefone());

            query.executeUpdate();
            conn.close();

        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }

        return true;
    }

    public static boolean excluirFilial(int fCodigo) {
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("UPDATE tbl_filial SET status = 1 WHERE id_filial = ?");

            query.setInt(1, fCodigo);

            query.execute();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }

        return true;
    }

    public static boolean atualizarFilial(Filial f) {
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("UPDATE"
                    + " tbl_filial SET logradouro = ?,"
                    + " numero = ?,"
                    + " cep = ?,"
                    + " bairro = ?,"
                    + " cidade = ?,"
                    + " estado = ?,"
                    + " telefone = ? WHERE id_filial = ?;");

            query.setString(1, f.getLogradouro());
            query.setInt(2, f.getNumero());
            query.setString(3, f.getCep());
            query.setString(4, f.getBairro());
            query.setString(5, f.getCidade());
            query.setString(6, f.getEstado());
            query.setString(7, f.getTelefone());
            query.setInt(8, f.getCodigo());

            int linhasAfetadas = query.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }

        return true;
    }

    public static ArrayList<Filial> getFiliais() {
        ArrayList<Filial> filiais = new ArrayList<>();
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("select *, concat(cidade, \" - \",estado) from tbl_filial;");

            ResultSet rs = query.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Filial filial = new Filial(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getInt(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getString(8)
                    );
                    filial.setNomeFilial(rs.getString(9));
                    filiais.add(filial);
                }
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return filiais;
    }

    public static Filial getFilial(int codigo) {
        Filial filial = null;
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM"
                    + " tbl_filial WHERE id_filial = ?;");

            query.setInt(1, codigo);
            ResultSet rs = query.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    filial = new Filial(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getInt(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getString(8)
                    );
                }
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return filial;
    }
}
