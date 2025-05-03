package br.cefet;

import java.util.List;
import java.util.ArrayList;

public class Pessoa {
    private String nome;
    private String cpf;
    private int matricula;
    private String dataNascimento;
    private String genero;
    private List<Contato> contatos;
    private Endereco endereco;
    private List<Documento> documentos;
    
    public Pessoa(String nome, int matricula){
        setNome(nome);
        setMatricula(matricula);
    }

    public String getNome(){
        return nome;
    }
    
    public String getCpf(){
        return cpf;
    }

    public int getMatricula(){
        return matricula;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setMatricula(int matricula){
        this.matricula = matricula;
    }
    
}
