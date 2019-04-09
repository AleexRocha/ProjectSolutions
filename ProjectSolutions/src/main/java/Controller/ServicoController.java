package Controller;

import DAO.ServicoDAO;
import Model.Servico;
import java.util.ArrayList;

/**
 *
 * @author daniel
 */
public class ServicoController {

    /**
     *
     * @param sNome - String
     * @param sDescricao - String
     * @param sCodigoFilial - int
     * @return
     */
    public static boolean salvarServiço(String sNome, String sDescricao, int sCodigoFilial) {
        Servico s = new Servico(sNome, sDescricao, sCodigoFilial);
        return ServicoDAO.salvarServiço(s);
    }

    /**
     * @param sCodigo - int
     * @return
     *
     */
    public static boolean excluirServiço(int sCodigo) {
        return ServicoDAO.excluirServiço(sCodigo);
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
        Servico s = new Servico(sNome, sDescricao, sCodigoFilial);
        s.setCodigo(sCodigo);
        return ServicoDAO.salvarServiço(s);
    }

    public static ArrayList<String[]> getServiço() {
        ArrayList<Servico> serviços = ServicoDAO.getServiços();
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
