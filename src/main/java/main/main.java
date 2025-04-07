/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import com.senac.etapa3_pi.conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zanat
 */
public class main {
     public static void main(String[] args) {
        conexao conector = new conexao(); // Criar instância da classe Conexao
        
        if (conector.conectar()) { // Verificar se a conexão foi bem-sucedida
            Connection conn = conector.getConnection(); // Obter a conexão
            
            try (Statement st = conn.createStatement(); 
                 ResultSet rs = st.executeQuery("SELECT COUNT(*) AS total FROM filmes")) { 
                
                if (rs.next()) {
                    System.out.println("Número de usuários cadastrados: " + rs.getInt("total"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, "Erro ao executar a consulta", ex);
            } finally {
                conector.desconectar(); // Fechar a conexão corretamente
            }
        } else {
            System.out.println("Não foi possível conectar ao banco de dados.");
        }
    }
}


