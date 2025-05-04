package br.cefet;
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

        Aluno a1 = new Aluno(nomes[sortearNumero(nomes)], matricula, "03/08/1998", "Masculino");
        System.out.printf("\nNome: %s", a1.getNome());
        System.out.printf("\nData nascimento: %s", a1.getDataNascimento());
        System.out.printf("\nMatricula: %s", a1.getMatricula());
        System.out.printf("\nGenero: %s", a1.getGenero());

        a1.addDocumento(new Documento(TipoDocumento.CPF, "145.026.552-03"));
        a1.addDocumento(new Documento(TipoDocumento.RG, "34.748.317-05"));
        a1.addContato(new Contato(TipoContato.EMAIL, "kieran.ershaw@hotmail.com"));

        for(Documento documento: a1.getDocumentos()){
            System.out.printf("\nTipo de documento: %s - Conteudo: %s", documento.getTipo(), documento.getConteudo());
        }

        for(Contato contato: a1.getContatos()){
            System.out.printf("\nTipo de contato: %s - Conteudo: %s", contato.getTipo(), contato.getConteudo());
        }

        System.out.println();
    }
}

