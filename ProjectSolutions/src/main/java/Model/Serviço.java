package Model;

/**
 *
 * @author guilherme.rsvieira
 */
public class Serviço {

    private int codigo;
    private String nome;
    private String descricao;
    private int codigoFilial;

    public Serviço(String nome, String descricao, int codigoFilial) {
        this.nome = nome;
        this.descricao = descricao;
        this.codigoFilial = codigoFilial;
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

    public int getCodigoFilial() {
        return codigoFilial;
    }

    public void setCodigoFilial(int codigoFilial) {
        this.codigoFilial = codigoFilial;
    }

}
