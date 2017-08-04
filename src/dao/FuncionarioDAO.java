package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.FuncionarioM;

public class FuncionarioDAO {

    
    
    PreparedStatement pst;
    String sql;
    
    public static List<FuncionarioM> buscaConvidado(String Nome, String Ramal, String Setor) throws SQLException
    {
        SetorDAO setorDAO = new SetorDAO();
        Conexao c;
	PreparedStatement ps;
	ResultSet rs;
        int cont = 0;
        
        if (Setor.equals("Todos"))
            Setor = "";
        String setor = "%"+Setor+"%";

        boolean whereAdd = false;
        StringBuffer sb = new StringBuffer("select * from Funcionario f inner join Setor s on f.id_setor = s.id");
        
        //concatenar nome se preenchido.
        if (Nome.length() > 0){
            if (whereAdd == false){
                sb.append(" WHERE ");
                whereAdd = true;
                sb.append("f.nome like ");
                sb.append("'%" + Nome + "%'");
            }
        }
        //concatenar ramal se preenchido.
        if (Ramal.length() > 0){
            if (whereAdd == false){
                sb.append(" WHERE ");
                whereAdd = true;
            }
            else
                sb.append(" AND ");
            sb.append("f.ramal like ");
            sb.append("'%" + Ramal + "%'");
        }   
        //concatenar setor se preenchido/alterado de todos
        if (Setor.length() > 0){
            if (whereAdd == false){
                sb.append(" WHERE ");
                whereAdd = true;
            }
            else
                sb.append(" AND ");
            sb.append("s.nome like ");
            sb.append("'%" + Setor + "%'");
        }   
                
        ps = Conexao.getInstance().prepareStatement(sb.toString());
        
        rs = ps.executeQuery(sb.toString());
        List<FuncionarioM> funcionarios = new ArrayList<>();
        while(rs.next()){
            FuncionarioM funcionario = new FuncionarioM();
                   funcionario.setId(rs.getInt("id"));
                   funcionario.setNome(rs.getString("nome"));
                   funcionario.setEndereco(rs.getString("endereco"));
                   funcionario.setCidadeestado(rs.getString("cidade_estado"));
                   funcionario.setTelresidencial(rs.getString("tel_residencial"));
                   funcionario.setTelcomercial1(rs.getString("tel_comercial1"));
                   funcionario.setTelcomercial2(rs.getString("tel_comercial2"));
                   funcionario.setCelular1(rs.getString("celular1"));
                   funcionario.setCelular2(rs.getString("celular2"));
                   funcionario.setCelular3(rs.getString("celular3"));
                   funcionario.setEmail(rs.getString("email"));
                   funcionario.setDia(rs.getString("dia"));
                   funcionario.setHorario(rs.getString("horario"));
                   funcionario.setObservacao(rs.getString("observacao"));
                   funcionario.setSetor(SetorDAO.busca(rs.getInt("id_setor")));
                   funcionario.setRamal(rs.getString("ramal"));
                   funcionario.setDocente(rs.getBoolean("docente"));
                   funcionario.setInativo(rs.getBoolean("inativo"));
           funcionarios.add(funcionario);
           cont++;          
        }
        
        if(cont == 0){
            return null;
        }
            
        ps.execute();
        
        ps.close();
        rs.close();
        
        return funcionarios;
    }
    
    static public void salvar (FuncionarioM funcionario) throws SQLException{
        PreparedStatement pst;
        String sql;
        sql = "insert into Funcionario values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setInt(1,0);
        pst.setString(2, funcionario.getNome());
        pst.setString(3, funcionario.getEndereco());
        pst.setString(4, funcionario.getCidadeestado());
        pst.setString(5, funcionario.getTelresidencial()); 
        pst.setString(6, funcionario.getTelcomercial1());
        pst.setString(7, funcionario.getTelcomercial2());
        pst.setString(8, funcionario.getCelular1());
        pst.setString(9, funcionario.getCelular2());
        pst.setString(10, funcionario.getCelular3());
        pst.setString(11, funcionario.getEmail());
        pst.setString(12, funcionario.getDia());
        pst.setString(13, funcionario.getHorario());
        pst.setString(14, funcionario.getObservacao());
        pst.setInt(15, funcionario.getSetor().getId());
        pst.setString(16, funcionario.getRamal());
        pst.setBoolean(17, funcionario.getDocente());
        pst.setBoolean(18, funcionario.getInativo());
         
        pst.execute();
        pst.close();
    }
    
