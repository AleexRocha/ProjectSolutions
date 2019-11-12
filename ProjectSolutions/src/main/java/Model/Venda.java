package Model;

/**
 *
 * @author guilherme.rsvieira
 */
public class Venda {

    private int idVenda;
    private String codigoVenda;
    private int quantidadeTotal;
    private double valorFrete;
    private double valorTotal;
    private String dataVenda;
    private int idEndereco;
    private int idUsuario;
    private int idStatus;
    private int idProduto;
    private double valorUnitario;
    private int quantidadeProduto;
    private double valorTotalProduto;

    public Venda() {
    }

    public Venda(int idProduto, double valorUnitario, int quantidadeProduto, double valorTotalProduto) {
        this.idProduto = idProduto;
        this.valorUnitario = valorUnitario;
        this.quantidadeProduto = quantidadeProduto;
        this.valorTotalProduto = valorTotalProduto;
    }

    public Venda(int idProduto, int quantidadeProduto, int quantidadeTotal, double valorTotal, int idEndereco, double valorFrete) {
        this.idProduto = idProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.quantidadeTotal = quantidadeTotal;
        this.valorTotal = valorTotal;
        this.idEndereco = idEndereco;
        this.valorFrete = valorFrete;
    }

    public Venda(String codigoVenda, int idProduto, int quantidadeProduto, int quantidadeTotal, double valorTotal, int idEndereco, double valorFrete, int idUsuario, int idStatus) {
        this.codigoVenda = codigoVenda;
        this.idProduto = idProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.quantidadeTotal = quantidadeTotal;
        this.valorTotal = valorTotal;
        this.idEndereco = idEndereco;
        this.valorFrete = valorFrete;
        this.idUsuario = idUsuario;
        this.idStatus = idStatus;
    }

    public Venda(int idVenda, String codigoVenda, int idProduto, int quantidadeProduto, int quantidadeTotal, double valorTotal, int idEndereco, double valorFrete, int idUsuario, int idStatus, String dataVenda) {
        this.idVenda = idVenda;
        this.codigoVenda = codigoVenda;
        this.idProduto = idProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.quantidadeTotal = quantidadeTotal;
        this.valorTotal = valorTotal;
        this.idEndereco = idEndereco;
        this.valorFrete = valorFrete;
        this.idUsuario = idUsuario;
        this.idStatus = idStatus;
        this.dataVenda = dataVenda;
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

    public int getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public void setQuantidadeTotal(int quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }

    public double getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(double valorFrete) {
        this.valorFrete = valorFrete;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    @Override
    public String toString() {
        return "Venda{" + "idProduto=" + idProduto + ", valorUnitario=" + valorUnitario + ", quantidadeProduto=" + quantidadeProduto + ", valorTotalProduto=" + valorTotalProduto + '}';
    }

    
    
}
