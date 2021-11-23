/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexh_000
 */
public class CursoDAO {
    
    private Connection conn;
    
    public CursoDAO(){
        
         this.conn = Conex.getConnection();
    }
    
    public void inserir(Curso curso){
        
        String msg = "";
        try {
            String nom = curso.getNome();
            String des = curso.getDescricao();
            String resumo = curso.getResumo();
            Float val = curso.getValor();

            String sql = "insert into curso (nome, descricao, resumo, valor) "
                                + " values "
                                + "(?, ?, ?, ?)";
            
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, nom);
            stmt.setString(2, des);
            stmt.setString(3, resumo);
            stmt.setFloat(4, val);
            
            int res = stmt.executeUpdate();
            if (res > 0) {
                msg = "ok";
            } else {
                msg = "bug";
            }

            //fechar os objetos de manipulação do SGBD
            stmt.close();
            this.conn.close();
                
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void atualizar(Curso curso){
    
        String msg = "";
        try {
            Long id = curso.getCodigo();
            String nom = curso.getNome();
            String des = curso.getDescricao();
            String resumo = curso.getResumo();
            Float val = curso.getValor();

            String sql = "update curso set nome = ?, descricao = ?, resumo = ?, valor = ? where codigo = ?";
            
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, nom);
            stmt.setString(2, des);
            stmt.setString(3, resumo);
            stmt.setFloat(4, val);
            stmt.setLong(5, id);
            
            int res = stmt.executeUpdate();
            if (res > 0) {
                msg = "ok";
            } else {
                msg = "bug";
            }

            //fechar os objetos de manipulação do SGBD
            stmt.close();
            this.conn.close();
                
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    public void excluir(Curso curso){
    
        String msg = "";
        try {
            Long id = curso.getCodigo();
            
            String sql = "delete from curso where codigo=?";
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setLong(1, id);
            
            int res = stmt.executeUpdate();
            if (res > 0) {
                msg = "ok";
            } else {
                msg = "bug";
            }

            //fechar os objetos de manipulação do SGBD
            stmt.close();
            this.conn.close();
                
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    public List<Curso> listar(){
        
        ArrayList<Curso> lstCurso = new ArrayList<Curso>();
        
        try {
            String sql = "select * from curso";
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet res = stmt.executeQuery();
            
            while (res.next()){
                Curso cur = new Curso();
                cur.setCodigo(res.getLong("codigo"));
                cur.setNome(res.getString("nome"));
                cur.setResumo(res.getString("resumo"));
                cur.setDescricao(res.getString("descricao"));
                cur.setValor(res.getFloat("valor"));
                
                lstCurso.add(cur);
                
            }
            stmt.close();
            this.conn.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        
        
        return lstCurso;
    }
    
    public Curso buscar(String id){
        
        Curso curso = new Curso();
        try {
            String sql = "select * from curso where codigo = "+ id;
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            //stmt.setLong(1, Long.parseLong(id));
            ResultSet res = stmt.executeQuery();
            
            while (res.next()){
                
                curso.setCodigo(res.getLong("codigo"));
                curso.setNome(res.getString("nome"));
                curso.setResumo(res.getString("resumo"));
                curso.setDescricao(res.getString("descricao"));
                curso.setValor(res.getFloat("valor"));
                
            }
            
            res.close();
            stmt.close();
            this.conn.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        
        
        return curso;
    }
}
