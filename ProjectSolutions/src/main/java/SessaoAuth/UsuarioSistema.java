/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessaoAuth;

/**
 *
 * @author guilherme.psilva103
 */
import java.io.Serializable;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Yoshioka
 */
public class UsuarioSistema implements Serializable {

    private String email;

    private String nome;

    private String hashSenha;

    private List<Setor> setores;

    public UsuarioSistema() {
    }

    public UsuarioSistema(String email, String nome, String senhaAberta, List<Setor> setores) {
        this.email = email;
        this.nome = nome;
        setSenha(senhaAberta);
        this.setores = setores;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHashSenha() {
        return hashSenha;
    }

    public void setHashSenha(String senha) {
        this.hashSenha = senha;
    }

    public void setSenha(String senhaAberta) {
        this.hashSenha = BCrypt.hashpw(senhaAberta, BCrypt.gensalt());
    }

    public List<Setor> getSetores() {
        return setores;
    }

    public void setSetores(List<Setor> setores) {
        this.setores = setores;
    }

    public boolean validarSenha(String senhaAberta) {
        return BCrypt.checkpw(senhaAberta, hashSenha);
    }

    public boolean verificarSetor(String nomeSetor) {
        for (Setor p : setores) {
            if (p.getNome().equals(nomeSetor)) {
                return true;
            }
        }
        return false;
    }

}
