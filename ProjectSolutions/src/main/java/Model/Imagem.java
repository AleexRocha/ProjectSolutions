package Model;

/**
 *
 * @author Alexsander Rocha
 */
public class Imagem {

    private int idImagem;
    private String nome;
    private String caminho;
    private int fkProduto;

    public Imagem() {
    }

    public Imagem(String nome, String caminho) {
        this.nome = nome;
        this.caminho = caminho;
    }

    public Imagem(int idImagem, int fkProduto) {
        this.idImagem = idImagem;
        this.fkProduto = fkProduto;
    }

    public Imagem(int idImagem, String nome, String caminho, int fkProduto) {
        this.idImagem = idImagem;
        this.nome = nome;
        this.caminho = caminho;
        this.fkProduto = fkProduto;
    }

    public int getIdImagem() {
        return idImagem;
    }

    public void setIdImagem(int idImagem) {
        this.idImagem = idImagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public int getFkProduto() {
        return fkProduto;
    }

    public void setFkProduto(int fkProduto) {
        this.fkProduto = fkProduto;
    }

}
