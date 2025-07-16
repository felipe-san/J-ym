package br.cefet;

import br.cefet.view.ScanAtendente;
import br.cefet.view.ScanContato;
import br.cefet.view.ScanDocumento;
import br.cefet.view.ScanExercicio;

public class MyApp {
    public static void main(String[] args) {
        //Creating viewAtendente
        ScanAtendente viewAtendente = new ScanAtendente();
        viewAtendente.iniciarAtendente();
        
        //Creating viewExercicio
        ScanExercicio viewExercicio = new ScanExercicio();
        viewExercicio.iniciarExercicio();

        //Creating viewDocumento
        ScanDocumento viewDocumento = new ScanDocumento();
        viewDocumento.iniciarDocumento();

        //Creating viewContato
        ScanContato viewContato = new ScanContato();
        viewContato.iniciarContato();


    }
}
