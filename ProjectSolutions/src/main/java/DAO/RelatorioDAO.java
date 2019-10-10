package DAO;

import Model.Relatorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author alexsander.mrocha
 */
public class RelatorioDAO {

    private static final Database db = new Database();

    public static ArrayList<Relatorio> getRelatorioGeral() {
        ArrayList<Relatorio> relatorio = new ArrayList<>();
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT"
                    + " v.id_venda,"
                    + " p.nome,"
                    + " v.id_produto,"
                    + " v.qtd_itens,"
                    + " (v.qtd_itens*p.valor_unidade) AS valor_total,"
                    + " v.cpf_cliente,"
                    + " v.id_usuario,"
                    + " v.data_venda"
                    + " FROM tbl_venda AS v"
                    + " INNER JOIN tbl_produtos AS p ON v.id_produto = p.id_produto;");

            ResultSet rs = query.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    relatorio.add(new Relatorio(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getInt(3),
                            rs.getInt(4),
                            rs.getDouble(5),
                            rs.getString(6),
                            rs.getInt(7),
                            rs.getString(8)
                    ));
                }
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return relatorio;
    }

    public static ArrayList<Relatorio> getRelatorioData(String dataDe, String dataAte) {
        ArrayList<Relatorio> relatorio = new ArrayList<>();
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT"
                    + " v.id_venda,"
                    + " p.nome,"
                    + " v.id_produto,"
                    + " v.qtd_itens,"
                    + " (v.qtd_itens*p.valor_unidade) AS valor_total,"
                    + " v.cpf_cliente,"
                    + " v.id_usuario,"
                    + " v.data_venda"
                    + " FROM tbl_venda AS v"
                    + " INNER JOIN tbl_produtos AS p ON v.id_produto = p.id_produto"
                    + " WHERE v.data_venda >= ? AND v.data_venda <= ?;");

            query.setString(1, dataDe);
            query.setString(2, dataAte);
            ResultSet rs = query.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    relatorio.add(new Relatorio(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getInt(3),
                            rs.getInt(4),
                            rs.getDouble(5),
                            rs.getString(6),
                            rs.getInt(7),
                            rs.getString(8)
                    ));
                }
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return relatorio;
    }

    public static ArrayList<Relatorio> getEstornoProduto(String eCodProduto) {
        ArrayList<Relatorio> relatorio = new ArrayList<>();
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM tbl_venda AS v WHERE v.id_produto = ?;");

            query.setString(1, eCodProduto);
            ResultSet rs = query.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    relatorio.add(new Relatorio(
                            rs.getInt(1),
                            rs.getInt(2),
                            rs.getInt(3),
                            rs.getInt(4),
                            rs.getString(5),
                            rs.getString(6)
                    ));
                }
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return relatorio;
    }

    public static ArrayList<Relatorio> getEstornoCpf(String eCpfCliente) {
        ArrayList<Relatorio> relatorio = new ArrayList<>();
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM tbl_venda AS v WHERE v.cpf_cliente = ?;");

            query.setString(1, eCpfCliente);
            ResultSet rs = query.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    relatorio.add(new Relatorio(
                            rs.getInt(1),
                            rs.getInt(2),
                            rs.getInt(3),
                            rs.getInt(4),
                            rs.getString(5),
                            rs.getString(6)
                    ));
                }
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return relatorio;
    }

    public static ArrayList<Relatorio> getEstornoGeral() {
        ArrayList<Relatorio> relatorio = new ArrayList<>();
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM tbl_venda AS v;");

            ResultSet rs = query.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    relatorio.add(new Relatorio(
                            rs.getInt(1),
                            rs.getInt(2),
                            rs.getInt(3),
                            rs.getInt(4),
                            rs.getString(5),
                            rs.getString(6)
                    ));
                }
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return relatorio;
    }

}
