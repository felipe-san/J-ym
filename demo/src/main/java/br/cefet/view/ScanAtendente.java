package br.cefet.view;

import java.util.Scanner;

import br.cefet.controller.AtendenteController;
import br.cefet.model.Atendente;

public class ScanAtendente {
    public ScanAtendente(){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Digite o nome: ");
        String nome = scanner.nextLine();
        AtendenteController atendenteController = new AtendenteController();
        atendenteController.criarAtendente(nome);
        
    }
}
