package Model;

/**
 *
 * @author guilherme.rsvieira
 */
public class Produto {

    private int codProd;
    private String nomeProd;
    private String descricao;
    private String filial;
    private int qtdEstoque;
    private double valorUnidade;

    public Produto(int codProd, String nomeProd, String descricao, String filial, int qtdEstoque, double valorUnidade) {
        this.codProd = codProd;
        this.nomeProd = nomeProd;
        this.descricao = descricao;
        this.filial = filial;
        this.qtdEstoque = qtdEstoque;
        this.valorUnidade = valorUnidade;
    }

    public int getCodProd() {
        return codProd;
    }

    public void setCodProd(int codProd) {
        this.codProd = codProd;
    }

    public String getNomeProd() {
        return nomeProd;
    }

    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd;
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

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public double getValorUnidade() {
        return valorUnidade;
    }

    public void setValorUnidade(double valorUnidade) {
        this.valorUnidade = valorUnidade;
    }


  

        
}
