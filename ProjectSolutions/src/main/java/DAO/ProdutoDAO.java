package DAO;

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

    private static final Database db = new Database();

    public static boolean salvarProduto(Produto p) {
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("INSERT INTO"
                    + " tbl_produtos(nome, descricao, tipo, fk_filial, qtd_estoque, valor_unidade)"
                    + "VALUES (?, ?, ?, ?, ?, ?);");
            query.setString(1, p.getNome());
            query.setString(2, p.getDescricao());
            query.setString(3, p.getTipo());
            query.setInt(4, p.getCodigoFilial());
            query.setInt(5, p.getQuantidadeEstoque());
            query.setDouble(6, p.getValorUnitario());

            int rs = query.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }

        return true;
    }

    public static boolean excluirProduto(int pCodigo) {
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("DELETE FROM tbl_produtos WHERE id_produto = ?");

            query.setInt(1, pCodigo);

            ResultSet linhasAfetadas = query.executeQuery();

        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }

        return true;
    }

    public static ArrayList<Produto> getProdutos() {
        ArrayList<Produto> produtos = new ArrayList<>();
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT * "
                    + "FROM tbl_produtos "
                    + "INNER JOIN tbl_filial "
                    + "ON tbl_produtos.fk_filial = tbl_filial.id_filial;");

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

        } catch (SQLException e) {
            System.out.println(e);
        }

        return produtos;
    }

}
