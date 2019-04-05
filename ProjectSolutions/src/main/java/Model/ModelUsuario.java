package Model;

/**
 *
 * @author guilherme.rsvieira
 */
 public class ModelUsuario {

    private int codUser;
    private String nome;
    private String email;
    private String senha;
    private String filial;
    private String setor;

    public ModelUsuario(int codUser, String nome, String email, String senha, String filial, String setor) {
        this.codUser = codUser;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.filial = filial;
        this.setor = setor;
    }
     
    
    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
    
    public String getFilial() {
        return filial;
    }

    public void setFilial(String filial) {
        this.filial = filial;
    }

    public int getCodUser() {
        return codUser;
    }

    public void setCodUser(int codUser) {
        this.codUser = codUser;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
   
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    

   
    

}
