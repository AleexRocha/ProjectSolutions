package Controller;

import DAO.RelatorioDAO;
import Model.Relatorio;
import java.util.ArrayList;

/**
 *
 * @author daniel
 */
public class RelatorioController {

    /**
     *
     * @param rDataVenda - String
     * @param rCodigoFilial - int
     * @param rNomeProduto - String
     * @param rCodigoProduto - int
     * @param rQuantidadeProduto - int
     * @return
     */
    public static boolean salvarRelatorio(String rDataVenda, int rCodigoFilial, String rNomeProduto, int rCodigoProduto, int rQuantidadeProduto) {
        Relatorio r = new Relatorio(rDataVenda, rCodigoFilial, rNomeProduto, rCodigoProduto, rQuantidadeProduto);
        return RelatorioDAO.salvarRelatorio(r);
    }

    public static ArrayList<String[]> getRelatorio() {
        ArrayList<Relatorio> relatorios = RelatorioDAO.getRelatorios();
        ArrayList<String[]> listaRelatorios = new ArrayList<>();

        for (int i = 0; i < relatorios.size(); i++) {
            listaRelatorios.add(
                    new String[]{
                        relatorios.get(i).getDataVenda(),
                        String.valueOf(relatorios.get(i).getCodigoFilial()),
                        relatorios.get(i).getNomeProduto(),
                        String.valueOf(relatorios.get(i).getCodigoProduto()),
                        String.valueOf(relatorios.get(i).getQuantidadeProduto()),});
        }
        return listaRelatorios;
    }
}
