package br.cefet.dao;

import br.cefet.model.Atendente;
import br.cefet.model.TipoContrato;
import br.cefet.model.TipoTurno;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AtendenteDAO {
    private String dbPath = "/home/felipe/Área de Trabalho/Feh/Antonio/Coisas de Java/J-ym/demo/src/main/java/br/cefet/db/db.csv";

    public AtendenteDAO(){

    }

    public List<Atendente> lerAtendentes(){
        List<Atendente> atendentes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(dbPath))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null){
                String data[] = line.split(",");
                atendentes.add(new Atendente(TipoTurno.valueOf(data[5]), Integer.parseInt(data[0]), data[2], Float.parseFloat(data[3]), data[1], data[4], data[6], TipoContrato.valueOf(data[7]), data[8], data[9], data[10]));
            }
            
        } catch (IOException e) {
            System.out.println("DAO deu merda...");
            e.printStackTrace();
        }
        
        return atendentes;
    }

    public void criarAtendente(Atendente atendente){

        try {
            FileWriter writer = new FileWriter(dbPath, true);
            writer.write(atendente.getMatricula() + "," + atendente.getNome() + "," + atendente.getGenero() + "," + atendente.getSalario() + "," + atendente.getSetor() + "," + atendente.getTurno() + "," + atendente.getDataNascimento() + "," + atendente.getTipoContrato() + "," + atendente.getStatus() + "," + atendente.getDataAdmissao() + "," + atendente.getCtps() + "," +  System.lineSeparator());
            writer.close();
            System.out.println("Salvando atendente " + atendente.getNome());

        } catch (IOException e){
            System.out.println("DAO deu merda...");
            e.printStackTrace();
        }
        

    }
}
