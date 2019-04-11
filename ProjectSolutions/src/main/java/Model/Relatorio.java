package Model;

/**
 *
 * @author guilherme.rsvieira
 */
public class Relatorio {

    private int codigoVenda;
    private int codigoProduto;
    private String nomeProduto;
    private int quantidadeProduto;
    private double valor;
    private int idFilial;
    private String nomeFilial;
    private int idFuncionario;
    private String dataVenda;

    public Relatorio() {
    }

    public Relatorio(int codigoVenda, int codigoProduto, String nomeProduto, int quantidadeProduto, double valor, int idFilial, String nomeFilial, int idFuncionario, String dataVenda) {
        this.codigoVenda = codigoVenda;
        this.codigoProduto = codigoProduto;
        this.nomeProduto = nomeProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.valor = valor;
        this.idFilial = idFilial;
        this.nomeFilial = nomeFilial;
        this.idFuncionario = idFuncionario;
        this.dataVenda = dataVenda;
    }

    public int getCodigoVenda() {
        return codigoVenda;
    }

    public void setCodigoVenda(int codigoVenda) {
        this.codigoVenda = codigoVenda;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getIdFilial() {
        return idFilial;
    }

    public void setIdFilial(int idFilial) {
        this.idFilial = idFilial;
    }

    public String getNomeFilial() {
        return nomeFilial;
    }

    public void setNomeFilial(String nomeFilial) {
        this.nomeFilial = nomeFilial;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

}
