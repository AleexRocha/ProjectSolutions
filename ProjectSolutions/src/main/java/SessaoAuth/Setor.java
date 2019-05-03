/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessaoAuth;

import java.io.Serializable;

/**
 *
 * @author Yoshioka
 */
public class Setor implements Serializable {

    private String nome;

    public Setor() {
    }

    public Setor(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
