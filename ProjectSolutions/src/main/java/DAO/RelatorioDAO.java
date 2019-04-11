/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Filial;
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

    private static Database db = new Database();

    public static ArrayList<Relatorio> getRelatorios() {
        ArrayList<Relatorio> getRelatorio = new ArrayList<>();
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT TBL_VENDA.ID_VENDA, TBL_VENDA.NOME_PRODUTO, TBL_VENDA.ID_PRODUTO, "
                    + " TBL_VENDA.QTD_ITENS, TBL_VENDA.ID_USUARIO, TBL_VENDA.ID_FILIAL, TBL_VENDA.CPF_CLIENTE, TBL_VENDA.DATA_VENDA "
                    + " FROM TBL_VENDA"
                    + " INNER JOIN TBL_FILIAL ON TBL_VENDA.ID_FILIAL = TBL_FILIAL.ID_FILIAL "
                    + " WHERE TBL_VENDA.DATA_VENDA >= ? AND TBL_VENDA.DATA_VENDA <= ? "
                    + " ORDER BY TBL_VENDA.DATA_VENDA AND TBL_VENDA.ID_FILIAL;");

            /*
            query.setString(1, ??);
            query.setString(2, ???);*/
            //Ver de onde sera tirado o conteudo da clausula where
            ResultSet rs = query.executeQuery();

            getRelatorio.add(new Relatorio(
                    rs.getInt(0),
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getDouble(4),
                    rs.getInt(5),
                    rs.getString(6),
                    rs.getInt(7),
                    rs.getString(8)
            ));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return getRelatorio;
    }

}
