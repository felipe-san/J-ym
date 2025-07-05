package br.cefet;

import br.cefet.view.ScanAtendente;
import br.cefet.view.ScanExercicio;

public class MyApp {
    public static void main(String[] args) {
        //Creating viewAtendente
        ScanAtendente viewAtendente = new ScanAtendente();
        viewAtendente.iniciarAtendente();
        
        ScanExercicio viewExercicio = new ScanExercicio();
        viewExercicio.iniciarExercicio();

    }
}
