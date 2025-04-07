/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.etapa3_pi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author zanat
 */
public class conexao {

    private Connection conn; // Criando um objeto do tipo Connection chamado conn

    public boolean conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Carregar o driver do MySQL
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_pi", "root", "150208");
            System.out.println("Conexão realizada com sucesso");
            return true;
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver do banco de dados não encontrado: " + ex.getMessage());
            return false;
        } catch (SQLException ex) {
            System.out.println("Falha na conexão com o banco de dados: " + ex.getMessage());
            return false;
        }
    }

    public void desconectar() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Conexão encerrada com sucesso");
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao fechar a conexão: " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return conn;
    }
}