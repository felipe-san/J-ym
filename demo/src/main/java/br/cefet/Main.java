package br.cefet;
import java.util.Random;

public class Main {
    
    public static int sortearNumero(String[] nomes){
        Random rand = new Random();
        return rand.nextInt(nomes.length);
    }

    public static void main(String[] args){
        // declaração e definição de objetos/variaveis

        String[] nomes = {"Vito", "Felipe", "Jeovanna", "Bianca", "Jorge", "Davi Monteiro"};
        String[] nomes_equips = {"Supino reto com barra", "Desenvolvimento com placa", "Leg Press 45", "Cadeira Extensora"};      

        Random rand1 = new Random();
        int matricula = rand1.nextInt(200);

        Aluno a1 = new Aluno(nomes[sortearNumero(nomes)], matricula, "03/08/1998", "Masculino");
        a1.addDocumento(new Documento(TipoDocumento.CPF, "145.026.552-03"));
        a1.addDocumento(new Documento(TipoDocumento.RG, "34.748.317-05"));
        a1.addContato(new Contato(TipoContato.EMAIL, "kieran.ershaw@hotmail.com"));
        a1.setEndereco(new Endereco("Rua Cherente", 245, "Fundos", "Engenho da Rainha", "Rio de Janeiro", "20766-590", "RJ"));
        

        // testes
        System.out.printf("\nNome: %s", a1.getNome());
        System.out.printf("\nData nascimento: %s", a1.getDataNascimento());
        System.out.printf("\nMatricula: %s", a1.getMatricula());
        System.out.printf("\nGenero: %s", a1.getGenero());

        for(Documento documento: a1.getDocumentos()){
            System.out.printf("\nTipo de documento: %s - Conteudo: %s", documento.getTipo(), documento.getConteudo());
        }

        for(Contato contato: a1.getContatos()){
            System.out.printf("\nTipo de contato: %s - Conteudo: %s", contato.getTipo(), contato.getConteudo());
        }

        System.out.printf("\nEndereço: %s %d %s - %s, %s, %s - CEP: %s", a1.getEndereco().getLogradouro(), a1.getEndereco().getNumero(), a1.getEndereco().getComplemento(), a1.getEndereco().getBairro(), a1.getEndereco().getCidade(), a1.getEndereco().getEstado(), a1.getEndereco().getCep());

        System.out.println();
    }
}

