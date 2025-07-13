package br.cefet.dao;

import br.cefet.model.Exercicio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ExercicioDAO {
    private String dbPath = Paths.get("src/main/java/br/cefet/db/db.csv").toAbsolutePath().toString();

    public ExercicioDAO(){

    }

    public List<Exercicio> lerExercicios(){
        List<Exercicio> exercicios = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(dbPath))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null){
                String data[] = line.split(",");
                if (data[0].contains("EXERCICIO")){
                    exercicios.add(new Exercicio(data[12], data[13], Integer.parseInt(data[14]), Integer.parseInt(data[15]), Float.parseFloat(data[16]), Integer.parseInt(data[17])));
                }
            }
            
        } catch (IOException e) {
            System.out.println("DAO deu merda...");
            e.printStackTrace();
        }
        
        return exercicios;
    }

    public void criarExercicio(Exercicio exercicio){

        try {
            FileWriter writer = new FileWriter(dbPath, true);
            writer.write("EXERCICIO" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," +  exercicio.getNome() + "," + exercicio.getLocal() + "," + exercicio.getSeries() + "," + exercicio.getRepeticoes() + "," + exercicio.getCarga() + "," + exercicio.getTempoDescanso() + "," + System.lineSeparator());
            writer.close();
            System.out.println("Salvando exercicio " + exercicio.getNome());

        } catch (IOException e){
            System.out.println("DAO deu merda...");
            e.printStackTrace();
        }
    }

    public void atualizarExercicio(Exercicio exercicio, int indiceBuscado){
        try {
            Path caminho = Paths.get(dbPath);
            List<String> linhas = Files.readAllLines(caminho);
            int exercicioIndex = -1;
            for (int i = 0, count = 0; i < linhas.size(); i++) {
                if (linhas.get(i).startsWith("EXERCICIO")) {
                    if (count == indiceBuscado) {
                        exercicioIndex = i;
                        break;
                    }
                    count++;
                }
            }
            if (exercicioIndex != -1) {
                String exercicioAtualizado = "EXERCICIO" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," +  exercicio.getNome() + "," + exercicio.getLocal() + "," + exercicio.getSeries() + "," + exercicio.getRepeticoes() + "," + exercicio.getCarga() + "," + exercicio.getTempoDescanso();
                linhas.set(exercicioIndex, exercicioAtualizado);
                Files.write(caminho, linhas);
                System.err.println("Exercicio " + exercicio.getNome() + " atualizado");
            }
        } catch (IOException e) {
            System.out.println("DAO deu merda...");
            e.printStackTrace();
        }
    }

    public void destruirExercicio(int indiceBuscado){
        try {
            Path caminho = Paths.get(dbPath);
            List<String> linhas = Files.readAllLines(caminho);
            int exercicioIndex = -1;
            for (int i = 0, count = 0; i < linhas.size(); i++) {
                if (linhas.get(i).startsWith("EXERCICIO")) {
                    if (count == indiceBuscado) {
                        exercicioIndex = i;
                        break;
                    }
                    count++;
                }
            }
            if (exercicioIndex != -1) {
                linhas.remove(exercicioIndex);
                Files.write(caminho, linhas);
                System.out.println("Exercicio destruído");
            }
        } catch (IOException e) {
            System.out.println("DAO deu merda...");
            e.printStackTrace();
        }
    }
}
