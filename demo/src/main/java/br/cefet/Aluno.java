package br.cefet;

import java.util.List;
import java.util.ArrayList;

public class Aluno extends Pessoa{
    private Assinatura assinatura;
    private List<Avaliacao> avaliacoes;
    
    // private float imc; // vai pra avaliacao
    

    public Aluno(String nome, int matricula, String dataNascimento, String genero){
        super(nome, matricula, dataNascimento, genero);
        avaliacoes = new ArrayList<>();
    }

    public Assinatura getAssinatura(){
        return assinatura;
    }
    
    public void setAssinatura(Assinatura assinatura){
        this.assinatura = assinatura;        
    }

    public void addAvaliacao(Avaliacao avaliacao){
        this.avaliacoes.add(avaliacao);
    }
}
