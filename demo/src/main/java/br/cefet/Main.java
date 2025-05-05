package br.cefet;
import java.util.Random;

public class Main {
    
    public static int sortearNumero(String[] nomes){
        Random rand = new Random();
        return rand.nextInt(nomes.length);
    }

    public static void testarPessoa(Pessoa pessoa){
        System.out.printf("\nNome: %s", pessoa.getNome());
        System.out.printf("\nData nascimento: %s", pessoa.getDataNascimento());
        System.out.printf("\nMatricula: %s", pessoa.getMatricula());
        System.out.printf("\nGenero: %s", pessoa.getGenero());

        for(Documento documento: pessoa.getDocumentos()){
            System.out.printf("\nTipo de documento: %s - Conteudo: %s", documento.getTipo(), documento.getConteudo());
        }

        for(Contato contato: pessoa.getContatos()){
            System.out.printf("\nTipo de contato: %s - Conteudo: %s", contato.getTipo(), contato.getConteudo());
        }

        System.out.printf("\nEndereço: %s %d %s - %s, %s, %s - CEP: %s", pessoa.getEndereco().getLogradouro(), pessoa.getEndereco().getNumero(), pessoa.getEndereco().getComplemento(), pessoa.getEndereco().getBairro(), pessoa.getEndereco().getCidade(), pessoa.getEndereco().getEstado(), pessoa.getEndereco().getCep());

    }

    public static void main(String[] args){
        // declaração e definição de objetos/variaveis

        String[] nomes = {"Vito", "Felipe", "Jeovanna", "Bianca", "Jorge", "Davi Monteiro"};
        String[] nomes_equips = {"Supino reto com barra", "Desenvolvimento com placa", "Leg Press 45", "Cadeira Extensora"};      

        Random rand1 = new Random();
        int matricula = rand1.nextInt(200);

        Atendente at1 = new Atendente(null, matricula, null, matricula, nomes[sortearNumero(nomes)], null, null, null, null, null, null);
        at1.addDocumento(new Documento(TipoDocumento.RG, "31.728.312-5"));
        at1.addContato(new Contato(TipoContato.INSTAGRAM, "@o_lie"));
        at1.setEndereco(new Endereco("Rua Apinajé", 32, "Vila", "Engenho da Rainha", "Rio de Janeiro", "20766-590", "RJ"));

        Treinador t1 = new Treinador(matricula, null, false, null, matricula, nomes[sortearNumero(nomes)], null, null, null, null, null, null);
        t1.addDocumento(new Documento(TipoDocumento.CNH, "145.026.552-03"));
        t1.addContato(new Contato(TipoContato.TELEFONE, "(21) 97623-5484"));
        t1.setEndereco(new Endereco("Rua Bororó", 50, "-", "Engenho da Rainha", "Rio de Janeiro", "20766-590", "RJ"));
        


        Aluno a1 = new Aluno(nomes[sortearNumero(nomes)], matricula, "03/08/1998", "Masculino");
        a1.addDocumento(new Documento(TipoDocumento.CPF, "145.026.552-03"));
        a1.addContato(new Contato(TipoContato.EMAIL, "kieran.ershaw@hotmail.com"));
        a1.setEndereco(new Endereco("Rua Cherente", 245, "Fundos", "Engenho da Rainha", "Rio de Janeiro", "20766-590", "RJ"));
        a1.setAssinatura(new Assinatura(a1, "01/02/2025", "01/02/2026", new Plano(115, "Cartao Credito", TipoPlano.ANUAL, "01/02/2025", "Final da assinatura")));
        a1.addAvaliacao(new Avaliacao("01/02/2025", t1, matricula, matricula, matricula, matricula, matricula, matricula, matricula, matricula, matricula, matricula, matricula, matricula, matricula, matricula, matricula, matricula, false, false, false, null, false));

        // testes
        /*System.out.printf("\nNome: %s", a1.getNome());
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

        System.out.println();*/
        testarPessoa(a1);
        System.out.println();
        testarPessoa(at1);
        System.out.println();
        testarPessoa(t1);
        System.out.println();
    }

    
}

