package DAO;

import Model.Imagem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Alexsander Rocha
 */
public class ImagemDAO {

    private static final Database db = new Database();

    public static int salvarImagem(Imagem i) {
        int id = 0;
        Connection conn = db.obterConexao();

        try {
            PreparedStatement query = conn.prepareStatement("INSERT INTO"
                    + " tbl_imagem(caminho, nome_arquivo)"
                    + " VALUES (?,?);", Statement.RETURN_GENERATED_KEYS);
            query.setString(1, i.getCaminho());
            query.setString(2, i.getNome());

            query.executeUpdate();

            ResultSet rs = query.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
            return id;
        }
        return id;
    }
    
    
    
}
