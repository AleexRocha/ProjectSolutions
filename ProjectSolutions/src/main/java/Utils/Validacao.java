package Utils;

/**
 *
 * @author Alexsander Rocha
 */
public class Validacao {

    public static boolean validaTexto(String texto) {
        return texto.matches("[a-zA-Z]");
    }

    public static boolean validaNumero(String numero) {
        return numero.matches("\\d");
    }

    public static boolean validaData(String data) {
        return data.matches("\\d{2}/\\d{2}/\\d{4}");
    }
}
