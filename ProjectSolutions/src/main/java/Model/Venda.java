package Model;

/**
 *
 * @author guilherme.rsvieira
 */
public class Venda {

    private int idVenda;
    private String codigoVenda;
    private int codigoUsuario;
    private int statusVenda;
    private int quantidadeTotal;
    private double totalVenda;
    private String dataVenda;

    private int codigoProduto;
    private int quantidadeItemProduto;

    public Venda() {
    }

    public Venda(String codigoVenda, int codigoUsuario, int quantidadeTotal, double totalVenda, int codigoProduto, int quantidadeItemProduto) {
        this.codigoVenda = codigoVenda;
        this.codigoUsuario = codigoUsuario;
        this.quantidadeTotal = quantidadeTotal;
        this.totalVenda = totalVenda;
        this.codigoProduto = codigoProduto;
        this.quantidadeItemProduto = quantidadeItemProduto;
    }

    public Venda(int idVenda, String codigoVenda, int codigoUsuario, int statusVenda, int quantidadeTotal, double totalVenda, String dataVenda, int codigoProduto, int quantidadeItemProduto) {
        this.idVenda = idVenda;
        this.codigoVenda = codigoVenda;
        this.codigoUsuario = codigoUsuario;
        this.statusVenda = statusVenda;
        this.quantidadeTotal = quantidadeTotal;
        this.totalVenda = totalVenda;
        this.dataVenda = dataVenda;
        this.codigoProduto = codigoProduto;
        this.quantidadeItemProduto = quantidadeItemProduto;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public String getCodigoVenda() {
        return codigoVenda;
    }

    public void setCodigoVenda(String codigoVenda) {
        this.codigoVenda = codigoVenda;
    }

    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public int getStatusVenda() {
        return statusVenda;
    }

    public void setStatusVenda(int statusVenda) {
        this.statusVenda = statusVenda;
    }

    public int getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public void setQuantidadeTotal(int quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }

    public double getTotalVenda() {
        return totalVenda;
    }

    public void setTotalVenda(double totalVenda) {
        this.totalVenda = totalVenda;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public int getQuantidadeItemProduto() {
        return quantidadeItemProduto;
    }

    public void setQuantidadeItemProduto(int quantidadeItemProduto) {
        this.quantidadeItemProduto = quantidadeItemProduto;
    }
}
