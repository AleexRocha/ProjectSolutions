package Controller;

import DAO.ServiçoDAO;
import Model.Serviço;
import java.util.ArrayList;

/**
 *
 * @author daniel
 */
public class ServiçoController {

    /**
     *
     * @param sNome - String
     * @param sDescricao - String
     * @param sCodigoFilial - int
     * @return
     */
    public static boolean salvarServiço(String sNome, String sDescricao, int sCodigoFilial) {
        Serviço s = new Serviço(sNome, sDescricao, sCodigoFilial);
        return ServiçoDAO.salvarServiço(s);
    }

    /**
     * @param sCodigo - int
     * @return
     *
     */
    public static boolean excluirServiço(int sCodigo) {
        return ServiçoDAO.excluirServiço(sCodigo);
    }

    /**
     *
     * @param sCodigo - int
     * @param sNome - String
     * @param sDescricao - String
     * @param sCodigoFilial - int
     * @return
     */
    public static boolean atualizarServiço(int sCodigo, String sNome, String sDescricao, int sCodigoFilial) {
        Serviço s = new Serviço(sNome, sDescricao, sCodigoFilial);
        s.setCodigo(sCodigo);
        return ServiçoDAO.salvarServiço(s);
    }

    public static ArrayList<String[]> getServiço() {
        ArrayList<Serviço> serviços = ServiçoDAO.getServiços();
        ArrayList<String[]> listaServiços = new ArrayList<>();

        for (int i = 0; i < serviços.size(); i++) {
            listaServiços.add(
                    new String[]{
                        String.valueOf(serviços.get(i).getCodigo()),
                        serviços.get(i).getNome(),
                        serviços.get(i).getDescricao(),
                        String.valueOf(serviços.get(i).getCodigoFilial()),});
        }
        return listaServiços;
    }
}
