package br.cefet;

import java.util.ArrayList;
import java.util.List;

public class Plano {
    private float valor;
    private String formaPagamento;
    private String tipo;
    private String dataVencimento;
    private List<Aluno> alunos;
    
    public Plano(){
        this.alunos = new ArrayList<>();
    }
    
    public List<Aluno> getAlunos() {
        return alunos;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public String getTipo() {
        return tipo;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor){
        this.valor = valor;
    }

    public void setFormaPagamento(String formaPagamento){
        this.formaPagamento = formaPagamento;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public void setDataVencimento(String dataVencimento){
        this.dataVencimento = dataVencimento;
    }

    public void addAluno(Aluno aluno){
        this.alunos.add(aluno);
    }
}
