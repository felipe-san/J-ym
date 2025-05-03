package br.cefet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    
    public static int sortearNumero(String[] nomes){
        Random rand = new Random();
        return rand.nextInt(nomes.length);
    }

    public static void main(String[] args){
        String[] nomes = {"Vito", "Felipe", "Jeovanna", "Bianca", "Jorge", "Davi Monteiro"};
        String[] nomes_equips = {"Supino reto com barra", "Desenvolvimento com placa", "Leg Press 45", "Cadeira Extensora"};      

        Random rand1 = new Random();
        int matricula = rand1.nextInt(200);

        Aluno a1 = new Aluno(nomes[sortearNumero(nomes)], matricula, "155.066.557-03", "03/08/1998", "Masculino");
        System.out.println(a1.getNome());
        System.out.println(a1.getCpf());
        System.out.println(a1.getDataNascimento());
        System.out.println(a1.getMatricula());
        System.out.println(a1.getGenero());

    
    }
}

