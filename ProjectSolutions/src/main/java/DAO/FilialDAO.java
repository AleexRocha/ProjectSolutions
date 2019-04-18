/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Filial;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author alexsander.mrocha
 */
public class FilialDAO {

    private static Database db = new Database();

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
            e.printStackTrace();
            System.out.println(e);
            return false;
        }

        return true;
    }

    public static boolean excluirFilial(int fCodigo) {
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("DELETE FROM TBL_FILIAL WHERE ID_FILIAL = ?");

            query.setInt(1, fCodigo);

            ResultSet linhasAfetadas = query.executeQuery();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static boolean atualizarFilial(Filial f) {
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("UPDATE"
                    + " TBL_FILIAL SET (LOGRADOURO = ?,"
                    + " NUMERO = ?,"
                    + " CEP = ?,"
                    + " BAIRRO = ?,"
                    + " CIDADE = ?,"
                    + " ESTADO = ?,"
                    + " TELEFONE = ?) WHERE ID_FILIAL = ?;");

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
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static ArrayList<Filial> getFiliais() {
        ArrayList<Filial> filiais = new ArrayList<>();
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM"
                    + " TBL_FILIAL;");

            ResultSet rs = query.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    filiais.add(new Filial(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getInt(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getString(8)
                    ));

                }
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return filiais;
    }

    public static Filial getFilial(int codigo) {
        Filial filial = null;
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM"
                    + " TBL_FILIAL WHERE id_filial = ?;");

            query.setInt(1, codigo);
            ResultSet rs = query.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    filial = new Filial(
                            rs.getInt(0),
                            rs.getString(1),
                            rs.getInt(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7)
                    );
                }
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return filial;
    }
}
