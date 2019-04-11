package Controller;

import DAO.RelatorioDAO;
import Model.Relatorio;
import java.util.ArrayList;

/**
 *
 * @author daniel
 */
public class RelatorioController {

    public static ArrayList<Relatorio> getRelatorio() {
        ArrayList<Relatorio> relatorioGerado = new ArrayList<>();
        relatorioGerado = RelatorioDAO.getRelatorios();

        return relatorioGerado;
    }
}
