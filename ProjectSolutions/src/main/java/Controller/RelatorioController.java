package Controller;

import DAO.RelatorioDAO;
import Model.Relatorio;
import java.util.ArrayList;

/**
 *
 * @author daniel
 */
public class RelatorioController {

    public static ArrayList<String[]> getRelatorio() {
        ArrayList<Relatorio> relatorios = RelatorioDAO.getRelatorios();
        ArrayList<String[]> listaRelatorios = new ArrayList<>();

        for (int i = 0; i < relatorios.size(); i++) {
            listaRelatorios.add(
                    new String[]{
                        String.valueOf(relatorios.get(i).getCodigoVenda()),
                        String.valueOf(relatorios.get(i).getCodigoProduto()),
                        relatorios.get(i).getNomeProduto(),
                        String.valueOf(relatorios.get(i).getQuantidadeProduto()),
                        String.valueOf(relatorios.get(i).getValor()),
                        String.valueOf(relatorios.get(i).getIdFilial()),
                        relatorios.get(i).getNomeFilial(),
                        String.valueOf(relatorios.get(i).getIdFuncionario()),
                        relatorios.get(i).getDataVenda()
                    });
        }
        return listaRelatorios;
    }
}
