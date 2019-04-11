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

    /*public static boolean salvarRelatorio(Relatorio r) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    public static ArrayList<Relatorio> getRelatorios() throws SQLException {
        /* ArrayList<Filial> filiais = new ArrayList<>();
        Connection conn = db.obterConexao();
        PreparedStatement query = conn.prepareStatement("SELECT * FROM"
        + " TBL_FILIAL;");
        
        try {
        ResultSet rs = query.executeQuery();
        
        if (rs != null) {
        while (rs.next()) {
        filiais.add(new Filial(
        rs.getString(1),
        rs.getInt(2),
        rs.getString(3),
        rs.getString(4),
        rs.getString(5),
        rs.getString(6),
        rs.getString(7)
        ));
        
        }
        }
        
        } catch (SQLException e) {
        e.printStackTrace();
        }
        
        return filiais;*/
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.       
    }

}
