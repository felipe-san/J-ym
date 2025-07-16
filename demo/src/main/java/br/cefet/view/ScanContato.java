package br.cefet.view;

import java.util.Scanner;
import java.util.List;

import br.cefet.controller.ContatoController;
import br.cefet.model.Contato;
import br.cefet.model.TipoContato;

public class ScanContato {
    private final Scanner scanner = new Scanner(System.in);
    private final ContatoController contatoController;
    private List<Contato> contatos;
    private String flag;
    private TipoContato tipo;
    private String conteudo;


    public ScanContato(){
        contatoController = new ContatoController();
    }
        
    public void iniciarContato(){
        do {
            System.out.println("Escolha uma opção:\n1 - Criar contato\n2 - Ver Contato\n3 - Atualizar\n4 - Destruir\n");
            flag = scanner.nextLine();
            flag = contatoController.checkFlag(flag, "1234");
        } while (flag == "invalido");
        
        switch (flag) {
            case "1":
                criarContato();
                break;
        
            case "2":
                lerContatos();
                break;

            case "3":
                atualizarContato();
                break;

            case "4":
                destruirContato();
                break;

            default:

                System.out.println("Opção ainda não implementada.");
                break;
        }

    }

    private void preencherContato(){
        //Creating and initializating important attributes
        tipo = TipoContato.EMAIL;
        
        //Scanning tipo
        do{
            System.out.println("Escolha o tipo de contato:");
            System.out.println("1 - EMAIL" + "\n2 - INSTAGRAM" + "\n3 - TELEFONE");
            flag = scanner.nextLine();
            flag = contatoController.checkFlag(flag, "123");
        } while (flag == "invalido");

        tipo = TipoContato.values()[Integer.parseInt(flag) - 1];
        
        //Scanning conteudo
        System.out.printf("Digite o conteudo do " + tipo + ": ");
        conteudo = scanner.nextLine();
        
    }

    private void criarContato(){
        preencherContato();

        //calling controller
        contatoController.criarContato(tipo, conteudo);

    }

    private void lerContatos(){
        contatos = contatoController.lerContatos();
        int numeroContato = 1;

        for (Contato contato : contatos) {
            System.out.println("\nContato nº " + numeroContato);
            System.out.println("Tipo de contato: " + contato.getTipo());
            System.out.println("Conteúdo do contato: " + contato.getConteudo());

            numeroContato++;
        }
    }


    private int previewContatosUpdateDestroy(String editarDestruir){
        if (contatos == null){
            lerContatos();
        }

        System.out.printf("\nQual contato deseja %s? [1-%d] ", editarDestruir, contatos.size());
        return Integer.parseInt(scanner.nextLine());
    }
    private void atualizarContato(){
        
        int indice = previewContatosUpdateDestroy("editar");
        preencherContato();
        contatoController.atualizarContato(indice, tipo, conteudo);
    }

    private void destruirContato(){
        int indice = previewContatosUpdateDestroy("destruir");
        contatoController.destruirContato(indice);
    }
}
