package com.mycompany.lojainformatica.dao;

import com.mycompany.lojainformatica.models.Computador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ComputadorDAO {

    //conexão com o banco de dados:
    private static String url = "jdbc:mysql://localhost:3306/lojainformatica";
    private static String login = "admin";
    private static String senha = "Admin123";
   
 
    
    //SALVAR
    public static boolean salvar(Computador obj) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement comandoSQL = null;

        try {
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Passo 2 - Abrir a conexão com o banco
            conexao = DriverManager.getConnection(url, login, senha);

            //Passo 3 - Preparar o comando SQL
            comandoSQL
                    = conexao.prepareStatement("INSERT INTO Computadores (hd,processador) VALUES(?,?) ",
                            PreparedStatement.RETURN_GENERATED_KEYS);

            comandoSQL.setString(2, obj.getHd());
            comandoSQL.setString(1, obj.getProcessador());

            //Passo 4 - Executar o comando
            int linhasAfetadas = comandoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;

                ResultSet rs = comandoSQL.getGeneratedKeys();

                if (rs != null) {
                    while (rs.next()) {
                        int idGerado = rs.getInt(1);
                        obj.setId(rs.getInt(1));
                    }
                }
            }

        } catch (ClassNotFoundException ex) {
            System.err.println("Erro ao carregar o driver: " + ex.getMessage());
            retorno = false;
        } catch (SQLException ex) {
            System.err.println("Erro ao executar o comando SQL: " + ex.getMessage());
            retorno = false;

        } finally {

            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ComputadorDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        return retorno;

    }
    
    
     //BUSCAR
    public static ArrayList<Computador> buscar(){
        ArrayList<Computador> lista = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        ResultSet rs = null;
        
        try {
            
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - Abrir a conexão com o banco
            conexao = DriverManager.getConnection(url, login, senha);
            
            //Passo 3 - Preparar o comando SQL
            comandoSQL = conexao.prepareStatement("SELECT * FROM lojainformatica.computadores");
            
            //Passo 4 - Executar a CONSULTA
            rs = comandoSQL.executeQuery();
            
            if(rs != null){
            
                while(rs.next()){
                    
                    int id = rs.getInt("idComputador");
                    String hd = rs.getString("hd");
                    String processador = rs.getString("processador");
                    
                    Computador item = new Computador (id, hd, processador);
                    
                    
                    lista.add(item);
                    
                }
            
            }
            
        } catch (Exception e) {
            lista = null;
        }finally{
        
            if(conexao!=null){
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ComputadorDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
       return lista;
    }
     
    
    //EXCLUIR
    public static boolean excluir(int idExcluir){
        
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        
        try {
            //Receita de bolo para acessar o banco de dados
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - Abrir a conexão com o banco
            conexao = DriverManager.getConnection(url, login, senha);
            
            //Passo 3 - Preparar o comando SQL
            comandoSQL = 
            conexao.prepareStatement("DELETE FROM computadores WHERE idComputador = ?"  );
            
            comandoSQL.setInt(1, idExcluir);
            
            //Passo 4 - Executar o comando
            int linhasAfetadas = comandoSQL.executeUpdate();
            
            if(linhasAfetadas > 0){
                retorno = true;
            }
            
            
        } catch (ClassNotFoundException ex) {
            retorno = false;
        } catch (SQLException ex) {
            retorno = false;
        }
        
        
        return retorno;
    }
    
    
    // ATUALIZAR
    public static boolean atualizar(Computador obj){
        
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        
        try {
            //Receita de bolo para acessar o banco de dados
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - Abrir a conexão com o banco
            conexao = DriverManager.getConnection(url, login, senha);
            
            //Passo 3 - Preparar o comando SQL
            comandoSQL = 
            conexao.prepareStatement("UPDATE computadores SET processador = ?, hd = ? WHERE idComputador = ?");
            
            comandoSQL.setString(1, obj.getProcessador());
            comandoSQL.setString(2, obj.getHd());
            comandoSQL.setInt (3, obj.getId());
            
            //Passo 4 - Executar o comando
            int linhasAfetadas = comandoSQL.executeUpdate();
            
            if(linhasAfetadas > 0){
                retorno = true;
            }
            
            
        } catch (ClassNotFoundException ex) {
            retorno = false;
        } catch (SQLException ex) {
            retorno = false;
        }
        
        
        return retorno;
    }
    
    
    // LISTAR
    public static ArrayList<Computador> listar(){
        ArrayList<Computador> lista = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        ResultSet rs = null;
        
        try {
            
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - Abrir a conexão com o banco
            conexao = DriverManager.getConnection(url, login, senha);
            
            //Passo 3 - Preparar o comando SQL
            comandoSQL = conexao.prepareStatement("SELECT * FROM lojainformatica.computadores");
            
            //Passo 4 - Executar a CONSULTA
            rs = comandoSQL.executeQuery();
            
            if(rs != null){
            
                while(rs.next()){
                    
                    int id = rs.getInt("idComputador");
                    String hd = rs.getString("hd");
                    String processador = rs.getString("processador");
                    
                    Computador item = new Computador (id, hd, processador);
                    
                    
                    lista.add(item);
                    
                }
            
            }
            
        } catch (Exception e) {
            lista = null;
        }finally{
        
            if(conexao!=null){
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ComputadorDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
       return lista;
    }

}
