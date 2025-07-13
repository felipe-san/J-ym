package br.cefet.model;

import java.util.List;
import java.util.ArrayList;

public abstract class Pessoa {
    private String nome;
    private int matricula;
    private String dataNascimento;
    private String genero;
    private List<Contato> contatos;
    private Endereco endereco;
    private List<Documento> documentos;

    public Pessoa() {
        documentos = new ArrayList<>();
        contatos = new ArrayList<>();
    }

    public Pessoa(String nome, int matricula, String dataNascimento, String genero){
        documentos = new ArrayList<>();
        contatos = new ArrayList<>();
        setNome(nome);
        setMatricula(matricula);
        setDataNascimento(dataNascimento);
        setGenero(genero);
    }

    public String getNome(){
        return nome;
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

    public void setEndereco(Endereco endereco){
        this.endereco = endereco;
    }

    public void addContato(Contato contato){
        this.contatos.add(contato);
    }

    public void addDocumento(Documento documento){
        this.documentos.add(documento);
    }


}
