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
    private int idPagamento;

    private int idProduto;
    private double valorUnitarioProduto;
    private int quantidadeUnitarioProduto;
    private double valorTotalProduto;

    private String logradouroVenda;
    private String cepVenda;
    private int numeroEnderecoVenda;
    private String nomeStatusVenda;
    private String nomeFormaPagamentoVenda;
    private String numeroPagamentoVenda;
    private String nomeProdutoVenda;
    private int quantidadeUnitariaVenda;
    private double valorUnitarioProdutoVenda;

    public Venda() {
    }

    //    Objeto que vem do JSON
    public Venda(int idProduto, double valorUnitarioProduto, int quantidadeUnitarioProduto, double valorTotalProduto, int idEndereco, double valorFrete, int idPagamento) {
        this.idProduto = idProduto;
        this.valorUnitarioProduto = valorUnitarioProduto;
        this.quantidadeUnitarioProduto = quantidadeUnitarioProduto;
        this.valorTotalProduto = valorTotalProduto;
        this.idEndereco = idEndereco;
        this.valorFrete = valorFrete;
        this.idPagamento = idPagamento;
    }

    //    Objeto salvo na tbl_produtos_venda
    public Venda(int idVenda, int idProduto, int quantidadeUnitarioProduto) {
        this.idVenda = idVenda;
        this.idProduto = idProduto;
        this.quantidadeUnitarioProduto = quantidadeUnitarioProduto;
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
    public Venda(int idVenda, String codigoVenda, double valorFrete, double valorTotalVenda, String dataVenda, int quantidadeTotalVenda, String logradouroVenda, String cepVenda, int numeroEnderecoVenda, String nomeStatusVenda, String nomeFormaPagamentoVenda, String numeroPagamentoVenda) {
        this.idVenda = idVenda;
        this.codigoVenda = codigoVenda;
        this.valorFrete = valorFrete;
        this.valorTotalVenda = valorTotalVenda;
        this.dataVenda = dataVenda;
        this.quantidadeTotalVenda = quantidadeTotalVenda;
        this.logradouroVenda = logradouroVenda;
        this.cepVenda = cepVenda;
        this.numeroEnderecoVenda = numeroEnderecoVenda;
        this.nomeStatusVenda = nomeStatusVenda;
        this.nomeFormaPagamentoVenda = nomeFormaPagamentoVenda;
        this.numeroPagamentoVenda = numeroPagamentoVenda;
    }

    public Venda(int idVenda, String nomeProdutoVenda, int quantidadeUnitariaVenda, double valorUnitarioProdutoVenda) {
        this.idVenda = idVenda;
        this.nomeProdutoVenda = nomeProdutoVenda;
        this.quantidadeUnitariaVenda = quantidadeUnitariaVenda;
        this.valorUnitarioProdutoVenda = valorUnitarioProdutoVenda;
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

    public int getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(int idPagamento) {
        this.idPagamento = idPagamento;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
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

    public String getLogradouroVenda() {
        return logradouroVenda;
    }

    public void setLogradouroVenda(String logradouroVenda) {
        this.logradouroVenda = logradouroVenda;
    }

    public String getCepVenda() {
        return cepVenda;
    }

    public void setCepVenda(String cepVenda) {
        this.cepVenda = cepVenda;
    }

    public int getNumeroEnderecoVenda() {
        return numeroEnderecoVenda;
    }

    public void setNumeroEnderecoVenda(int numeroEnderecoVenda) {
        this.numeroEnderecoVenda = numeroEnderecoVenda;
    }

    public String getNomeStatusVenda() {
        return nomeStatusVenda;
    }

    public void setNomeStatusVenda(String nomeStatusVenda) {
        this.nomeStatusVenda = nomeStatusVenda;
    }

    public String getNomeFormaPagamentoVenda() {
        return nomeFormaPagamentoVenda;
    }

    public void setNomeFormaPagamentoVenda(String nomeFormaPagamentoVenda) {
        this.nomeFormaPagamentoVenda = nomeFormaPagamentoVenda;
    }

    public String getNumeroPagamentoVenda() {
        return numeroPagamentoVenda;
    }

    public void setNumeroPagamentoVenda(String numeroPagamentoVenda) {
        this.numeroPagamentoVenda = numeroPagamentoVenda;
    }

    public String getNomeProdutoVenda() {
        return nomeProdutoVenda;
    }

    public void setNomeProdutoVenda(String nomeProdutoVenda) {
        this.nomeProdutoVenda = nomeProdutoVenda;
    }

    public int getQuantidadeUnitariaVenda() {
        return quantidadeUnitariaVenda;
    }

    public void setQuantidadeUnitariaVenda(int quantidadeUnitariaVenda) {
        this.quantidadeUnitariaVenda = quantidadeUnitariaVenda;
    }

    public double getValorUnitarioProdutoVenda() {
        return valorUnitarioProdutoVenda;
    }

    public void setValorUnitarioProdutoVenda(double valorUnitarioProdutoVenda) {
        this.valorUnitarioProdutoVenda = valorUnitarioProdutoVenda;
    }

    @Override
    public String toString() {
        return "Venda{" + "idVenda=" + idVenda + ", codigoVenda=" + codigoVenda + ", quantidadeTotalVenda=" + quantidadeTotalVenda + ", valorFrete=" + valorFrete + ", valorTotalVenda=" + valorTotalVenda + ", dataVenda=" + dataVenda + ", idEndereco=" + idEndereco + ", idUsuario=" + idUsuario + ", idStatus=" + idStatus + ", idPagamento=" + idPagamento + ", idProduto=" + idProduto + ", valorUnitarioProduto=" + valorUnitarioProduto + ", quantidadeUnitarioProduto=" + quantidadeUnitarioProduto + ", valorTotalProduto=" + valorTotalProduto + ", logradouroVenda=" + logradouroVenda + ", cepVenda=" + cepVenda + ", numeroEnderecoVenda=" + numeroEnderecoVenda + ", nomeStatusVenda=" + nomeStatusVenda + ", nomeFormaPagamentoVenda=" + nomeFormaPagamentoVenda + ", numeroPagamentoVenda=" + numeroPagamentoVenda + ", nomeProdutoVenda=" + nomeProdutoVenda + ", quantidadeUnitariaVenda=" + quantidadeUnitariaVenda + ", valorUnitarioProdutoVenda=" + valorUnitarioProdutoVenda + '}';
    }
    
}
