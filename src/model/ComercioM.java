package model;

public class ComercioM {
    
    private int id;
    private String nome;
    private String area_atuante;
    private String endereco;
    private String cidadeEstado;
    private String telComercial1;
    private String telComercial2;
    private String celular;
    private String email;
    private String observacao;

    public ComercioM() {
    }

    public ComercioM(int id, String nome, String area_atuante, String endereco, String cidadeEstado, String telComercial1, String telComercial2, String celular, String email, String observacao) {
        this.id = id;
        this.nome = nome;
        this.area_atuante = area_atuante;
        this.endereco = endereco;
        this.cidadeEstado = cidadeEstado;
        this.telComercial1 = telComercial1;
        this.telComercial2 = telComercial2;
        this.celular = celular;
        this.email = email;
        this.observacao = observacao;
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

    public String getArea_atuante() {
        return area_atuante;
    }

    public void setArea_atuante(String area_atuante) {
        this.area_atuante = area_atuante;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidadeEstado() {
        return cidadeEstado;
    }

    public void setCidadeEstado(String cidadeEstado) {
        this.cidadeEstado = cidadeEstado;
    }

    public String getTelComercial1() {
        return telComercial1;
    }

    public void setTelComercial1(String telComercial1) {
        this.telComercial1 = telComercial1;
    }

    public String getTelComercial2() {
        return telComercial2;
    }

    public void setTelComercial2(String telComercial2) {
        this.telComercial2 = telComercial2;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
