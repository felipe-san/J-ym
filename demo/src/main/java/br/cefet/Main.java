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
        String[] nomes = {"Vito", "Felipe", "Jeovanna", "Bianca", "Jorge"};
        String[] nomes_equips = {"Supino reto com barra", "Desenvolvimento com placa", "Leg Press 45", "Cadeira Extensora"};

        Aluno n1 = new Aluno(nomes[sortearNumero(nomes)], 01, "02/03/2005");
        System.out.printf("\nNome 1: %s", n1.getNome());
        
        n1.setNome(nomes[sortearNumero(nomes)]);
        System.out.printf("\nNome 2: %s", n1.getNome());

        Equipamento e1 = new Equipamento("Adutor", nomes_equips[sortearNumero(nomes_equips)]);
        System.out.printf("\nNome Equip 1: %s", e1.getNome());
        System.out.printf("\nTipo Equip 1: %s", e1.getTipo());
        e1.setNome(nomes_equips[sortearNumero(nomes_equips)]);
        e1.setTipo("Extensor");
        System.out.printf("\nNome Equip 2: %s", e1.getNome());
        System.out.printf("\nTipo Equip 2: %s", e1.getTipo());
        Funcionario f1 = new Funcionario(1, true, 1500, nomes[sortearNumero(nomes)], "Professor", "Professores", "03/08/1998", "CLT", "Admitido", "06/04/2025", "122.255.208-05", "Rua Apinaje 15 Engenho da Rainha RJ", "215544589", "dabura@gmail.com", "(21) 95854-2558");
        System.out.printf("\nNome: %s", f1.getNome());
        f1.setNome(nomes[sortearNumero(nomes_equips)]);
        System.out.printf("\nNovo nome: %s\n", f1.getNome());
        System.out.println(f1);
        System.out.printf("\nMatricula: %d\nDisponivel: %b\nSalario: %.2f\nNome: %s\nCargo: %s\nSetor: %s\nData de nascimento: %s\nTipo de Contrato: %s\nStatus: %s\nData de Admissao: %s\nCPF: %s\nEndereco: %s\nCTPS: %s\nEmail: %s\nTelefone: %s\n", f1.getMatricula(), f1.isDisponivel(), f1.getSalario(), f1.getNome(), f1.getCargo(), f1.getSetor(), f1.getDataNascimento(), f1.getTipoContrato(), f1.getStatus(), f1.getDataAdmissao(), f1.getCpf(), f1.getEndereco(), f1.getCtps(), f1.getEmail(), f1.getTelefone());
        Plano p1 = new Plano();
        p1.setTipo("De cria");
        

        n1.setPlano(p1);
        Aluno n2 = new Aluno(nomes[sortearNumero(nomes)], 02, "05/07/2008");
        n2.setPlano(p1);
        Aluno n3 = new Aluno(nomes[sortearNumero(nomes)], 03, "12/02/2003");
        n3.setPlano(p1);
        Aluno n4 = new Aluno(nomes[sortearNumero(nomes)], 04, "19/09/2001");
        n4.setPlano(p1);

        List<Aluno> alunos = new ArrayList<>();

        alunos.add(n1);
        alunos.add(n2);
        alunos.add(n3);
        alunos.add(n4);

        n1.addTelefone("(21) 98990-3940");
        n1.addTelefone("(22) 98394-4520");
        n3.addTelefone("(21) 98201-1234");

        Plano p2 = new Plano();
        p2.setTipo("De morador");

        Plano p3 = new Plano();
        p3.setTipo("De playboy");

        List<Plano> planos = new ArrayList<>();

        planos.add(p1);
        planos.add(p2);
        planos.add(p3);

        System.out.printf("\nPlanos disponiveis\n");

        for (Plano plano : planos){
            System.out.println(plano.getTipo());
        }

        System.out.printf("\nPlano: %s\n", p1.getTipo());

        for (Aluno aluno : p1.getAlunos()){
            System.out.printf("Nome: %s - Matricula: %d\n", aluno.getNome(), aluno.getMatricula());
        }
        
        FichaTreino fi1 = new FichaTreino();
        Exercicio ex1 = new Exercicio();
        fi1.setNome("Ficha de treino superiores");
        ex1.setNome("Supino Reto deitado");
        ex1.setLocal("Maquina com manopla e banco");
        ex1.setCarga(15);
        ex1.setRepeticoes(10);
        ex1.setSeries(4);

        Exercicio ex2 = new Exercicio();
        ex2.setNome("Desenvolvimento");
        ex2.setLocal("Maquina de desenvolvimento com placa");
        ex2.setCarga(75);
        ex2.setRepeticoes(10);
        ex2.setSeries(4);

        fi1.addExercicio(ex2);
        fi1.addExercicio(ex1);

        System.out.println();
        System.out.println();
        System.out.println(fi1.getNome());
        for (Exercicio exercicio : fi1.getExercicios()){
            System.out.printf("Nome: %s\nLocal: %s\nCarga: %.2f\nRepeticoes: %d\nSeries: %d\n\n", exercicio.getNome(), exercicio.getLocal(), exercicio.getCarga(), exercicio.getRepeticoes(), exercicio.getSeries());
        }

        System.out.printf("\nTelefones:\n");

        for (Aluno aluno : alunos){
            System.out.printf("\n%s\n", aluno.getNome());
            if (aluno.getTelefones().isEmpty()){
                System.out.println("Esse aluno não tem telefone nenhum cadastrado.");
            }
            else{
                
                for (String telefone : aluno.getTelefones()){
                    System.out.printf("Telefone: %s\n", telefone);
                }
                
            }
        }


    }
}

