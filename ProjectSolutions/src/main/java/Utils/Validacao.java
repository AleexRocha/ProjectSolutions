package Utils;

/**
 *
 * @author Alexsander Rocha
 */
public class Validacao {

    public static String[] validaRelatorio(String rFilial, String rDataDe, String rDataAte) {
        String msg[] = null;
        int contador = 0;
        boolean error = false;
        if (rFilial != null) {
            if (!Validacao.validaFilial(rFilial)) {
                error = true;
                msg[contador] = "Nome da filial incorreta";
                contador++;
            }
        } else {

        }
        if (rDataDe != null) {
            if (!Validacao.validaData(rDataDe)) {
                error = true;
                msg[contador] = "Data inicial está incorreta";
                contador++;
            }
        } else {

        }
        if (rDataDe != null) {
            if (Validacao.validaData(rDataAte)) {
                error = true;
                msg[contador] = "Data final está incorreta";
                contador++;
            }
        } else {

        }
        return msg;
    }

    public static boolean validaFilial(String filial) {
        return filial.matches("(?i)[^\\D]");
    }

    public static boolean validaData(String data) {
        return data.matches("\\d{2}/\\d{2}/\\d{4}");
    }
}
