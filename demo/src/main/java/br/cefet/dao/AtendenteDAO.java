package br.cefet.dao;

import br.cefet.model.Atendente;
import java.io.FileWriter;
import java.io.IOException;

public class AtendenteDAO {


    public void criarAtendente(Atendente atendente){
        System.out.println("Salvando atendente");
        try {
            FileWriter writer = new FileWriter("/home/felipe/Área de Trabalho/Feh/Antonio/Coisas de Java/J-ym/demo/src/main/java/br/cefet/db/db.csv");
            writer.write(atendente.getNome() + System.lineSeparator());
            writer.close();
            System.err.println(atendente.getNome());

        } catch (IOException e){
            System.out.println("deu merda...");
            e.printStackTrace();
        }
        

    }
}
