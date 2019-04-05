package Model;

/**
 *
 * @author guilherme.rsvieira
 */
public class Produtos_Serviços {

    private int codProd;
    private String nome;
    private String descricao;
    private String tipo;
    private String Filial;
    private float qtdEstoque;
    private float qtdVendida;
    private int valorUnidade;

    public Produtos_Serviços(int codProd, String nome, String descricao, String tipo, String Filial, float qtdEstoque, float qtdVendida, int valorUnidade) {
        this.codProd = codProd;
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.Filial = Filial;
        this.qtdEstoque = qtdEstoque;
        this.qtdVendida = qtdVendida;
        this.valorUnidade = valorUnidade;
    }

    
    public float getQtdVendida() {
        return qtdVendida;
    }

    public void setQtdVendida(float qtdVendida) {
        this.qtdVendida = qtdVendida;
    }

    
    public int getCodProd() {
        return codProd;
    }

    public void setCodProd(int codProd) {
        this.codProd = codProd;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFilial() {
        return Filial;
    }

    public void setFilial(String Filial) {
        this.Filial = Filial;
    }

    public float getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(float qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public int getValorUnidade() {
        return valorUnidade;
    }

    public void setValorUnidade(int valorUnidade) {
        this.valorUnidade = valorUnidade;
    }
}
