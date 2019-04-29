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
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }

        return true;
    }

    public static boolean atualizarProduto(Produto produto) {
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("UPDATE"
                    + " tbl_produtos SET "
                    + " nome = ?,"
                    + " tipo = ?,"
                    + " fk_filial = ?,"
                    + " qtd_estoque = ?,"
                    + " valor_unidade = ? WHERE id_produto = ?;");

            query.setString(1, produto.getNome());
            query.setString(2, produto.getTipo());
            query.setInt(3, produto.getCodigoFilial());
            query.setInt(4, produto.getQuantidadeEstoque());
            query.setDouble(5, produto.getValorUnitario());
            query.setInt(6, produto.getCodigo());
            
            int linhasAfetadas = query.executeUpdate();
            conn.close();
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
            conn.close();
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
            PreparedStatement query = conn.prepareStatement("SELECT * FROM tbl_produtos");

            ResultSet rs = query.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    produtos.add(new Produto(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getInt(5),
                            rs.getInt(6),
                            rs.getDouble(7)
                    ));

                }
            }

            conn.close();

        } catch (SQLException e) {
            System.out.println(e);
        }

        return produtos;
    }

    public static Produto getProduto(int codigo) {
        Produto produto = null;
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM"
                    + " tbl_produtos WHERE id_produto = ?;");

            query.setInt(1, codigo);
            ResultSet rs = query.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    produto = new Produto(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getInt(5),
                            rs.getInt(6),
                            rs.getDouble(7)
                    );
                }
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return produto;
    }
}
