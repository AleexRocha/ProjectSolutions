package Model;

/**
 *
 * @author guilherme.rsvieira
 */
public class Venda {

    private int idVenda;
    private String codigoVenda;
    private int quantidadeTotalVenda;
    private double valorFrete;
    private double valorTotalVenda;
    private String dataVenda;
    private int idEndereco;
    private int idUsuario;
    private int idStatus;
    private int idProduto;
    private int idPagamento;
    private double valorUnitarioProduto;
    private int quantidadeUnitarioProduto;
    private double valorTotalProduto;

    public Venda() {
    }

    //    Objeto que vem do JSON
    public Venda(int idProduto, double valorUnitarioProduto, int quantidadeUnitarioProduto, double valorTotalProduto) {
        this.idProduto = idProduto;
        this.valorUnitarioProduto = valorUnitarioProduto;
        this.quantidadeUnitarioProduto = quantidadeUnitarioProduto;
        this.valorTotalProduto = valorTotalProduto;
    }

    //    Objeto que vem do JSON
    public Venda(int idProduto, double valorUnitarioProduto, int quantidadeUnitarioProduto, double valorTotalProduto, int idEndereco, double valorFrete) {
        this.idProduto = idProduto;
        this.valorUnitarioProduto = valorUnitarioProduto;
        this.quantidadeUnitarioProduto = quantidadeUnitarioProduto;
        this.valorTotalProduto = valorTotalProduto;
        this.idEndereco = idEndereco;
        this.valorFrete = valorFrete;
    }

    //    Objeto salvo na tbl_produtos_venda
    public Venda(int idVenda, int idProduto, int quantidadeUnitarioProduto) {
        this.idVenda = idVenda;
        this.idProduto = idProduto;
        this.quantidadeUnitarioProduto = quantidadeUnitarioProduto;
    }
    
        //    Objeto salvo na tbl_venda
    public Venda(String codigoVenda, int quantidadeTotalVenda, double valorTotalVenda, String dataVenda, int idUsuario, int idStatus, int idPagamento) {
        this.codigoVenda = codigoVenda;
        this.quantidadeTotalVenda = quantidadeTotalVenda;
        this.valorTotalVenda = valorTotalVenda;
        this.dataVenda = dataVenda;
        this.idUsuario = idUsuario;
        this.idStatus = idStatus;
        this.idPagamento = idPagamento;
    }


    //    Objeto salvo na tbl_venda
    public Venda(String codigoVenda, int quantidadeTotalVenda, int valorFrete, double valorTotalVenda, String dataVenda, int idEndereco, int idUsuario, int idStatus, int idPagamento) {
        this.codigoVenda = codigoVenda;
        this.quantidadeTotalVenda = quantidadeTotalVenda;
        this.valorFrete = valorFrete;
        this.valorTotalVenda = valorTotalVenda;
        this.dataVenda = dataVenda;
        this.idEndereco = idEndereco;
        this.idUsuario = idUsuario;
        this.idStatus = idStatus;
        this.idPagamento = idPagamento;
    }

    //    Objeto geral tbl_venda
    public Venda(int idVenda, String codigoVenda, int quantidadeTotalVenda, double valorFrete, double valorTotalVenda, String dataVenda, int idEndereco, int idUsuario, int idStatus, int idPagamento) {
        this.idVenda = idVenda;
        this.codigoVenda = codigoVenda;
        this.quantidadeTotalVenda = quantidadeTotalVenda;
        this.valorFrete = valorFrete;
        this.valorTotalVenda = valorTotalVenda;
        this.dataVenda = dataVenda;
        this.idEndereco = idEndereco;
        this.idUsuario = idUsuario;
        this.idStatus = idStatus;
        this.idPagamento = idPagamento;
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

    public int getQuantidadeTotalVenda() {
        return quantidadeTotalVenda;
    }

    public void setQuantidadeTotalVenda(int quantidadeTotalVenda) {
        this.quantidadeTotalVenda = quantidadeTotalVenda;
    }

    public double getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(double valorFrete) {
        this.valorFrete = valorFrete;
    }

    public double getValorTotalVenda() {
        return valorTotalVenda;
    }

    public void setValorTotalVenda(double valorTotalVenda) {
        this.valorTotalVenda = valorTotalVenda;
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

    public int getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(int idPagamento) {
        this.idPagamento = idPagamento;
    }

    public double getValorUnitarioProduto() {
        return valorUnitarioProduto;
    }

    public void setValorUnitarioProduto(double valorUnitarioProduto) {
        this.valorUnitarioProduto = valorUnitarioProduto;
    }

    public int getQuantidadeUnitarioProduto() {
        return quantidadeUnitarioProduto;
    }

    public void setQuantidadeUnitarioProduto(int quantidadeUnitarioProduto) {
        this.quantidadeUnitarioProduto = quantidadeUnitarioProduto;
    }

    public double getValorTotalProduto() {
        return valorTotalProduto;
    }

    public void setValorTotalProduto(double valorTotalProduto) {
        this.valorTotalProduto = valorTotalProduto;
    }
   
}
