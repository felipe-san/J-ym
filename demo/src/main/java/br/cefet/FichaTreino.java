package br.cefet;

import java.util.List;
import java.util.ArrayList;

public class FichaTreino {
    private String nome;
    private List<Exercicio> exercicios;

    public FichaTreino(){
        exercicios = new ArrayList<>();
    }

    public String getNome(){
        return nome;
    }

    public List<Exercicio> getExercicios(){
        return exercicios;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void addExercicio(Exercicio exercicio){
        exercicios.add(exercicio);
    }
}
