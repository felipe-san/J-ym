package br.cefet.view;

import java.util.Scanner;
import java.util.List;

import br.cefet.controller.ExercicioController;
import br.cefet.model.Exercicio;

public class ScanExercicio {
    private final Scanner scanner = new Scanner(System.in);
    private final ExercicioController exercicioController;
    private List<Exercicio> exercicios;
    private String flag;
    private String nome;
    private String local;
    private int series;
    private int repeticoes;
    private float carga;
    private int tempoDescanso;


    public ScanExercicio(){
        exercicioController = new ExercicioController();
    }
        
    public void iniciarExercicio(){
        do {
            System.out.println("\nEscolha uma opção:\n1 - Criar Exercicio\n2 - Ver Exercicios\n3 - Atualizar\n4 - Destruir\n");
            flag = scanner.nextLine();
            flag = exercicioController.checkFlag(flag, "1234");
        } while (flag == "invalido");
        
        switch (flag) {
            case "1":
                criarExercicio();
                break;
        
            case "2":
                lerExercicios();
                break;

            case "3":
                atualizarExercicio();
                break;

            case "4":
                destruirExercicio();
                break;

            default:

                System.out.println("Opção ainda não implementada.");
                break;
        }

    }

    private void preencherExercicio(){
        //Scanning nome
        System.out.printf("Digite o nome: ");
        nome = scanner.nextLine();
        
        //Scanning local
        System.out.printf("\nDigite o local do exercício: ");
        local = scanner.nextLine();

        //Scanning series
        System.out.printf("\nDigite a quantidade de séries: ");
        series = Integer.parseInt(scanner.nextLine());

        //Scanning repeticoes
        System.out.printf("\nDigite a quantidade de repetições: ");
        repeticoes = Integer.parseInt(scanner.nextLine());

        //Scanning carga
        System.out.printf("\nDigite a carga (em quilos): ");
        carga = Float.parseFloat(scanner.nextLine());

        //Scanning tempoDescanso
        System.out.printf("\nDigite o tempo de descanso (em segundos): ");
        tempoDescanso = Integer.parseInt(scanner.nextLine());
    }

    private void criarExercicio(){
        preencherExercicio();

        //calling controller
        exercicioController.criarExercicio(nome, local, series, repeticoes, carga, tempoDescanso);
        
    }

    private void lerExercicios(){
        exercicios = exercicioController.lerExercicios();
        int numeroExercicio = 1;

        for (Exercicio exercicio : exercicios) {
            System.out.println("\nExercício nº " + numeroExercicio);
            System.out.println("Nome: " + exercicio.getNome());
            System.out.println("Local: " + exercicio.getLocal());
            System.out.println("Séries: " + exercicio.getSeries());
            System.out.println("Repetições: " + exercicio.getRepeticoes());
            System.out.println("Carga: " + exercicio.getCarga() + "kg");
            System.out.println("Tempo de descanso: " + exercicio.getTempoDescanso() + "s");

            numeroExercicio++;
        }
    }


    private int previewExerciciosUpdateDestroy(String editarDestruir){
        if (exercicios == null){
            lerExercicios();
        }

        System.out.printf("\nQual exercício deseja %s? [1-%d] ", editarDestruir, exercicios.size());
        return Integer.parseInt(scanner.nextLine());
    }
    private void atualizarExercicio(){
        
        int indice = previewExerciciosUpdateDestroy("editar");
        preencherExercicio();
        exercicioController.atualizarExercicio(indice, nome, local, series, repeticoes, carga, tempoDescanso);
    }

    private void destruirExercicio(){
        int indice = previewExerciciosUpdateDestroy("destruir");
        exercicioController.destruirExercicio(indice);
    }
}
