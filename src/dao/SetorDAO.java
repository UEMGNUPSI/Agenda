package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.FuncionarioM;
import model.SetorM;


public class SetorDAO { 
    /*
    DAO = Database Acess Object
    Métodos = também chamados de procedimento ou FUNÇÕES. Ele determina comportamento dos objetos.
    Objetos = você tem Int, String e Float que são variáveis padrões porém, 
    pode criar "variáveis especificas" que são chamadas de objetos, 
    e os mesmos são REPRESENTAÇÕES do mundo real, você pode criar um objeto Lápis, que por atributo tem Cor, dai
    pro computador ENTENDER que cor é um atributo, você tem que construir o objeto, pensando de forma análoga, se
    você me falar que seu lápis é azul, sem TER um lápis azul pra me mostrar, eu não vou entender que é um lápis, nem
    que é azul.
    
    Depois que construiu o objeto(imagina aparecendo na sua mão um lápis, porém ele não tem cor)
    O construtor está lá, criado, o objeto existe, porém, seus atributos não são preenchidos, ele fica lá paradinho esperando
    pra ser usado, e ele pode ser construído vazio, só pra inicializar, depois você passa um cheio.
    Mas, como você vai dizer pro construtor(o cara que vai criar o objeto) que o lápis que você ta é azul? R: GET ou SET
    
    Get e Set são métodos acessores, porque esses atributos, devem ser protegidos, encapsulados.
    Encapsulamento = juntar o programa em partes, o mais isoladas possíveis. 
    (imagina se a gente escrever esse software inteiro em UMA única classe... inviável)
    
    GET = significa Adotar, Asumir. 
    public String GetCor() { return cor = "azul"; } 
    você chama o método GetCor() pra PEGAR A COR, e dai ele retorna a cor, pra onde ele retorna?
    retorna pra váriavel que você criou lá em cima na declaração das variáveis: String cor. 
    Como essa cor pode mudar, você já não passa o "azul", é inviável, porque nem todo lápis é azul,
    então esse método é chamado pra quando você quiser assumir que o lápis tem outra cor.
    
    SET = significa Modificar. Chamado quando você tiver que modificar o objeto 
    (as vezes nem é criado esse método, porque pode ser que um atributo do objeto não deva ou não possa ser modificado)
    ex: public void setCor(String cor) { this.cor = cor; }
    Quando você cria lá no alt+insert o construtor, com os atributos que precisa, ou um vazio pra caso você precise que seja
    inicializado mas, que ele espere por nada(vazio), ele cria com o nome da classe um método que cria o objeto, no caso do lápis,
    public Lapis (ai aqui ele mostra os parâmetros que serão pegos: String cor){
        this.cor = cor; <- o que significa isso?
    }
        se você clicar no primeiro cor, vai ver que ele é a variável que você
        criou lá na declaração, e o segundo, é o parâmetro.
        this serve para você visualmente conseguir diferenciar sobre qual variável está dizendo
        a variável na declaração, precisa ser colocada aqui dentro, pra receber o valor que será pego por parâmetro.
        
        um exemplo melhor seria:
        private String VariavelQuePegaCor; //inicializa variável local
        public Lapis( String CorDoLapisSetadoOuGetado ){ //cria construtor, e diz, quais os atributos que vou precisar, no caso, lápis.
            VariavelQuePegaCor = CorDoLapisSetadoOuGetado; //isso é igual a this.cor = cor;, só simplifica.
            Você ao ter um parâmetro na sua classe "lapis(parametro)", precisa necessariamente ser pego em algum lugar
            nesse método o CorDoLapisSetadoOuGetado, ta ali flutuando, até que é digo pra ele: ou, vem pra cá, ele vai ficar perdido.
        }
    
    
  
    
    nessa classe vai conter todos os métodos que vai usar no VIEW(vista, visão, o que o usuário vê).
    */
    PreparedStatement pst; //o objeto PreparedStatement(declaração preparada) pré compila uma declaração do SQL 
    // ele espera Métodos setters(set) tipo setInt, setString... e os mesmo tem que ser compatível com o que foi declarado no banco
    // se no banco tem um ID int, aqui tem que usar setINT.
    
    String sql; // Objeto tipo String para enviar qual será o comando que o banco deve executar
    
    /*
    Declaramos nesse projeto os métodos estáticos pois, valores não serão alterados(são estáticos)
    por causa disso, ele não trabalha com váriaveis locais da CLASSE, e portanto, precisa-se criar as
    Variáveis pst e sql localmente no MÉTODO, para quando for chamado, elas serão criadas, e depois descartadas
    variáveis locais: apenas aquela função pode usar
    variáveis globais: podem ser usadas em qualquer função(é declarada fora de todas)
    */
    
