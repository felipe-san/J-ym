package br.cefet;

public class Equipamento {
    private String tipo;
    private String marca;
    private String nome;
    private boolean emManutencao;
    private String grupoMuscular;
    private String pesoMax;
    private int id;
    private String dataCompra;

    public Equipamento(String tipo, String nome){
        setTipo(tipo);
        setNome(nome);
    }

    public String getTipo(){
        return tipo;
    }
    
    public String getMarca(){
        return marca;
    }

    public String getNome(){
        return nome;
    }
    
    public boolean isEmManutencao(){
        return emManutencao;
    }

    public String getGrupoMuscular(){
        return grupoMuscular;
    }

    public String getPesoMax(){
        return pesoMax;
    }

    public int getId(){
        return id;
    }

    public String getDataCompra(){
        return dataCompra;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setEmManutencao(boolean emManutencao){
        this.emManutencao = emManutencao;
    }
    
    public void setGrupoMuscular(String grupoMuscular){
        this.grupoMuscular = grupoMuscular;
    }

    public void setPesoMax(String pesoMax){
        this.pesoMax = pesoMax;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setDataCompra(String dataCompra){
        this.dataCompra = dataCompra;
    }
}
    
