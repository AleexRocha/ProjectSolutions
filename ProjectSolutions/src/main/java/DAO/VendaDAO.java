package DAO;

import Model.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
                    + " tbl_venda(codigo_venda, qtd_total, valor_frete, valor_total, data_venda, fk_endereco, fk_usuario, fk_status, fk_pagamento)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);

            query.setString(1, v.getCodigoVenda());
            query.setInt(2, v.getQuantidadeTotalVenda());
            query.setDouble(3, v.getValorFrete());
            query.setDouble(4, v.getValorTotalVenda());
            query.setString(5, v.getDataVenda());
            query.setInt(6, v.getIdEndereco());
            query.setInt(7, v.getIdUsuario());
            query.setInt(8, v.getIdStatus());
            query.setInt(9, v.getIdPagamento());

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
                query.setInt(2, v[i].getIdProduto());
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

    public static ArrayList<Venda> getTodosPedidos() {
        ArrayList<Venda> venda = new ArrayList<>();
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT"
                    + " v.id_venda, v.codigo_venda, v.valor_frete,"
                    + " v.valor_total AS valor_total_venda, v.data_venda,"
                    + " v.qtd_total AS qtd_total_produtos_venda, e.logradouro,"
                    + " e.cep, e.numero, su.nome_status AS status_da_venda,"
                    + " ip.nome AS forma_pagamento, pu.numero_pagamento"
                    + " FROM tbl_venda AS v"
                    + " INNER JOIN tbl_endereco AS e"
                    + " ON v.fk_endereco = e.id_endereco"
                    + " INNER JOIN tbl_status_venda AS su"
                    + " ON v.fk_status = su.id_status"
                    + " INNER JOIN tbl_pagamento_usuario AS pu"
                    + " ON v.fk_pagamento = pu.id_pagamento"
                    + " INNER JOIN tbl_info_pagamentos AS ip"
                    + " ON pu.fk_info_pagamento = ip.id_info_pagamento"
                    + " ORDER BY v.data_venda ASC;");

            ResultSet rs = query.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Venda v = new Venda(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getDouble(3),
                            rs.getDouble(4),
                            rs.getString(5),
                            rs.getInt(6),
                            rs.getString(7),
                            rs.getString(8),
                            rs.getInt(9),
                            rs.getString(10),
                            rs.getString(11),
                            rs.getString(12)
                    );

                    venda.add(v);
                }
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }

        return venda;
    }

    public static ArrayList<Venda> getPedidosVenda(int codigoUsuario) {
        ArrayList<Venda> venda = new ArrayList<>();
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT"
                    + " v.id_venda, v.codigo_venda, v.valor_frete,"
                    + " v.valor_total AS valor_total_venda, v.data_venda,"
                    + " v.qtd_total AS qtd_total_produtos_venda, e.logradouro,"
                    + " e.cep, e.numero, su.nome_status AS status_da_venda,"
                    + " ip.nome AS forma_pagamento, pu.numero_pagamento"
                    + " FROM tbl_venda AS v"
                    + " INNER JOIN tbl_endereco AS e"
                    + " ON v.fk_endereco = e.id_endereco"
                    + " INNER JOIN tbl_status_venda AS su"
                    + " ON v.fk_status = su.id_status"
                    + " INNER JOIN tbl_pagamento_usuario AS pu"
                    + " ON v.fk_pagamento = pu.id_pagamento"
                    + " INNER JOIN tbl_info_pagamentos AS ip"
                    + " ON pu.fk_info_pagamento = ip.id_info_pagamento"
                    + " WHERE v.fk_usuario = ?"
                    + " ORDER BY v.data_venda DESC;");

            query.setInt(1, codigoUsuario);

            ResultSet rs = query.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Venda v = new Venda(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getDouble(3),
                            rs.getDouble(4),
                            rs.getString(5),
                            rs.getInt(6),
                            rs.getString(7),
                            rs.getString(8),
                            rs.getInt(9),
                            rs.getString(10),
                            rs.getString(11),
                            rs.getString(12)
                    );

                    venda.add(v);
                }
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }

        return venda;
    }

    public static ArrayList<Venda> getProdutosPedidos(int idVenda) {
        ArrayList<Venda> venda = new ArrayList<>();
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT"
                    + " pv.fk_venda, p.nome, pv.qtd_produto, p.valor_unidade"
                    + " FROM tbl_produtos_venda AS pv"
                    + " INNER JOIN tbl_produtos AS p"
                    + " ON pv.fk_produto = p.id_produto"
                    + " WHERE pv.fk_venda = ?;");

            query.setInt(1, idVenda);

            ResultSet rs = query.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Venda v = new Venda(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getInt(3),
                            rs.getDouble(4)
                    );

                    venda.add(v);
                }
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }

        return venda;
    }

    public static boolean alterarStatusPedido(int idPedido, int idStatus) {
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("UPDATE tbl_venda"
                    + " SET fk_status =  ?"
                    + " WHERE  id_venda =  ?;");
            query.setInt(1, idStatus);
            query.setInt(2, idPedido);

            query.executeUpdate();

            conn.close();
        } catch (SQLException e) {
            System.out.println("SQL Exception" + e);
            return false;
        }

        return true;
    }
}