    static public void salvar (SetorM setor) throws SQLException{ 
        /*Declaração de métodos: primeiro vem a visibilidade: static, public, protected, private.
        depois o que essa classe deve RETORNAR pra classe principal, no caso pro SetorDAO: pode ser qualquer objeto, ou nenhum, como no casso dessa classe que é void.
        Depois o nome dela: deve ser primeira letra do primeiro nome minúsculo e as outras primeiras maiúsculas,
        e o nome deve mais claramente possível, representar o que ela faz, no caso dessa poderia ser inserirValoresEmSetor.
        */
        
        /*
        Método para fazer um insert na tabela setor, primeiro cria as variáveis locais já explicadas,
        atribui a String sql qual será a instrução que deve ser feita no banco(só atribui), cria uma conexão com o banco
        e passa a linha que deve ser executada, os sets, passam os valores para preencher os ?, o execute faz a linha PREENCHIDA
        ser executada no banco, depois a conexão é fechada.
        */
        PreparedStatement pst;
        String sql;
        sql = "insert into setor values (?,?)";
        pst = Conexao.getInstance().prepareStatement(sql); //Conexão.getInstance(), Conexão é a classe para conexão com o banco
        // .getInstance é um método da classe conexão que retorna uma conexão, pra dar um "ok, o banco realizará a operação".
        pst.setInt(1,0);//sempre passa 0, pois é auto increment, ai o banco que vai atribuir valor.
        /*(SetorM setor), é a declaração de que esse método, PRECISA que algo seja dado a ele, para ele trabalhar,
        no caso, TEMOS que enviar um objeto SetorM pra cá, esse objeto SetorM vai vir pra esse método, com o nome de setor,
        mas, ele não vai fazer nada, e não ser que seja atribuido a ele uma função, nesse caso como os atributos nome e ramal,
        tem diferentes valores cada vez que entrar nesse método, por isso, faremos com que o objeto que entre aqui(já preenchido), 
        atribua seus valores ao comando que será feito no banco de dados, se entrar um objeto de nome: ab ramal: 1,2*/
        pst.setString(2, setor.getNome());  //será passado uma instrução pro banco pra passar 0 no id, ab em nome, e 1,2 em ramal.
        pst.execute();
        pst.close();
    }
    
    public List<SetorM> ListaSetor() throws SQLException{ //declaração de uma método tipo Array List
    // Array list é uma coleção de objetos que você pode manipular.
    // Você pode criar seus objetos - através de uma classe - e agrupá-los através de ArrayList e realizar, 
    // nessa coleção, várias operações, como: adicionar e retirar elementos, ordená-los, procurar por um elemento específico,
    // apagar um elemento específico, limpar o ArrayList dentre outras possibilidades.
    
    List<SetorM> listaSetor;
    listaSetor = new ArrayList<>();
    
    sql = "select * from setor order by nome";
    pst = Conexao.getInstance().prepareStatement(sql);
    ResultSet rs = pst.executeQuery();
    
    while (rs.next()){
        listaSetor.add(new SetorM(rs.getInt("id"), 
                                  rs.getString("nome")));
    }
    pst.close();
    return listaSetor;
    }
    
    static public void excluir (SetorM setor) throws SQLException{
        PreparedStatement pst;
        String sql;
        
        sql = "delete from setor where id = ?";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setInt(1,setor.getId());
        pst.execute();
        pst.close();
    }
    
    static public void alterar (SetorM setor) throws SQLException{
        PreparedStatement pst;
        String sql;
        sql = "update setor set nome=? where id=? ";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setString(1, setor.getNome());
        pst.setInt(2, setor.getId());
        pst.execute();
        pst.close();
        
    }
    static public SetorM busca(int id) throws SQLException{
        PreparedStatement pst;
        String sql;
        sql = "select * from setor where id = ?";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, id);
        SetorM set = null;
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
           set = new SetorM((rs.getInt("id")), 
                   rs.getString("nome"));
        }
        pst.close();
        return set;
    }
     static  public SetorM buscaNome(String nome) throws SQLException{
        PreparedStatement pst;
        String sql;
        sql = "select * from setor where nome = ?";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setString(1, nome);
        SetorM set = null;
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
           set = new SetorM((rs.getInt("id")), 
                   rs.getString("nome"));
        }
        pst.close();
        return set;
    }
     
        public List<SetorM> listaTodos() throws SQLException{
        List<SetorM> listasetor = new ArrayList<SetorM>();
        sql = "select * from setor order by nome";
        pst = Conexao.getInstance().prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
           listasetor.add(new SetorM((rs.getInt("id")),
                   rs.getString("nome"))
           );
        }
        pst.close();
        return listasetor;
    }
}
