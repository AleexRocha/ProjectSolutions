package Model;

/**
 *
 * @author guilherme.rsvieira
 */
public class Produto {

    private int codigo;
    private String nome;
    private String descricao;
    private String tipo;
    private int quantidadeEstoque;
    private double valorUnitario;
    private String nomeImagem;
    private String valorCarrinho;
    private String valorTotal;
    private int idCarrinho; 
    
    public Produto() {
    }
    
    public Produto(int codigo, int quantidadeEstoque) {
        this.codigo = codigo;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Produto(String nome, String tipo, int quantidadeEstoque, double valorUnitario) {
        this.nome = nome;
        this.quantidadeEstoque = quantidadeEstoque;
        this.valorUnitario = valorUnitario;
        this.tipo = tipo;
    }

    public Produto(String nome, String descricao, String tipo, int quantidadeEstoque, double valorUnitario) {
        this.nome = nome;
        this.descricao = descricao;
        this.quantidadeEstoque = quantidadeEstoque;
        this.valorUnitario = valorUnitario;
        this.tipo = tipo;
    }

    public Produto(int codigo, String nome, String descricao, String tipo, int quantidadeEstoque, double valorUnitario) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.quantidadeEstoque = quantidadeEstoque;
        this.valorUnitario = valorUnitario;
        this.tipo = tipo;
    }

    public Produto(int codigo, String nome, String descricao, String tipo, int quantidadeEstoque, double valorUnitario, String nomeImagem) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.quantidadeEstoque = quantidadeEstoque;
        this.valorUnitario = valorUnitario;
        this.tipo = tipo;
        this.nomeImagem = nomeImagem;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNomeImagem() {
        return nomeImagem;
    }

    public void setNomeImagem(String nomeImagem) {
        this.nomeImagem = nomeImagem;
    }

    public String getValorCarrinho() {
        return valorCarrinho;
    }

    public void setValorCarrinho(String valorCarrinho) {
        this.valorCarrinho = valorCarrinho;
    }

    public String getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(String valotTotal) {
        this.valorTotal = valotTotal;
    }

    public int getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(int idCarrinho) {
        this.idCarrinho = idCarrinho;
    }
}
