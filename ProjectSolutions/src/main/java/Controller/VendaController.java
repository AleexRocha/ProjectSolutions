package Controller;

import DAO.VendaDAO;
import Model.Venda;
import java.util.ArrayList;

/**
 *
 * @author daniel
 */
public class VendaController {

    /**
     *
     * @param vNomeProduto - String
     * @param vCodigoProduto - int
     * @param vQuantidadeVenda - int
     * @param vIdFuncionario - int
     * @param vCodigoFilial - int
     * @param vCpfCliente - int
     * @return
     */
    public static boolean salvarVenda(String vNomeProduto, int vCodigoProduto, int vQuantidadeVenda, int vIdFuncionario, int vCodigoFilial, int vCpfCliente) {
        Venda v = new Venda(vNomeProduto, vCodigoProduto, vQuantidadeVenda, vIdFuncionario, vCodigoFilial, vCpfCliente);
        return VendaDAO.salvarVenda(v);
    }

    /**
     * @param vCodigo - int
     * @return
     *
     */
    public static boolean excluirVenda(int vCodigo) {
        return VendaDAO.excluirVenda(vCodigo);
    }

    /**
     *
     * @param vCodigo - int
     * @param vNomeProduto - String
     * @param vCodigoProduto - int
     * @param vQuantidadeVenda - int
     * @param vIdFuncionario - int
     * @param vCodigoFilial - int
     * @param vCpfCliente - int
     * @return
     */
    public static boolean atualizarVenda(int vCodigo, String vNomeProduto, int vCodigoProduto, int vQuantidadeVenda, int vIdFuncionario, int vCodigoFilial, int vCpfCliente) {
        Venda v = new Venda(vNomeProduto, vCodigoProduto, vQuantidadeVenda, vIdFuncionario, vCodigoFilial, vCpfCliente);
        v.setCodigo(vCodigo);
        return VendaDAO.salvarVenda(v);
    }

    public static ArrayList<String[]> getVenda() {
        ArrayList<Venda> vendas = VendaDAO.getVendas();
        ArrayList<String[]> listaVendas = new ArrayList<>();

        for (int i = 0; i < vendas.size(); i++) {
            listaVendas.add(
                    new String[]{
                        String.valueOf(vendas.get(i).getCodigo()),
                        vendas.get(i).getNomeProduto(),
                        String.valueOf(vendas.get(i).getCodigoProduto()),
                        String.valueOf(vendas.get(i).getQuantidadeVenda()),
                        String.valueOf(vendas.get(i).getIdFuncionario()),
                        String.valueOf(vendas.get(i).getCodigoFilial()),
                        String.valueOf(vendas.get(i).getCpfCliente()),});
        }
        return listaVendas;
    }
}
