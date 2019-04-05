
package Model;

/**
 *
 * @author guilherme.rsvieira
 */
public class Serviço {
    
    private int codServ;
    private String nomeServ;
    private String dscServ;
    private String filial;

    public Serviço(int codServ, String nomeServ, String dscServ, String filial) {
        this.codServ = codServ;
        this.nomeServ = nomeServ;
        this.dscServ = dscServ;
        this.filial = filial;
    }
    
    
    public int getCodServ() {
        return codServ;
    }

    public void setCodServ(int codServ) {
        this.codServ = codServ;
    }

    public String getNomeServ() {
        return nomeServ;
    }

    public void setNomeServ(String nomeServ) {
        this.nomeServ = nomeServ;
    }

    public String getDscServ() {
        return dscServ;
    }

    public void setDscServ(String dscServ) {
        this.dscServ = dscServ;
    }

    public String getFilial() {
        return filial;
    }

    public void setFilial(String filial) {
        this.filial = filial;
    }
    
}
