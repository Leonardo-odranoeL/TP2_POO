//Aluno: Leonardo Araújo da Silva
//RA: R4097G-0
//turma: CC4P41
package com.mycompany.TP1_PPOO;
import java.sql.*;

public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/bd_tp2_POO";
    private static final String User = "root";
    private static final String Senha = "Leo@3108";
    
    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL, User, Senha);
        }
        catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar! ", e);
        }
    }   
}