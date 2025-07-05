package br.cefet.controller;

import java.util.List;

import br.cefet.dao.ExercicioDAO;
import br.cefet.model.Exercicio;

public class ExercicioController {
    private ExercicioDAO exercicioDAO;

    public ExercicioController(){
        exercicioDAO = new ExercicioDAO();
    }

    public List<Exercicio> lerExercicios(){
        List<Exercicio> exercicios = exercicioDAO.lerExercicios();
        return exercicios;
    }


    public void criarExercicio(String nome, String local, int series, int repeticoes, float carga, int tempoDescanso){
        Exercicio exercicio = new Exercicio(nome, local, series, repeticoes, carga, tempoDescanso);
        exercicioDAO.criarExercicio(exercicio);
    }

    public void atualizarExercicio(int indice, String nome, String local, int series, int repeticoes, float carga, int tempoDescanso){
        Exercicio exercicio = new Exercicio(nome, local, series, repeticoes, carga, tempoDescanso);
        exercicioDAO.atualizarExercicio(exercicio, indice);
    }

    public void destruirExercicio(int indice){
        exercicioDAO.destruirExercicio(indice);
    }

    public String checkFlag(String flag, String options){
        if (!options.contains(flag)){
            System.out.println("Opção inválida.");
            flag = "invalido";
        }
        return flag;
    }

   
}
