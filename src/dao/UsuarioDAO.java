/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.UsuarioM;

/**
 *
 * @author Leopo
 */
public class UsuarioDAO {
        
    public UsuarioM valida(String user, String senha) throws SQLException{
        PreparedStatement pst;
        String sql;
           sql = "select * from Usuario where usuario = ? and senha = ?";
           pst = Conexao.getInstance().prepareStatement(sql);
           pst.setString(1, user);
           pst.setString(2, senha);
           UsuarioM usuario;
           usuario = null;
           ResultSet rs = pst.executeQuery();
           while(rs.next()){
               usuario = new UsuarioM(rs.getInt("id"),
                       rs.getString("nome"), 
                       rs.getString("contato"),
                       rs.getString("usuario"),
                       rs.getString("senha"),
                       rs.getBoolean("adm")
               );
            }
            pst.close();
            return usuario;
    }
    
    public UsuarioM validaAdmin(String user, String senha) throws SQLException{
        PreparedStatement pst;
        String sql;
        int aux = 0;
           sql = "select * from Usuario where usuario = ? and senha = ? and adm = ?";
           pst = Conexao.getInstance().prepareStatement(sql);
           pst.setString(1, user);
           pst.setString(2, senha);
           pst.setBoolean(3, true);
           UsuarioM usuario;
           usuario = null;
           ResultSet rs = pst.executeQuery();
           while(rs.next()){
               usuario = new UsuarioM(rs.getInt("id"),
                       rs.getString("nome"), 
                       rs.getString("contato"),
                       rs.getString("usuario"),
                       rs.getString("senha"),
                       rs.getBoolean("adm")
               );
               aux++;
            }
            pst.close();
            
            if(aux == 0){
                return null;
            }else{
                return usuario;
            }
    }
    
    public List<UsuarioM> listaTodos() throws SQLException{
        PreparedStatement pst;
        String sql;
        List<UsuarioM> listaUser = new ArrayList<UsuarioM>();
        sql = "select * from Usuario";
        pst = Conexao.getInstance().prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
           listaUser.add(new UsuarioM(rs.getInt("id"),
                       rs.getString("nome"), 
                       rs.getString("contato"),
                       rs.getString("usuario")
                    )
                );
        }
        pst.close();
        return listaUser;
    }
    
    public void salvar(UsuarioM usuario) throws SQLException{
        PreparedStatement pst;
        String sql;
        sql = "insert into Usuario values(?,?,?,?,?,?)";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, 0);
        pst.setString(2, usuario.getNome());
        pst.setString(3, usuario.getContato());
        pst.setString(4, usuario.getUsuario());
        pst.setString(5,usuario.getSenha());
        pst.setBoolean(6, usuario.isAdmin());
        pst.execute();
        pst.close();
    }   
    
    public void excluir(UsuarioM usuario) throws SQLException{
        PreparedStatement pst;
        String sql;
        sql = "delete from Usuario where id = ?";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, usuario.getId());
        pst.execute();
        pst.close();
    }
    
    public void alterar(UsuarioM usuario) throws SQLException{
         PreparedStatement pst;
         String sql;
         sql = "update usuario set nome = ?, contato = ?, usuario = ?, senha = ? where id = ?";
         pst = Conexao.getInstance().prepareStatement(sql);
        
        pst.setString(1, usuario.getNome());
        pst.setString(2, usuario.getContato());
        pst.setString(3, usuario.getUsuario());
        pst.setString(4, usuario.getSenha());
        pst.setInt(5, usuario.getId());
        pst.execute();
        pst.close();
    } 
    
    public UsuarioM BuscaPorId(int id) throws SQLException {
        PreparedStatement pst;
        String sql;
        UsuarioM usuario = null;
        sql = "Select * from usuario where id=?";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, id);
        pst.executeQuery();
        ResultSet rs = pst.getResultSet();
        while(rs.next()){
               usuario = new UsuarioM(rs.getInt("id"),
                       rs.getString("nome"), 
                       rs.getString("contato"),
                       rs.getString("usuario"), 
                       rs.getString("senha"),
                       rs.getBoolean("adm")
               );
        }
        pst.close();
        return usuario;
    }
}
