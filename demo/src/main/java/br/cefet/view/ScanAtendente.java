package br.cefet.view;

import java.util.Scanner;
import java.util.List;
import br.cefet.controller.AtendenteController;
import br.cefet.model.Atendente;
import br.cefet.model.TipoContrato;
import br.cefet.model.TipoTurno;

public class ScanAtendente {
    private final Scanner scanner = new Scanner(System.in);
    private final AtendenteController atendenteController;
    private List<Atendente> atendentes;
    private String flag;
    private TipoTurno turno;
    private int matricula;
    private String genero;
    private float salario;
    private String nome;
    private String setor;
    private String dataNascimento;
    private TipoContrato tipoContrato;
    private String status;
    private String dataAdmissao;
    private String ctps;


    public ScanAtendente(){
        atendenteController = new AtendenteController();
    }
        
    public void iniciarAtendente(){
        do {
            System.out.println("Escolha uma opção:\n1 - Criar atendente\n2 - Ver Atendentes\n3 - Atualizar\n4 - Destruir\n");
            flag = scanner.nextLine();
            flag = atendenteController.checkFlag(flag, "1234");
        } while (flag == "invalido");
        
        switch (flag) {
            case "1":
                criarAtendente();
                break;
        
            case "2":
                lerAtendentes();
                break;

            case "3":
                atualizarAtendente();
                break;

            default:

                System.out.println("Opção ainda não implementada.");
                break;
        }

    }

    public void preencherAtendente(){
        //Creating and initializating important attributes
        turno = TipoTurno.MANHA;
        
        //Scanning nome
        System.out.printf("Digite o nome: ");
        nome = scanner.nextLine();
        
        //Scanning turno
        do{
            System.out.println("Escolha o turno:");
            System.out.println("1 - MANHA" + "\n2 - TARDE" + "\n3 - NOITE");
            flag = scanner.nextLine();
            flag = atendenteController.checkFlag(flag, "123");
        } while (flag == "invalido");

        turno = TipoTurno.values()[Integer.parseInt(flag) - 1];

        //Scanning matricula
        System.out.printf("\nDigite a matrícula: ");
        matricula = Integer.parseInt(scanner.nextLine());

        //Scanning genero
        System.out.printf("\nDigite o genero: ");
        genero = scanner.nextLine();

        //Scanning salario
        System.out.printf("\nDigite o salário: ");
        salario = Float.parseFloat(scanner.nextLine());

        //Scanning setor
        System.out.printf("\nDigite o setor: ");
        setor = scanner.nextLine();

        //Scanning dataNascimento
        System.out.printf("\nDigite a data de nascimento: ");
        dataNascimento = scanner.nextLine();

        //Scanning tipoContrato
        do{
            System.out.println("Escolha o contrato:");
            System.out.println("1 - PJ" + "\n2 - CLT" + "\n3 - PRESTADOR DE SERVIÇOS");
            flag = scanner.nextLine();
            flag = atendenteController.checkFlag(flag, "123");
        } while (flag == "invalido");

        tipoContrato = TipoContrato.values()[Integer.parseInt(flag) - 1];

        //Scanning status
        System.out.printf("\nDigite o status: ");
        status = scanner.nextLine();

        //Scanning dataAdmissao
        System.out.printf("\nDigite a data de admissão: ");
        dataAdmissao = scanner.nextLine();

        //Scanning ctps
        System.out.printf("\nDigite a CTPS: ");
        ctps = scanner.nextLine();
    }

    private void criarAtendente(){
        preencherAtendente();

        //calling controller
        atendenteController.criarAtendente(turno, matricula, genero, salario, nome, setor, dataNascimento, tipoContrato, status, dataAdmissao, ctps);
        
    }

    private void lerAtendentes(){
        atendentes = atendenteController.lerAtendentes();
        int numeroAtendente = 1;

        for (Atendente atendente : atendentes) {
            System.out.println("\nAtendente nº " + numeroAtendente);
            System.out.println("Matricula: " + atendente.getMatricula());
            System.out.println("Nome: " + atendente.getNome());
            System.out.println("Genero: " + atendente.getGenero());
            System.out.println("Salario: R$" + atendente.getSalario());
            System.out.println("Setor: " + atendente.getSetor());
            System.out.println("Turno: " + atendente.getTurno());
            System.out.println("Data Nascimento: " + atendente.getDataNascimento());
            System.out.println("Tipo Contrato: " + atendente.getTipoContrato());
            System.out.println("Status: " + atendente.getStatus());
            System.out.println("Data Admissão: " + atendente.getDataAdmissao());
            System.out.println("CTPS: " + atendente.getCtps());

            numeroAtendente++;
        }
    }

    private void atualizarAtendente(){
        if (atendentes == null){
            lerAtendentes();
        }

        System.out.printf("\nQual atendente deseja editar? [1-%d] ", atendentes.size());
        int indice = Integer.parseInt(scanner.nextLine());
        preencherAtendente();
        atendenteController.atualizarAtendente(indice, turno, matricula, genero, salario, nome, setor, dataNascimento, tipoContrato, status, dataAdmissao, ctps);
    }
}
