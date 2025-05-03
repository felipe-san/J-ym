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

        Documento d1 = new Documento(TipoDocumento.CPF, "155.066.557-03");
        System.out.printf("\nTipo doc: %s - Codigo: %s\n", d1.getTipo(), d1.getConteudo());        

        Random rand1 = new Random();

        Pessoa p1 = new Pessoa(nomes[sortearNumero(nomes)], rand1.nextInt(200));

        System.out.printf("\n\nNome: %s\nMatricula: %d\n", p1.getNome(), p1.getMatricula());

    }
}

