package Model;

/**
 *
 * @author guilherme.rsvieira
 */
public class Venda {

//    private long codigoVenda;
    private String codigoProduto;
    private String nomeProduto;
    private double valorUnitario;
    private int quantidadeVendida;
    private double totalVenda;
//    private int codigoUsuario;
//    private String cpfUsuario;

    public Venda(String codigoProduto, String nomeProduto, double valorUnitario, int quantidadeVendida, double totalVenda) {
        this.codigoProduto = codigoProduto;
        this.nomeProduto = nomeProduto;
        this.valorUnitario = valorUnitario;
        this.quantidadeVendida = quantidadeVendida;
        this.totalVenda = totalVenda;
    }

    public Venda() {
        
    }

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public void setQuantidadeVendida(int quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }

    public double getTotalVenda() {
        return totalVenda;
    }

    public void setTotalVenda(double totalVenda) {
        this.totalVenda = totalVenda;
    }

    @Override
    public String toString() {
        return "Venda{" + "codigoProduto=" + codigoProduto + ", nomeProduto=" + nomeProduto + ", valorUnitario=" + valorUnitario + ", quantidadeVendida=" + quantidadeVendida + ", totalVenda=" + totalVenda + '}';
    }
}
