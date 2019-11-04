package Model;

/**
 *
 * @author guilherme.rsvieira
 */
public class Venda {

    private long codigoVenda;
    private int codigoProduto;
    private int nomeProduto;
    private double valorUnitario;
    private int quantidadeVendida;
    private double totalVenda;
    private int codigoUsuario;
    private String cpfUsuario;

    public Venda() {
    }

    public Venda(int codigoProduto, int nomeProduto, double valorUnitario, int quantidadeVendida, double totalVenda) {
        this.codigoProduto = codigoProduto;
        this.nomeProduto = nomeProduto;
        this.valorUnitario = valorUnitario;
        this.quantidadeVendida = quantidadeVendida;
        this.totalVenda = totalVenda;
    }

    public Venda(long codigoVenda, int codigoProduto, int nomeProduto, double valorUnitario, int quantidadeVendida, double totalVenda, int codigoUsuario, String cpfUsuario) {
        this.codigoVenda = codigoVenda;
        this.codigoProduto = codigoProduto;
        this.nomeProduto = nomeProduto;
        this.valorUnitario = valorUnitario;
        this.quantidadeVendida = quantidadeVendida;
        this.totalVenda = totalVenda;
        this.codigoUsuario = codigoUsuario;
        this.cpfUsuario = cpfUsuario;
    }

    public long getCodigoVenda() {
        return codigoVenda;
    }

    public void setCodigoVenda(long codigoVenda) {
        this.codigoVenda = codigoVenda;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public int getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(int nomeProduto) {
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

    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getCpfUsuario() {
        return cpfUsuario;
    }

    public void setCpfUsuario(String cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }

    @Override
    public String toString() {
        return "Venda{" + "codigoVenda=" + codigoVenda + ", codigoProduto=" + codigoProduto + ", quantidadeVendida=" + quantidadeVendida + ", totalVenda=" + totalVenda + ", codigoUsuario=" + codigoUsuario + ", cpfUsuario=" + cpfUsuario + '}';
    }
}
