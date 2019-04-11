/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Filial;
import Model.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author alexsander.mrocha
 */
public class VendaDAO {

    private static Database db = new Database();

    public static boolean salvarVenda(Venda v) {
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("INSERT INTO"
                    + " TBL_VENDA VALUES (?, ?, ?, ?, ?, ?, ?, ?);");

            query.setString(1, v.getNomeProduto());
            query.setInt(2, v.getCodigoProduto());
            query.setInt(3, v.getQuantidadeVenda());
            query.setInt(4, v.getIdFuncionario());
            query.setInt(5, v.getCodigoFilial());
            query.setString(6, v.getCpfCliente());
            query.setString(7, v.getDataVenda());

            int rs = query.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static boolean excluirVenda(int vCodigo) {
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("DELETE FROM TBL_VENDA WHERE ID_VENDA = ?");

            query.setInt(1, vCodigo);

            ResultSet linhasAfetadas = query.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static ArrayList<Venda> getVendas() {
        ArrayList<Venda> vendas = new ArrayList<>();
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT TBL_VENDA.ID_VENDA, TBL_VENDA.NOME_PRODUTO, TBL_VENDA.ID_PRODUTO, "
                    + " TBL_VENDA.QTD_ITENS, TBL_VENDA.ID_USUARIO, TBL_VENDA.ID_FILIAL, TBL_VENDA.CPF_CLIENTE, TBL_VENDA.DATA_VENDA "
                    + " FROM TBL_VENDA "
                    + " INNER JOIN TBL_FILIAL ON TBL_VENDA.ID_FILIAL = TBL_FILIAL.ID_FILIAL "
                    + " INNER JOIN TBL_USUARIO ON TBL_VENDA.ID_USUARIO = TBL_USUARIO.ID_USUARIO "
                    + " ORDER BY TBL_VENDA.DATA_VENDA AND TBL_VENDA.ID_FILIAL;");

            ResultSet rs = query.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    vendas.add(new Venda(
                            rs.getString(1),
                            rs.getInt(2),
                            rs.getInt(3),
                            rs.getInt(4),
                            rs.getInt(5),
                            rs.getString(6),
                            rs.getString(7)
                    ));

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vendas;
    }

}