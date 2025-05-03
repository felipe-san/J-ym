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
    
    public Pessoa(String nome, int matricula, String cpf, String dataNascimento, String genero){
        setNome(nome);
        setMatricula(matricula);
        setDataNascimento(dataNascimento);
        setGenero(genero);
        setCpf(cpf);
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

    public List<Contato> getContatos() {
        return contatos;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public String getGenero() {
        return genero;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setMatricula(int matricula){
        this.matricula = matricula;
    }
    
}
