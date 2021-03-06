package Model;

/**
 *
 * @author guilherme.rsvieira
 */
public class Relatorio {

    private int codigoVenda;
    private String nomeProduto;
    private int codigoProduto;
    private int quantidadeProduto;
    private double valorTotal;
    private String cpfCliente;
    private int idUsuario;
    private String dataVenda;
    private int status;

    public Relatorio() {
    }

    public Relatorio(int codigoVenda, int codigoProduto, int idUsuario, int quantidadeProduto, String cpfCliente, String dataVenda) {
        this.codigoVenda = codigoVenda;
        this.codigoProduto = codigoProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.idUsuario = idUsuario;
        this.cpfCliente = cpfCliente;
        this.dataVenda = dataVenda;
    }

    public Relatorio(int codigoVenda, String nomeProduto, int codigoProduto, int quantidadeProduto, double valorTotal, String cpfCliente, int idUsuario, String dataVenda) {
        this.codigoVenda = codigoVenda;
        this.nomeProduto = nomeProduto;
        this.codigoProduto = codigoProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.valorTotal = valorTotal;
        this.cpfCliente = cpfCliente;
        this.idUsuario = idUsuario;
        this.dataVenda = dataVenda;
    }
    
    public Relatorio(int codigoVenda, String nomeProduto, int codigoProduto, int quantidadeProduto, double valorTotal, String cpfCliente, int idUsuario, String dataVenda, int status) {
        this.codigoVenda = codigoVenda;
        this.nomeProduto = nomeProduto;
        this.codigoProduto = codigoProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.valorTotal = valorTotal;
        this.cpfCliente = cpfCliente;
        this.idUsuario = idUsuario;
        this.dataVenda = dataVenda;
        this.status = status;
    }

    public int getCodigoVenda() {
        return codigoVenda;
    }

    public void setCodigoVenda(int codigoVenda) {
        this.codigoVenda = codigoVenda;
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
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }
    
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    
}
