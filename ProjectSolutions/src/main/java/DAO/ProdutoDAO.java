package DAO;

import Model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author alexsander.mrocha
 */
public class ProdutoDAO {

    private static final Database db = new Database();

    public static int salvarProduto(Produto p) {
        int idProduto = 0;
        
        Connection conn = db.obterConexao();

        try {
            PreparedStatement query = conn.prepareStatement("INSERT INTO"
                    + " tbl_produtos(nome, descricao, tipo, qtd_estoque, valor_unidade, status)"
                    + " VALUES (?, ?, ?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
            query.setString(1, p.getNome());
            query.setString(2, p.getDescricao());
            query.setString(3, p.getTipo());
            query.setInt(4, p.getQuantidadeEstoque());
            query.setDouble(5, p.getValorUnitario());
            query.setInt(6, 0);

            query.executeUpdate();

            ResultSet rs = query.getGeneratedKeys();
            if (rs.next()) {
                idProduto = rs.getInt(1);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
            return idProduto;
        }

        return idProduto;
    }

    public static boolean atualizarProduto(Produto produto) {
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("UPDATE"
                    + " tbl_produtos SET "
                    + " nome = ?,"
                    + " descricao = ?,"
                    + " tipo = ?,"
                    + " qtd_estoque = ?,"
                    + " valor_unidade = ? WHERE id_produto = ?;");

            query.setString(1, produto.getNome());
            query.setString(2, produto.getDescricao());
            query.setString(3, produto.getTipo());
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
            PreparedStatement query = conn.prepareStatement("UPDATE tbl_produtos SET status = 1 WHERE id_produto = ?");

            query.setInt(1, pCodigo);

            query.execute();

            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }

        return true;
    }

    public static boolean excluirProdutos(String[] codigos) {
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("UPDATE tbl_produtos SET status = 1 WHERE id_produto = ?");

            for (String codigo : codigos) {
                query.setInt(1, Integer.parseInt(codigo));
                query.execute();
            }
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

        return true;
    }

    public static ArrayList<Produto> getProdutos() {
        ArrayList<Produto> produtos = new ArrayList<>();
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT"
                    + " p.id_produto,"
                    + " p.nome,"
                    + " p.descricao,"
                    + " p.tipo,"
                    + " p.qtd_estoque,"
                    + " p.valor_unidade,"
                    + " nome_arquivo "
                    + " FROM tbl_produtos AS p"
                    + " inner join tbl_imagem on"
                    + " p.id_produto = tbl_imagem.fk_produto"
                    + " WHERE p.status = 0;");
            
            ResultSet rs = query.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Produto produto = new Produto(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getInt(5),
                            rs.getDouble(6),
                            rs.getString(7));
                    produtos.add(produto);
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
            PreparedStatement query = conn.prepareStatement("SELECT"
                    + " p.id_produto,"
                    + " p.nome,"
                    + " p.descricao,"
                    + " p.tipo,"
                    + " p.qtd_estoque,"
                    + " p.valor_unidade,"
                    + " nome_arquivo"
                    + " FROM tbl_produtos AS p"
                    + " INNER JOIN tbl_imagem ON p.id_produto = tbl_imagem.fk_produto"
                    + " WHERE tbl_imagem.fk_produto = ? AND p.status = 0;");

            query.setInt(1, codigo);
            ResultSet rs = query.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Produto prod = new Produto(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getInt(5),
                            rs.getDouble(6),
                            rs.getString(7)
                    );
                    produto = prod;
                }
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return produto;
    }
}
