package br.cefet.view;

import java.util.Scanner;
import br.cefet.controller.AtendenteController;
import br.cefet.model.TipoContrato;
import br.cefet.model.TipoTurno;

public class ScanAtendente {
    private final Scanner scanner = new Scanner(System.in);
    private final AtendenteController atendenteController;
    private String flag;

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
        
            default:
                break;
        }

    }

    private void criarAtendente(){
        //Creating and initializating important attributes
        TipoTurno turno = TipoTurno.MANHA;

        AtendenteController atendenteController = new AtendenteController();
        
        //Scanning nome
        System.out.printf("Digite o nome: ");
        String nome = scanner.nextLine();
        
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
        int matricula = Integer.parseInt(scanner.nextLine());

        //Scanning genero
        System.out.printf("\nDigite o genero: ");
        String genero = scanner.nextLine();

        //Scanning salario
        System.out.printf("\nDigite o salário: ");
        float salario = Float.parseFloat(scanner.nextLine());

        //Scanning setor
        System.out.printf("\nDigite o setor: ");
        String setor = scanner.nextLine();

        //Scanning dataNascimento
        System.out.printf("\nDigite a data de nascimento: ");
        String dataNascimento = scanner.nextLine();

        //Scanning tipoContrato
        do{
            System.out.println("Escolha o contrato:");
            System.out.println("1 - PJ" + "\n2 - CLT" + "\n3 - PRESTADOR DE SERVIÇOS");
            flag = scanner.nextLine();
            flag = atendenteController.checkFlag(flag, "123");
        } while (flag == "invalido");

        TipoContrato tipoContrato = TipoContrato.values()[Integer.parseInt(flag) - 1];

        //Scanning status
        System.out.printf("\nDigite o status: ");
        String status = scanner.nextLine();

        //Scanning dataAdmissao
        System.out.printf("\nDigite a data de admissão: ");
        String dataAdmissao = scanner.nextLine();

        //Scanning ctps
        System.out.printf("\nDigite a CTPS: ");
        String ctps = scanner.nextLine();

        //calling controller
        atendenteController.criarAtendente(turno, matricula, genero, salario, nome, setor, dataNascimento, tipoContrato, status, dataAdmissao, ctps);
        
    }

    private void lerAtendentes(){
        
    }
}
