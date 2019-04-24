package Model;

/**
 *
 * @author guilherme.rsvieira
 */
public class Venda {

    private int codigoProduto;
    private int idFuncionario;
    private int codigoFilial;
    private int quantidadeVenda;
    private String cpfCliente;

    public Venda(int codigoProduto, int idFuncionario, int codigoFilial, int quantidadeVenda) {
        this.codigoProduto = codigoProduto;
        this.idFuncionario = idFuncionario;
        this.codigoFilial = codigoFilial;
        this.quantidadeVenda = quantidadeVenda;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
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

    public int getCodigoFilial() {
        return codigoFilial;
    }

    public void setCodigoFilial(int codigoFilial) {
        this.codigoFilial = codigoFilial;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

}
