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

    public static boolean salvarProduto(Produto p) {
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("INSERT INTO"
                    + " TBL_PRODUTOS VALUES (?, ?, ?, ?, ?, ?);");
            query.setString(1, p.getNome());
            query.setString(2, p.getDescricao());
            query.setString(3, p.getTipo());
            query.setInt(4, p.getCodigoFilial());
            query.setInt(5, p.getQuantidadeEstoque());
            query.setDouble(6, p.getValorUnitario());

            int rs = query.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static boolean excluirProduto(int pCodigo) {
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("DELETE FROM TBL_PRODUTO WHERE ID_PRODUTO = ?");

            query.setInt(1, pCodigo);

            ResultSet linhasAfetadas = query.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static ArrayList<Produto> getProdutos() {
        ArrayList<Produto> produtos = new ArrayList<>();
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT ID_PRODUTO, NOME, DESCRICAO, TIPO, FK_FILIAL, QTD_ESTOQUE, VALOR_UNIDADE "
                    + " FROM TBL_PRODUTOS INNER JOIN TBL_FILIAL ON TBL_PRODUTOS.FK_FILIAL = TBL_FILIAL.ID_FILIAL;");

            ResultSet rs = query.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    produtos.add(new Produto(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getInt(4),
                            rs.getInt(5),
                            rs.getDouble(6)
                    ));

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return produtos;
    }

}
