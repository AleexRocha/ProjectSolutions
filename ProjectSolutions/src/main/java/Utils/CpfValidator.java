package Utils;

/**
 *
 * @author nicolas.hgyoshioka
 */
public class CpfValidator {

    private static final int[] pesoCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};

    private static int calculaDigitos(String val, int[] peso) {
        int soma = 0;
        for (int idx = val.length() - 1, digito; idx >= 0; idx--) {
            digito = Integer.parseInt(val.substring(idx, idx + 1));
            soma += digito * peso[peso.length - val.length() + idx];
        }
        soma = 11 - soma % 11;
        return soma > 9 ? 0 : soma;
    }

    public static boolean validaCpf(String cpf) {
        if (!cpf.matches("[0-9]+")) {
            return false;
        } else {
            Integer digito1 = calculaDigitos(cpf.substring(0, 9), pesoCPF);
            Integer digito2 = calculaDigitos(cpf.substring(0, 9) + digito1, pesoCPF);
            if (cpf.equals(cpf.substring(0, 9) + digito1.toString() + digito2.toString())) {
                return true;
            } else {
                return false;
            }
        }

    }

}
