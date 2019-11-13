package DAO;

import Model.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author alexsander.mrocha
 */
public class VendaDAO {

    private static final Database db = new Database();

    public static int salvarVenda(Venda v) {
        int idVenda = 0;
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("INSERT INTO"
                    + " tbl_venda(codigo_venda, qtd_total, valor_total, data_venda, fk_usuario, fk_status, fk_pagamento)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);

            query.setString(1, v.getCodigoVenda());
            query.setInt(2, v.getQuantidadeTotalVenda());
            query.setDouble(3, v.getValorTotalVenda());
            query.setString(4, v.getDataVenda());
            query.setInt(5, v.getIdUsuario());
            query.setInt(6, v.getIdStatus());
            query.setInt(7, v.getIdPagamento());

            query.executeUpdate();

            ResultSet rs = query.getGeneratedKeys();
            if (rs.next()) {
                idVenda = rs.getInt(1);
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println("SQL Exception" + e);
            return idVenda;
        }

        return idVenda;
    }

    public static boolean salvarProdutoVenda(Venda v[]) {
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query;
            for (int i = 0; i < v.length; i++) {
                query = conn.prepareStatement("INSERT INTO"
                        + " tbl_produtos_venda(fk_venda, fk_produto, qtd_produto)"
                        + " VALUES (?, ?, ?);");
                query.setInt(1, v[i].getIdVenda());
                query.setInt(2, v[i].getQuantidadeTotalVenda());
                query.setInt(3, v[i].getQuantidadeUnitarioProduto());

                query.executeUpdate();
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println("SQL Exception" + e);
            return false;
        }

        return true;
    }

//    public static boolean excluirVenda(int vCodigo) {
//        Venda v = new Venda();
//        Connection conn = db.obterConexao();
//        try {
//            PreparedStatement select = conn.prepareStatement("SELECT id_produto, qtd_itens FROM tbl_venda WHERE id_venda = ?");
//            PreparedStatement query = conn.prepareStatement("UPDATE tbl_venda SET status = 1 WHERE id_venda = ?");
//
//            query.setInt(1, vCodigo);
//            int rs = query.executeUpdate();
//
//            if (rs != 0) {
//                select.setInt(1, vCodigo);
//                ResultSet result = select.executeQuery();
//
//                while (result.next()) {
//                    v.setCodigoProduto(result.getInt(1));
//                    v.setQuantidadeVenda(result.getInt(2));
//                }
//                atualizaEstoque(v.getQuantidadeVenda(), v.getCodigoProduto(), "+");
//            }
//
//            conn.close();
//        } catch (SQLException e) {
//            System.out.println("SQL Exception" + e);
//            return false;
//        }
//
//        return true;
//    }
//
//    public static ArrayList<Venda> getProdutosVenda() {
//        ArrayList<Venda> venda = new ArrayList<>();
//        Connection conn = db.obterConexao();
//        try {
//            PreparedStatement query = conn.prepareStatement("SELECT id_produto, nome, valor_unidade FROM tbl_produtos WHERE status = 0 order by nome;");
//
//            ResultSet rs = query.executeQuery();
//
//            if (rs != null) {
//                while (rs.next()) {
//                    Venda v = new Venda();
//                    v.setCodigoProduto(rs.getInt(1));
//                    v.setNomeProduto(rs.getString(2));
//                    v.setValorUnidade(rs.getDouble(3));
//
//                    venda.add(v);
//                }
//            }
//            conn.close();
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//
//        return venda;
//    }
//
//    public static ArrayList<Venda> getUsuariosVenda() {
//        ArrayList<Venda> venda = new ArrayList<>();
//        Connection conn = db.obterConexao();
//        try {
//            PreparedStatement query = conn.prepareStatement("SELECT id_usuario, nome FROM tbl_usuario WHERE status = 0;");
//
//            ResultSet rs = query.executeQuery();
//
//            if (rs != null) {
//                while (rs.next()) {
//                    Venda v = new Venda();
//                    v.setIdFuncionario(rs.getInt(1));
//                    v.setNomeFuncionario(rs.getString(2));
//
//                    venda.add(v);
//                }
//            }
//            conn.close();
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//
//        return venda;
//    }
//
//    public static void atualizaEstoque(int quantidadeVendida, int codigoProduto, String acao) {
//        Connection conn = db.obterConexao();
//        try {
//            PreparedStatement query = conn.prepareStatement("UPDATE tbl_produtos AS p "
//                    + " SET p.qtd_estoque = (p.qtd_estoque " + acao + " ?) WHERE p.id_produto = ?;");
//
//            query.setInt(1, quantidadeVendida);
//            query.setInt(2, codigoProduto);
//
//            int rs = query.executeUpdate();
//
//            conn.close();
//        } catch (SQLException e) {
//            System.out.println("SQL Exception" + e);
//        }
//    }
}
