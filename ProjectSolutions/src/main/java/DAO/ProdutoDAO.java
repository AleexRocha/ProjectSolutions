/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Filial;
import Model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author alexsander.mrocha
 */
public class ProdutoDAO {

    private static Database db = new Database();

    public static boolean salvarProduto(Produto p) throws SQLException {
        Connection conn = db.obterConexao();
        PreparedStatement query = conn.prepareStatement("INSERT INTO"
                + " TBL_PRODUTOS VALUES (?, ?, ?, ?, ?, ?);");

        query.setString(1, p.getNome());
        query.setString(2, p.getDescricao());
        //query.setString(3, p.getTipo());
        query.setInt(3, p.getCodigoFilial());
        query.setInt(4, p.getQuantidadeEstoque());
        query.setDouble(5, p.getValorUnitario());

        try {
            int rs = query.executeUpdate();
        } catch (SQLException e) {
            return false;
        }

        return true;
    }

    public static boolean excluirProduto(int pCodigo) throws SQLException {
        Connection conn = db.obterConexao();
        PreparedStatement query = conn.prepareStatement("DELETE FROM TBL_PRODUTO WHERE ID_PRODUTO = ?");

        query.setInt(1, pCodigo);

        try {
            ResultSet linhasAfetadas = query.executeQuery();
        } catch (SQLException e) {
            return false;
        }

        return true;
    }

    public static ArrayList<Produto> getProdutos() throws SQLException {
        ArrayList<Produto> produtos = new ArrayList<>();
        Connection conn = db.obterConexao();
        PreparedStatement query = conn.prepareStatement("SELECT * FROM"
                + " TBL_PRODUTOS;");

        try {
            ResultSet rs = query.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    produtos.add(new Produto(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getInt(3),
                            rs.getInt(4),
                            rs.getDouble(5)
                    ));

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produtos;
    }

}
