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

    public static ArrayList<Venda> getItemVenda() {
        ArrayList<Venda> venda = new ArrayList<>();
        Connection conn = db.obterConexao();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT id_produto, "
                    + "(SELECT id_usuario FROM tbl_usuario) AS id_usuario, "
                    + "(SELECT id_filial FROM tbl_filial) AS id_filial "
                    + "FROM tbl_produtos;");

            ResultSet rs = query.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    venda.add(new Venda(
                            rs.getInt(1),
                            rs.getInt(2),
                            rs.getInt(3)
                    ));
                }
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return venda;
    }

}
