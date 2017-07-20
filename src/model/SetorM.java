package model;

public class SetorM {
    private int id;
    private String nome;
    

    public SetorM(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public SetorM() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
