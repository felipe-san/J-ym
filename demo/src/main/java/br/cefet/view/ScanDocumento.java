package br.cefet.view;

import java.util.Scanner;
import java.util.List;

import br.cefet.controller.DocumentoController;
import br.cefet.model.Documento;
import br.cefet.model.TipoDocumento;

public class ScanDocumento {
    private final Scanner scanner = new Scanner(System.in);
    private final DocumentoController documentoController;
    private List<Documento> documentos;
    private String flag;
    private TipoDocumento tipo;
    private String conteudo;


    public ScanDocumento(){
        documentoController = new DocumentoController();
    }
        
    public void iniciarDocumento(){
        do {
            System.out.println("Escolha uma opção:\n1 - Criar documento\n2 - Ver Documento\n3 - Atualizar\n4 - Destruir\n");
            flag = scanner.nextLine();
            flag = documentoController.checkFlag(flag, "1234");
        } while (flag == "invalido");
        
        switch (flag) {
            case "1":
                criarDocumento();
                break;
        
            case "2":
                lerDocumentos();
                break;

            case "3":
                atualizarDocumento();
                break;

            case "4":
                destruirDocumento();
                break;

            default:

                System.out.println("Opção ainda não implementada.");
                break;
        }

    }

    private void preencherDocumento(){
        //Creating and initializating important attributes
        tipo = TipoDocumento.CNH;
        
        //Scanning tipo
        do{
            System.out.println("Escolha o tipo de documento:");
            System.out.println("1 - CPF" + "\n2 - RG" + "\n3 - CNH");
            flag = scanner.nextLine();
            flag = documentoController.checkFlag(flag, "123");
        } while (flag == "invalido");

        tipo = TipoDocumento.values()[Integer.parseInt(flag) - 1];
        
        //Scanning conteudo
        System.out.printf("Digite o conteudo do " + tipo + ": ");
        conteudo = scanner.nextLine();
        
    }

    private void criarDocumento(){
        preencherDocumento();

        //calling controller
        documentoController.criarDocumento(tipo, conteudo);

    }

    private void lerDocumentos(){
        documentos = documentoController.lerDocumentos();
        int numeroDocumento = 1;

        for (Documento documento : documentos) {
            System.out.println("\nDocumento nº " + numeroDocumento);
            System.out.println("Tipo de documento: " + documento.getTipo());
            System.out.println("Conteúdo do documento: " + documento.getConteudo());

            numeroDocumento++;
        }
    }


    private int previewDocumentosUpdateDestroy(String editarDestruir){
        if (documentos == null){
            lerDocumentos();
        }

        System.out.printf("\nQual documento deseja %s? [1-%d] ", editarDestruir, documentos.size());
        return Integer.parseInt(scanner.nextLine());
    }
    private void atualizarDocumento(){
        
        int indice = previewDocumentosUpdateDestroy("editar");
        preencherDocumento();
        documentoController.atualizarDocumento(indice, tipo, conteudo);
    }

    private void destruirDocumento(){
        int indice = previewDocumentosUpdateDestroy("destruir");
        documentoController.destruirDocumento(indice);
    }
}
