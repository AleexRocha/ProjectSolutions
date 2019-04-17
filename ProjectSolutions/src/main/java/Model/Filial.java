package Model;

/**
 *
 * @author guilherme.rsvieira
 */
public class Filial {

    private int codigo;
    private String logradouro;
    private int numero;
    private String cep;
    private String bairro;
    private String estado;
    private String cidade;
    private String telefone;

    public Filial(int codigo, String logradouro, int numero, String cep, String bairro, String estado, String cidade, String telefone) {
        this.codigo = codigo;
        this.logradouro = logradouro;
        this.numero = numero;
        this.cep = cep;
        this.bairro = bairro;
        this.estado = estado;
        this.cidade = cidade;
        this.telefone = telefone;
    }

    
    public Filial(String logradouro, int numero, String cep, String bairro, String estado, String cidade, String telefone) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.cep = cep;
        this.bairro = bairro;
        this.estado = estado;
        this.cidade = cidade;
        this.telefone = telefone;
    }

    public Filial(int fCd_filial) {
        codigo = fCd_filial;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
