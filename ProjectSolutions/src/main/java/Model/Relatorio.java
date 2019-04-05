package Model;

/**
 *
 * @author guilherme.rsvieira
 */
public class Relatorio {

    private String dataVenda;
    private String filial;

    public Relatorio(String dataVenda, String filial) {
        this.dataVenda = dataVenda;
        this.filial = filial;
    }

    
    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getFilial() {
        return filial;
    }

    public void setFilial(String filial) {
        this.filial = filial;
    }
    
}
