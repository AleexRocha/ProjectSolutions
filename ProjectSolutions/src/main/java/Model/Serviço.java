package Model;

/**
 *
 * @author guilherme.rsvieira
 */
public class Serviço {

    private int codigo;
    private String nome;
    private String descricao;
    private String filial;

    public Serviço(int codigo, String nome, String descricao, String filial) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.filial = filial;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFilial() {
        return filial;
    }

    public void setFilial(String filial) {
        this.filial = filial;
    }

}
