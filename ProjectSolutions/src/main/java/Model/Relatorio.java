package Model;

/**
 *
 * @author guilherme.rsvieira
 */
public class Relatorio {

    private String dataVenda;
    private int codigoFilial;
    private String nomeProduto;
    private int codigoProduto;
    private int QuantidadeProduto;

    public Relatorio(String dataVenda, int codigoFilial, String nomeProduto, int codigoProduto, int QuantidadeProduto) {
        this.dataVenda = dataVenda;
        this.codigoFilial = codigoFilial;
        this.nomeProduto = nomeProduto;
        this.codigoProduto = codigoProduto;
        this.QuantidadeProduto = QuantidadeProduto;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public int getCodigoFilial() {
        return codigoFilial;
    }

    public void setCodigoFilial(int codigoFilial) {
        this.codigoFilial = codigoFilial;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public int getQuantidadeProduto() {
        return QuantidadeProduto;
    }

    public void setQuantidadeProduto(int QuantidadeProduto) {
        this.QuantidadeProduto = QuantidadeProduto;
    }

}