    static public List<FuncionarioM> buscaFiltroNome(String Nome) throws SQLException{
        PreparedStatement pst;
        String sql;
        List<FuncionarioM> funcionario = new ArrayList<FuncionarioM>();
        int cont = 0;
        SetorDAO setorDAO = new SetorDAO();
        
        String name = "%"+Nome+"%";
        
        sql = "select * from Funcionario where nome like ? order by nome";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setString(1, name);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
           funcionario.add(new FuncionarioM(
                   rs.getInt("id"),
                   rs.getString("nome"),
                   rs.getString("endereco"),
                   rs.getString("cidade_estado"),
                   rs.getString("tel_residencial"),
                   rs.getString("tel_comercial1"),
                   rs.getString("tel_comercial2"),
                   rs.getString("celular1"),
                   rs.getString("celular2"),
                   rs.getString("celular3"),
                   rs.getString("email"),
                   rs.getString("dia"),
                   rs.getString("horario"),
                   rs.getString("observacao"),
                   setorDAO.busca(rs.getInt("id_setor")),
                   rs.getString("ramal"),
                   rs.getBoolean("docente"),
                   rs.getBoolean("inativo")));  
           cont ++;
        }
        if(cont == 0){
            return null;
        }
            
        pst.execute();
        pst.close();                           
        
