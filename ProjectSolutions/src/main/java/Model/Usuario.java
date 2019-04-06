package Model;

/**
 *
 * @author guilherme.rsvieira
 */
public class Usuario {

    private int codigo;
    private String nome;
    private String email;
    private String senha;
    private int codigoFilial;
    private String setor;

    public Usuario(String nome, String email, String senha, int codigoFilial, String setor) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.codigoFilial = codigoFilial;
        this.setor = setor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getCodigoFilial() {
        return codigoFilial;
    }

    public void setCodigoFilial(int codigoFilial) {
        this.codigoFilial = codigoFilial;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

}
