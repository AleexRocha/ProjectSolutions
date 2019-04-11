package Model;

/**
 *
 * @author guilherme.rsvieira
 */
public class Produto {

    private int codigo;
    private String nome;
    private String descricao;
    private int codigoFilial;
    private int quantidadeEstoque;
    private double valorUnitario;

    public Produto(String nome, String descricao, int codigoFilial, int quantidadeEstoque, double valorUnitario) {
        this.nome = nome;
        this.descricao = descricao;
        this.codigoFilial = codigoFilial;
        this.quantidadeEstoque = quantidadeEstoque;
        this.valorUnitario = valorUnitario;
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

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario (double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

}
