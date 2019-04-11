package Controller;

import DAO.ProdutoDAO;
import Model.Produto;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author daniel
 */
public class ProdutoController {

    /**
     *
     * @param pNome - String
     * @param pDescricao - String
     * @param pCodigoFilial - int
     * @param pQuantidadeEstoque - int
     * @param pValorUnitario - int
     * @return
     */
    public static boolean salvarProduto(String pNome, String pDescricao, int pCodigoFilial, int pQuantidadeEstoque, double pValorUnitario) throws SQLException {
        Produto p = new Produto(pNome, pDescricao, pCodigoFilial, pQuantidadeEstoque, pValorUnitario);
        return ProdutoDAO.salvarProduto(p);
    }

    /**
     * @param pCodigo - int
     * @return
     *
     */
    public static boolean excluirProduto(int pCodigo) throws SQLException {
        return ProdutoDAO.excluirProduto(pCodigo);
    }

    /**
     *
     * @param pCodigo - int
     * @param pNome - String
     * @param pDescricao - String
     * @param pCodigoFilial - int
     * @param pQuantidadeEstoque - int
     * @param pValorUnitario - int
     * @return
     */
    public static boolean atualizarProduto(int pCodigo, String pNome, String pDescricao, int pCodigoFilial, int pQuantidadeEstoque, double pValorUnitario) throws SQLException {
        Produto p = new Produto(pNome, pDescricao, pCodigoFilial, pQuantidadeEstoque, pValorUnitario);
        p.setCodigo(pCodigo);
        return ProdutoDAO.salvarProduto(p);
    }

    public static ArrayList<String[]> getProduto() throws SQLException {
        ArrayList<Produto> produtos = ProdutoDAO.getProdutos();
        ArrayList<String[]> listaProdutos = new ArrayList<>();

        for (int i = 0; i < produtos.size(); i++) {
            listaProdutos.add(
                    new String[]{
                        String.valueOf(produtos.get(i).getCodigo()),
                        produtos.get(i).getNome(),
                        produtos.get(i).getDescricao(),
                        String.valueOf(produtos.get(i).getCodigoFilial()),
                        String.valueOf(produtos.get(i).getQuantidadeEstoque()),
                        String.valueOf(produtos.get(i).getValorUnitario()),});
        }
        return listaProdutos;
    }
}
