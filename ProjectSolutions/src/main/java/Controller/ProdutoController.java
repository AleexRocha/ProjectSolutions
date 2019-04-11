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
     * @param pQuantidadeEstoque - int
     * @param pValorUnitario - int
     * @param pTipo - String
     * @param pCodigoFilial - int
     * @return boolean de sucesso ou error
     */
    public static boolean salvarProduto(String pNome, String pDescricao, String pTipo, int pCodigoFilial, int pQuantidadeEstoque, double pValorUnitario) {
        Produto p = new Produto(pNome, pDescricao, pTipo, pCodigoFilial, pQuantidadeEstoque, pValorUnitario);
        return ProdutoDAO.salvarProduto(p);
    }

    /**
     * @param pCodigo - int
     * @return boolean de sucesso ou error
     */
    public static boolean excluirProduto(int pCodigo) {
        return ProdutoDAO.excluirProduto(pCodigo);
    }

    /**
     *
     * @param pCodigo - int
     * @param pNome - String
     * @param pDescricao - String
     * @param pQuantidadeEstoque - int
     * @param pValorUnitario - int
     * @param pTipo - String
     * @param pCodigoFilial - int
     * @return boolean de sucesso ou error
     */
    public static boolean atualizarProduto(int pCodigo, String pNome, String pDescricao, String pTipo, int pCodigoFilial, int pQuantidadeEstoque, double pValorUnitario) {
        Produto p = new Produto(pNome, pDescricao, pTipo, pCodigoFilial, pQuantidadeEstoque, pValorUnitario);
        p.setCodigo(pCodigo);
        return ProdutoDAO.salvarProduto(p);
    }

    public static ArrayList<String[]> getProduto() {
        ArrayList<Produto> produtos = ProdutoDAO.getProdutos();
        ArrayList<String[]> listaProdutos = new ArrayList<>();

        for (int i = 0; i < produtos.size(); i++) {
            listaProdutos.add(
                    new String[]{
                        String.valueOf(produtos.get(i).getCodigo()),
                        produtos.get(i).getNome(),
                        produtos.get(i).getDescricao(),
                        String.valueOf(produtos.get(i).getQuantidadeEstoque()),
                        String.valueOf(produtos.get(i).getValorUnitario()),
                        produtos.get(i).getTipo(),
                        String.valueOf(produtos.get(i).getCodigoFilial())
                    });
        }
        return listaProdutos;
    }
}
