package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ComercioM;


public class ComercioDAO {
    PreparedStatement pst;
    String sql;
    

    static public void salvar (ComercioM comercio) throws SQLException{
        PreparedStatement pst;
        String sql;
        sql = "insert into Comercio values (?,?,?,?,?,?,?,?,?,?)";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setInt(1,0);
        pst.setString(2, comercio.getNome());
        pst.setString(3, comercio.getArea_atuante());
        pst.setString(4, comercio.getEndereco());
        pst.setString(5, comercio.getCidadeEstado());
        pst.setString(6, comercio.getTelComercial1());
        pst.setString(7, comercio.getTelComercial2());
        pst.setString(8, comercio.getCelular());
        pst.setString(9, comercio.getEmail());
        pst.setString(10, comercio.getObservacao());
  
        pst.execute();
        pst.close();
    }
    
    static public List<ComercioM> buscaFiltroNome(String Nome) throws SQLException{
        PreparedStatement pst;
        String sql;
        List<ComercioM> comercio = new ArrayList<ComercioM>();
        int cont = 0;
        SetorDAO setorDAO = new SetorDAO();
        
        String name = "%"+Nome+"%";
        
        sql = "select * from Comercio where nome like ? order by nome";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setString(1, name);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
           comercio.add(new ComercioM(
                   rs.getInt("id"),
                   rs.getString("nome"),
                   rs.getString("area_atuante"),
                   rs.getString("endereco"),
                   rs.getString("cidade_estado"),
                   rs.getString("tel_comercial1"),
                   rs.getString("tel_comercial2"),
                   rs.getString("celular"),
                   rs.getString("email"),
                   rs.getString("observacao")));
  
           cont ++;
        }
        if(cont == 0){
            return null;
        }
            
        pst.execute();
        pst.close();                           
        
        return comercio;
    }
    
    
    static public List<ComercioM> buscaFiltroSeguimento(String area) throws SQLException{
        PreparedStatement pst;
        String sql;
        List<ComercioM> comercio = new ArrayList<ComercioM>();
        int cont = 0;
        
        String set = "%"+area+"%";
        
        sql = "select * from Comercio where area_atuante like ?";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setString(1, set);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
           comercio.add(new ComercioM(
                   rs.getInt("id"),
                   rs.getString("nome"),
                   rs.getString("area_atuante"),
                   rs.getString("endereco"),
                   rs.getString("cidade_estado"),
                   rs.getString("tel_comercial1"),
                   rs.getString("tel_comercial2"),
                   rs.getString("celular"),
                   rs.getString("email"),
                   rs.getString("observacao")));
           cont ++;
        }
        if(cont == 0){
            return null;
        }
            
        pst.execute();
        pst.close();                           
        
        return comercio;
    }
    
    
    
    static public ComercioM busca(int id) throws SQLException{
        PreparedStatement pst;
        String sql;
        ComercioM comercio = null;
        
        sql = "select * from Funcionario where id = ?";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
         comercio = new ComercioM(
                   rs.getInt("id"),
                   rs.getString("nome"),
                   rs.getString("area_atuante"),
                   rs.getString("endereco"),
                   rs.getString("cidade_estado"),
                   rs.getString("tel_comercial1"),
                   rs.getString("tel_comercial2"),
                   rs.getString("celular"),
                   rs.getString("email"),
                   rs.getString("observacao"));
                   
        }
        pst.close();
        
        return comercio;
    }
    
    static public void excluir(ComercioM comercio) throws SQLException{
        PreparedStatement pst;
        String sql;
        sql = "delete from Comercio where id = ?";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, comercio.getId());
        pst.execute();
        pst.close();
    }
      
    static public void alterar(ComercioM comercio) throws SQLException{
        PreparedStatement pst;
        String sql;
        sql = "update Comercio set "
                 + "nome = ?, "
                 + "area_atuante  = ?, "
                 + "endereco = ?, "
                 + "cidade_estado = ?, "
                 + "tel_comercial1  = ?, "
                 + "tel_comercial2  = ?, "
                 + "celular  = ?, "
                 + "email  = ?, "
                 + "observacao  = ?, "
                
                 + "where id = ?";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setString(1, comercio.getNome());
        pst.setString(2, comercio.getCelular());
        pst.setString(3, comercio.getEndereco());
        pst.setString(4, comercio.getCidadeEstado());
        pst.setString(5, comercio.getTelComercial1());
        pst.setString(6, comercio.getTelComercial2());
        pst.setString(7, comercio.getCelular());
        pst.setString(8, comercio.getEmail());;
        pst.setString(9, comercio.getObservacao());
        pst.setInt(10,comercio.getId());
        
         pst.execute();
         pst.close();
     }
    

    
    public List<ComercioM> listaComercio() throws SQLException{     
    List<ComercioM> listacomercio = new ArrayList<>();
    
    sql = "select * from Comercio order by nome";
    pst = Conexao.getInstance().prepareStatement(sql);
    ResultSet rs = pst.executeQuery();
    
    while(rs.next()){
           listacomercio.add(new ComercioM(
                   rs.getInt("id"),
                   rs.getString("nome"),
                   rs.getString("area_atuante"),
                   rs.getString("endereco"),
                   rs.getString("cidade_estado"),
                   rs.getString("tel_comercial1"),
                   rs.getString("tel_comercial2"),
                   rs.getString("celular"),
                   rs.getString("email"),
                   rs.getString("observacao")));
        }
    pst.close();
    return listacomercio;
    }
}
