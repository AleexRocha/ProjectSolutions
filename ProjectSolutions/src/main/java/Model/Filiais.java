package Model;

/**
 *
 * @author guilherme.rsvieira
 */
public class Filiais {

    private int codFilial;
    private String logaDouro;
    private int numero;
    private int cep;
    private String bairro;
    private String estado;
    private String cidade;
    private int telefone;

    public int getCodFilial() {
        return codFilial;
    }

    public Filiais(int codFilial, String logaDouro, int numero, int cep, String bairro, String estado, String cidade, int telefone) {
        this.codFilial = codFilial;
        this.logaDouro = logaDouro;
        this.numero = numero;
        this.cep = cep;
        this.bairro = bairro;
        this.estado = estado;
        this.cidade = cidade;
        this.telefone = telefone;
    }

    public void setCodFilial(int codFilial) {
        this.codFilial = codFilial;
    }

    public String getLogaDouro() {
        return logaDouro;
    }

    public void setLogaDouro(String logaDouro) {
        this.logaDouro = logaDouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }



}
