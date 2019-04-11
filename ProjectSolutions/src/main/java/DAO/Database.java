/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author guilherme.pereira
 */
public class Database {

    private final String driver;
    private final String usuario;
    private final String senha;
    private final String nomeDB;
    private final String url;
    private Connection conexao;

    public Database() {
        driver = "com.mysql.jdbc.Driver";
        usuario = "root";
        senha = "";
        nomeDB = "TADES_BCD";
        url = "jdbc:mysql://localhost:3306/" + nomeDB;
    }

    public String getDriver() {
        return driver;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public String getNomeDB() {
        return nomeDB;
    }

    public String getUrl() {
        return url;
    }

    public Connection getConexao() {
        return conexao;
    }    

    public Connection obterConexao() {
        try {
            Class.forName(getDriver());
            conexao = DriverManager.getConnection(
                    getUrl(),
                    getUsuario(),
                    getSenha()
            );
        } catch (ClassNotFoundException | SQLException e) {
        }

        return conexao;
    }

}