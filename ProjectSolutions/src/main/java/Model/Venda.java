package Model;

/**
 *
 * @author guilherme.rsvieira
 */
public class Venda {

    private int[] ProdutoArray;
    private int[] qtdProdutoArray;
    private int codigoProduto;
    private String nomeProduto;
    private double valorUnidade;
    private int idFuncionario;
    private String nomeFuncionario;
    private int quantidadeVenda;
    private String cpfCliente;

    public Venda(){
    }
    
    public Venda(int codigoProduto, int idFuncionario) {
        this.codigoProduto = codigoProduto;
        this.idFuncionario = idFuncionario;
    }
    
    public Venda(int[] ProdutoArray, int idFuncionario, int[] qtdProdutoArray) {
        this.ProdutoArray = ProdutoArray;
        this.idFuncionario = idFuncionario;
        this.qtdProdutoArray = qtdProdutoArray;
    }

    public int getProdutoArrayPosition(int position) {
        return ProdutoArray[position];
    }
    
    public int getProdutoQtdArrayPosition(int position) {
        return qtdProdutoArray[position];
    }
    
    public int[] getProdutoArray() {
        return ProdutoArray;
    }

    public void setProdutoArray(int[] codigoProdutoArray) {
        this.ProdutoArray = codigoProdutoArray;
    }

    public int getQuantidadeVenda() {
        return quantidadeVenda;
    }

    public void setQuantidadeVenda(int quantidadeVenda) {
        this.quantidadeVenda = quantidadeVenda;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public double getValorUnidade() {
        return valorUnidade;
    }

    public void setValorUnidade(double valorUnidade) {
        this.valorUnidade = valorUnidade;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }
}