        return funcionario;
    }
    
    
    static public List<FuncionarioM> buscaFiltroSetor(String Setor) throws SQLException{
        PreparedStatement pst;
        String sql;
        List<FuncionarioM> funcionario = new ArrayList<FuncionarioM>();
        int cont = 0;
        SetorDAO setorDAO = new SetorDAO();
        
        String set = "%"+Setor+"%";
        
        sql = "select * from Funcionario f inner join Setor s on f.id_setor = s.id where s.nome like ?";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setString(1, set);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
           funcionario.add(new FuncionarioM(
                   rs.getInt("id"),
                   rs.getString("nome"),
                   rs.getString("endereco"),
                   rs.getString("cidade_estado"),
                   rs.getString("tel_residencial"),
                   rs.getString("tel_comercial1"),
                   rs.getString("tel_comercial2"),
                   rs.getString("celular1"),
                   rs.getString("celular2"),
                   rs.getString("celular3"),
                   rs.getString("email"),
                   rs.getString("dia"),
                   rs.getString("horario"),
                   rs.getString("observacao"),
                   setorDAO.busca(rs.getInt("id_setor")),
                   rs.getString("ramal"),
                   rs.getBoolean("docente"),
                   rs.getBoolean("inativo")));  
           cont ++;
        }
        if(cont == 0){
            return null;
        }
            
        pst.execute();
        pst.close();                           
        
        return funcionario;
    }
    
    static public List<FuncionarioM> buscaFiltroInativo(String Inativo) throws SQLException{
        PreparedStatement pst;
        String sql;
        List<FuncionarioM> funcionario = new ArrayList<FuncionarioM>();
        int cont = 0;
        SetorDAO setorDAO = new SetorDAO();
        
        String inat = "%"+Inativo+"%";
        
        sql = "select * from Funcionario where nome like ? and inativo = 1 order by nome";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setString(1, inat);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
           funcionario.add(new FuncionarioM(
                   rs.getInt("id"),
                   rs.getString("nome"),
                   rs.getString("endereco"),
                   rs.getString("cidade_estado"),
                   rs.getString("tel_residencial"),
                   rs.getString("tel_comercial1"),
                   rs.getString("tel_comercial2"),
                   rs.getString("celular1"),
                   rs.getString("celular2"),
                   rs.getString("celular3"),
                   rs.getString("email"),
                   rs.getString("dia"),
                   rs.getString("horario"),
                   rs.getString("observacao"),
                   setorDAO.busca(rs.getInt("id_setor")),
                   rs.getString("ramal"),
                   rs.getBoolean("docente"),
                   rs.getBoolean("inativo")));  
        }
        if(cont == 0){
            return null;
        }
            
        pst.execute();
        pst.close();                           
        
        return funcionario;
    }
                               
    static public List<FuncionarioM> buscaNome(String Nome, String Ramal, String Setor, boolean Docente, boolean Inativo) throws SQLException{
        SetorDAO setorDAO = new SetorDAO();
        Conexao c;
	PreparedStatement ps;
	ResultSet rs;
        int cont = 0;
        
        //Para pesquisar no banco de dados todos os setores.
        if (Setor.equals("Todos"))
            Setor = "";
        String setor = "%"+Setor+"%";

        boolean whereAdd = false;
        StringBuffer sb = new StringBuffer("select * from Funcionario f inner join Setor s on f.id_setor = s.id");
        
        //concatenar nome se preenchido.
        if (Nome.length() > 0){
            if (whereAdd == false){
                sb.append(" WHERE ");
                whereAdd = true;
                sb.append("f.nome like ");
                sb.append("'%" + Nome + "%'");
            }
        }
        //concatenar ramal se preenchido.
        if (Ramal.length() > 0){
            if (whereAdd == false){
                sb.append(" WHERE ");
                whereAdd = true;
            }
            else
                sb.append(" AND ");
            sb.append("f.ramal like ");
            sb.append("'%" + Ramal + "%'");
        }   
        //concatenar setor se preenchido/alterado de todos
        if (Setor.length() > 0){
            if (whereAdd == false){
                sb.append(" WHERE ");
                whereAdd = true;
            }
            else
                sb.append(" AND ");
            sb.append("s.nome like ");
            sb.append("'%" + Setor + "%'");
        }   
        //concatenar se vai mostrar docente.
        if (Docente == true){
            if (whereAdd = false){
                sb.append(" WHERE ");
                whereAdd = true;
            }
            else
                sb.append(" AND ");
            sb.append("f.docente = ");
            sb.append(Docente);
        }   
        //concatenar se vai mostrar inativos.
        if (Inativo == true){
            if (whereAdd = false){
                sb.append(" WHERE ");
                whereAdd = true;
            }
            else
                sb.append(" AND ");
            sb.append("f.inativo = ");
            sb.append(Inativo);
        }   
        
        ps = Conexao.getInstance().prepareStatement(sb.toString());
        
        rs = ps.executeQuery(sb.toString());
        List<FuncionarioM> funcionarios = new ArrayList<>();
        while(rs.next()){
            FuncionarioM funcionario = new FuncionarioM();
                   funcionario.setId(rs.getInt("id"));
                   funcionario.setNome(rs.getString("nome"));
                   funcionario.setEndereco(rs.getString("endereco"));
                   funcionario.setCidadeestado(rs.getString("cidade_estado"));
                   funcionario.setTelresidencial(rs.getString("tel_residencial"));
                   funcionario.setTelcomercial1(rs.getString("tel_comercial1"));
                   funcionario.setTelcomercial2(rs.getString("tel_comercial2"));
                   funcionario.setCelular1(rs.getString("celular1"));
                   funcionario.setCelular2(rs.getString("celular2"));
                   funcionario.setCelular3(rs.getString("celular3"));
                   funcionario.setEmail(rs.getString("email"));
                   funcionario.setDia(rs.getString("dia"));
                   funcionario.setHorario(rs.getString("horario"));
                   funcionario.setObservacao(rs.getString("observacao"));
                   funcionario.setSetor(SetorDAO.busca(rs.getInt("id_setor")));
                   funcionario.setRamal(rs.getString("Ramal"));
                   funcionario.setDocente(rs.getBoolean("docente"));
                   funcionario.setInativo(rs.getBoolean("inativo"));
           funcionarios.add(funcionario);
           cont++;
        }
        
        if(cont == 0){
            return null;
        }
            
        ps.execute();
        
        ps.close();
        rs.close();
        
        return funcionarios;
    }
    
    static public List<FuncionarioM> relatorioFuncionario(String tipos, String order, String filtro) throws SQLException{
        Conexao c;
	PreparedStatement ps;
	ResultSet rs;
    
        //verifica o FILTRO TODOS/DOCENTE/INATIVO/NAODOCENTES
        boolean docente = false;
        boolean inativo = false;
        boolean naodocente = false;

        if (filtro.equals("Docentes")){
            docente = true;
        }else if (filtro.equals("Inativos")){
            inativo = true;
        }else if (filtro.equals("Naodocente")){
            naodocente = true;
        }
        
        boolean whereAdd = false;
        StringBuffer sb = new StringBuffer("select * from funcionario f inner join setor s on f.id_setor = s.id");
        
        //Relatorio por Funcionarios.
        if (tipos.equals("Funcionarios")){
            if (docente == true){
                if (whereAdd == false)
                    sb.append (" WHERE ");
                
                sb.append("f.docente = ");
                sb.append(docente);
            }
            if (inativo == true){
                if (whereAdd == false)
                    sb.append (" WHERE ");
                
                sb.append("f.inativo = ");
                sb.append(inativo);
            }
            if (naodocente == true){
                if (whereAdd == false)
                    sb.append (" WHERE ");
                
                sb.append("f.docente = ");
                sb.append(false);
            }
            
            //verificação em qual dos dois tipos os funcionarios vão ser ordenados
            if (tipos.equals("Funcionarios") && order == "Nome"){
                sb.append(" order by f.nome ");
            }
            //irá order os nomes por setores.
            if (tipos.equals("Funcionarios") && order == "Setor"){
                sb.append(" order by s.nome, f.nome");
            }
        }
        
        List<FuncionarioM> funcionarios = new ArrayList<>();
        ps = Conexao.getInstance().prepareStatement(sb.toString());
        
        rs = ps.executeQuery(sb.toString());
        
        while(rs.next()){
            FuncionarioM funcionario = new FuncionarioM();
                   funcionario.setId(rs.getInt("id"));
                   funcionario.setNome(rs.getString("nome"));
                   funcionario.setEndereco(rs.getString("endereco"));
                   funcionario.setCidadeestado(rs.getString("cidade_estado"));
                   funcionario.setTelresidencial(rs.getString("tel_residencial"));
                   funcionario.setTelcomercial1(rs.getString("tel_comercial1"));
                   funcionario.setTelcomercial2(rs.getString("tel_comercial2"));
                   funcionario.setCelular1(rs.getString("celular1"));
                   funcionario.setCelular2(rs.getString("celular2"));
                   funcionario.setCelular3(rs.getString("celular3"));
                   funcionario.setEmail(rs.getString("email"));
                   funcionario.setDia(rs.getString("dia"));
                   funcionario.setHorario(rs.getString("horario"));
                   funcionario.setObservacao(rs.getString("observacao"));
                   funcionario.setSetor(SetorDAO.busca(rs.getInt("id_setor")));
                   funcionario.setRamal(rs.getString("ramal"));
                   funcionario.setDocente(rs.getBoolean("docente"));
                   funcionario.setInativo(rs.getBoolean("inativo"));
           funcionarios.add(funcionario);
        }
        
        ps.execute();
        
        ps.close();
        rs.close();
        
        return funcionarios;
    }
    
    static public FuncionarioM busca(int id) throws SQLException{
        PreparedStatement pst;
        String sql;
        FuncionarioM funcionario = null;
        SetorDAO setorDAO = new SetorDAO();
        
        sql = "select * from Funcionario where id = ?";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
           funcionario = new FuncionarioM(
                   rs.getInt("id"),
                   rs.getString("nome"),
                   rs.getString("endereco"),
                   rs.getString("cidade_estado"),
                   rs.getString("tel_residencial"),
                   rs.getString("tel_comercial1"),
                   rs.getString("tel_comercial2"),
                   rs.getString("celular1"),
                   rs.getString("celular2"),
                   rs.getString("celular3"),
                   rs.getString("email"),
                   rs.getString("dia"),
                   rs.getString("horario"),
                   rs.getString("observacao"),
                   setorDAO.busca(rs.getInt("id_setor")),
                   rs.getString("ramal"),
                   rs.getBoolean("docente"),
                   rs.getBoolean("inativo"));
                   
        }
        pst.close();
        
        return funcionario;
    }
    
    static public void excluir(FuncionarioM funcionario) throws SQLException{
        PreparedStatement pst;
        String sql;
        sql = "delete from Funcionario where id = ?";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, funcionario.getId());
        pst.execute();
        pst.close();
    }
      
    static public void alterar(FuncionarioM funcionario) throws SQLException{
        PreparedStatement pst;
        String sql;
        sql = "update Funcionario set "
                 + "nome = ?, "
                 + "endereco = ?, "
                 + "cidade_estado = ?, "
                 + "tel_residencial  = ?, "
                 + "tel_comercial1  = ?, "
                 + "tel_comercial2  = ?, "
                 + "celular1  = ?, "
                 + "celular2  = ?, "
                 + "celular3  = ?, "
                 + "email  = ?, "
                 + "dia  = ?, "
                 + "horario  = ?, "
                 + "observacao  = ?, "
                 + "id_setor = ?, "
                 + "ramal = ?, "
                 + "docente  = ?, "
                 + "inativo  = ? "
                
                 + "where id = ?";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setString(1, funcionario.getNome());
        pst.setString(2, funcionario.getEndereco());
        pst.setString(3, funcionario.getCidadeestado());
        pst.setString(4, funcionario.getTelresidencial());
        pst.setString(5, funcionario.getTelcomercial1());
        pst.setString(6, funcionario.getTelcomercial2());
        pst.setString(7, funcionario.getCelular1());
        pst.setString(8, funcionario.getCelular2());
        pst.setString(9, funcionario.getCelular3());
        pst.setString(10, funcionario.getEmail());
        pst.setString(11, funcionario.getDia());
        pst.setString(12, funcionario.getHorario());
        pst.setString(13, funcionario.getObservacao());
        pst.setInt(14, funcionario.getSetor().getId());
        pst.setString(15,funcionario.getRamal());
        pst.setBoolean(16, funcionario.getDocente());
        pst.setBoolean(17, funcionario.getInativo());
        pst.setInt(18,funcionario.getId());
        
         pst.execute();
         pst.close();
     }
    
    public List<FuncionarioM> listaTodos() throws SQLException{
        List<FuncionarioM> listaFuncionario = new ArrayList<>();
        sql = "select * from Funcionario order by nome";
        pst = Conexao.getInstance().prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        SetorDAO setorDAO = new SetorDAO();
        
        while(rs.next()){
           listaFuncionario.add(new FuncionarioM(
                   rs.getInt("id"),
                   rs.getString("nome"),
                   rs.getString("endereco"),
                   rs.getString("cidade_estado"),
                   rs.getString("tel_residencial"),
                   rs.getString("tel_comercial1"),
                   rs.getString("tel_comercial2"),
                   rs.getString("celular1"),
                   rs.getString("celular2"),
                   rs.getString("celular3"),
                   rs.getString("email"),
                   rs.getString("dia"),
                   rs.getString("horario"),
                   rs.getString("observacao"),
                   setorDAO.busca(rs.getInt("id_setor")),
                   rs.getString("ramal"),
                   rs.getBoolean("docente"),
                   rs.getBoolean("inativo")));
                   
        }
      
        
        pst.close();
        return listaFuncionario;
    }
    
    public List<FuncionarioM> listaFuncionario() throws SQLException{     
    List<FuncionarioM> listaFuncionario;
    listaFuncionario = new ArrayList<>();
    
    sql = "select * from Funcionarios order by nome";
    pst = Conexao.getInstance().prepareStatement(sql);
    ResultSet rs = pst.executeQuery();
    
    while(rs.next()){
           listaFuncionario.add(new FuncionarioM(
                   rs.getInt("id"),
                   rs.getString("nome"),
                   rs.getString("endereco"),
                   rs.getString("cidade_estado"),
                   rs.getString("tel_residencial"),
                   rs.getString("tel_comercial1"),
                   rs.getString("tel_comercial2"),
                   rs.getString("celular1"),
                   rs.getString("celular2"),
                   rs.getString("celular3"),
                   rs.getString("email"),
                   rs.getString("dia"),
                   rs.getString("horario"),
                   rs.getString("observacao"),
                   SetorDAO.busca(rs.getInt("id_setor")),
                   rs.getString("ramal"),
                   rs.getBoolean("docente"),
                   rs.getBoolean("inativo")));
        }
    pst.close();
    return listaFuncionario;
    }
    
}
