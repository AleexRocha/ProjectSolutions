/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author guilherme.pereira
 */
public class Pagamento {
    int id;
    String tipoPagamento;
    String numeroPAgamento;
    String nomeTitular;
    String dataVencimento;
    String codigoSegurança;

    public Pagamento(){}
    
    public Pagamento(int id, String tipoPagamento) {
        this.id = id;
        this.tipoPagamento = tipoPagamento;
    }
    
    public Pagamento(int id, String tipoPagamento, String numeroPAgamento, String nomeTitular, String dataVencimento, String codigoSegurança) {
        this.id = id;
        this.tipoPagamento = tipoPagamento;
        this.numeroPAgamento = numeroPAgamento;
        this.nomeTitular = nomeTitular;
        this.dataVencimento = dataVencimento;
        this.codigoSegurança = codigoSegurança;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public String getNumeroPAgamento() {
        return numeroPAgamento;
    }

    public void setNumeroPAgamento(String numeroPAgamento) {
        this.numeroPAgamento = numeroPAgamento;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getCodigoSegurança() {
        return codigoSegurança;
    }

    public void setCodigoSegurança(String codigoSegurança) {
        this.codigoSegurança = codigoSegurança;
    }
}
