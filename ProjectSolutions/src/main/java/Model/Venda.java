package Model;

/**
 *
 * @author guilherme.rsvieira
 */
public class Venda {

    private int codigo;
    private String nomeProduto;
    private int codigoProduto;
    private int quantidadeVenda;
    private int idFuncionario;
    private int codigoFilial;
    private int cpfCliente;

    public Venda(String nomeProduto, int codigoProduto, int quantidadeVenda, int idFuncionario, int codigoFilial, int cpfCliente) {
        this.nomeProduto = nomeProduto;
        this.codigoProduto = codigoProduto;
        this.quantidadeVenda = quantidadeVenda;
        this.idFuncionario = idFuncionario;
        this.codigoFilial = codigoFilial;
        this.cpfCliente = cpfCliente;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public int getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(int cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    
}
