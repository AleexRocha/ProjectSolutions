package DAO;

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

    private static final Database db = new Database();

    public static boolean salvarVenda(Venda v) {
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("INSERT INTO"
                    + " tbl_venda(id_produto, id_funcionario, id_filial, qtd_itens, cpf_cliente, data_venda)"
                    + "VALUES (?, ?, ?, ?, ?, NOW());");

            query.setInt(1, v.getCodigoProduto());
            query.setInt(2, v.getIdFuncionario());
            query.setInt(3, v.getCodigoFilial());
            query.setInt(4, v.getQuantidadeVenda());
            query.setString(5, v.getCpfCliente());

            int rs = query.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            System.out.println("SQL Exception" + e);
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
            conn.close();
        } catch (SQLException e) {
            System.out.println("SQL Exception" + e);
            return false;
        }

        return true;
    }

    public static ArrayList<Venda> getProdutosVenda() {
        ArrayList<Venda> venda = new ArrayList<>();
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT id_produto, nome FROM tbl_produtos;");

            ResultSet rs = query.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Venda v = new Venda();
                    v.setCodigoProduto(rs.getInt(1));
                    v.setNomeProduto(rs.getString(2));
                    
                    venda.add(v);
                }
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return venda;
    }
    
    public static ArrayList<Venda> getUsuariosVenda() {
        ArrayList<Venda> venda = new ArrayList<>();
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT id_usuario, nome FROM tbl_usuario;");

            ResultSet rs = query.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Venda v = new Venda();
                    v.setIdFuncionario(rs.getInt(1));
                    v.setNomeFuncionario(rs.getString(2));
                    
                    venda.add(v);
                }
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return venda;
    }

    public static ArrayList<Venda> getFiliaisVenda() {
        ArrayList<Venda> venda = new ArrayList<>();
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("select id_filial, concat(estado, \"-\", cidade) as nome_filial from tbl_filial;");

            ResultSet rs = query.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Venda v = new Venda();
                    v.setCodigoFilial(rs.getInt(1));
                    v.setNomeFilial(rs.getString(2));
                    
                    venda.add(v);
                }
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return venda;
    }
    
}
