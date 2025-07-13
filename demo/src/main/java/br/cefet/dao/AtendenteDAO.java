package br.cefet.dao;

import br.cefet.model.Atendente;
import br.cefet.model.TipoContrato;
import br.cefet.model.TipoTurno;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class AtendenteDAO {
    private String dbPath = Paths.get("src/main/java/br/cefet/db/db.csv").toAbsolutePath().toString();
    public AtendenteDAO(){

    }

    public List<Atendente> lerAtendentes(){
        List<Atendente> atendentes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(dbPath))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null){
                String data[] = line.split(",");
                if (data[0].contains("ATENDENTE")){
                    atendentes.add(new Atendente(TipoTurno.valueOf(data[6]), Integer.parseInt(data[1]), data[3], Float.parseFloat(data[4]), data[2], data[5], data[7], TipoContrato.valueOf(data[8]), data[9], data[10], data[11]));
                }
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
            writer.write("ATENDENTE" + "," + atendente.getMatricula() + "," + atendente.getNome() + "," + atendente.getGenero() + "," + atendente.getSalario() + "," + atendente.getSetor() + "," + atendente.getTurno() + "," + atendente.getDataNascimento() + "," + atendente.getTipoContrato() + "," + atendente.getStatus() + "," + atendente.getDataAdmissao() + "," + atendente.getCtps() + "," +  System.lineSeparator());
            writer.close();
            System.out.println("Salvando atendente " + atendente.getNome());

        } catch (IOException e){
            System.out.println("DAO deu merda...");
            e.printStackTrace();
        }
    }

    public void atualizarAtendente(Atendente atendente, int indiceBuscado){
        try (BufferedReader reader = new BufferedReader(new FileReader(dbPath))) {
            reader.readLine();
            Path caminho = Paths.get(dbPath);
            String atendenteAtualizado = "ATENDENTE" + "," + atendente.getMatricula() + "," + atendente.getNome() + "," + atendente.getGenero() + "," + atendente.getSalario() + "," + atendente.getSetor() + "," + atendente.getTurno() + "," + atendente.getDataNascimento() + "," + atendente.getTipoContrato() + "," + atendente.getStatus() + "," + atendente.getDataAdmissao() + "," + atendente.getCtps();
            List<String> linhas = Files.readAllLines(caminho);
            int indiceTrue = 1;
            int numAtendentes = 0;

            //definir indice para utilização no set
            for (String linha : linhas) {
                if (linha.contains("ATENDENTE")){
                    numAtendentes++;
                }
                if (numAtendentes == indiceBuscado){
                    break;
                }
                indiceTrue++;
            }

            linhas.set(indiceTrue - 1, atendenteAtualizado);
            Files.write(caminho, linhas);
            System.out.println("Atendente " + atendente.getNome() + " atualizado");
        } catch (IOException e) {
            System.out.println("DAO deu merda...");
            e.printStackTrace();
        }
    }

    public void destruirAtendente(int indiceBuscado){
        try (BufferedReader reader = new BufferedReader(new FileReader(dbPath))) {
            reader.readLine();
            Path caminho = Paths.get(dbPath);
            List<String> linhas = Files.readAllLines(caminho);
            int indiceTrue = 1;
            int numAtendentes = 0;
            //definir indice para utilização no set
            for (String linha : linhas) {
                if (linha.contains("ATENDENTE")){
                    numAtendentes++;
                }
                if (numAtendentes == indiceBuscado){
                    break;
                }
                indiceTrue++;
            }
            linhas.remove(indiceTrue - 1);
            Files.write(caminho, linhas);
            System.out.println("Atendente destruído");
        } catch (IOException e) {
            System.out.println("DAO deu merda...");
            e.printStackTrace();
        }
    }
}
