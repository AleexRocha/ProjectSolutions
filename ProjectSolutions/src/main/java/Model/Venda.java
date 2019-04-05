package Model;

/**
 *
 * @author guilherme.rsvieira
 */
public class Venda {

    private String nomeProd;
    private int codProd;
    private int qtdVenda;
    private int idFunc;
    private int codFilial;

    public Venda(String nomeProd, int codProd, int qtdVenda, int idFunc, int codFilial) {
        this.nomeProd = nomeProd;
        this.codProd = codProd;
        this.qtdVenda = qtdVenda;
        this.idFunc = idFunc;
        this.codFilial = codFilial;
    }

    
    public String getNomeProd() {
        return nomeProd;
    }

    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd;
    }

    public int getCodProd() {
        return codProd;
    }

    public void setCodProd(int codProd) {
        this.codProd = codProd;
    }

    public int getQtdVenda() {
        return qtdVenda;
    }

    public void setQtdVenda(int qtdVenda) {
        this.qtdVenda = qtdVenda;
    }

    public int getIdFunc() {
        return idFunc;
    }

    public void setIdFunc(int idFunc) {
        this.idFunc = idFunc;
    }

    public int getCodFilial() {
        return codFilial;
    }

    public void setCodFilial(int codFilial) {
        this.codFilial = codFilial;
    }
    
}
