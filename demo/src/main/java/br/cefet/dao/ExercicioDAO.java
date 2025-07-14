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

    public List<Exercicio> lerExercicios() {
        List<Exercicio> exercicios = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(dbPath))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 18 && data[0].contains("EXERCICIO")) {
                    try {
                        String nome = data[12];
                        String local = data[13];
                        int series = Integer.parseInt(data[14]);
                        int repeticoes = Integer.parseInt(data[15]);
                        float carga = Float.parseFloat(data[16]);
                        int tempoDescanso = Integer.parseInt(data[17]);
                        exercicios.add(new Exercicio(nome, local, series, repeticoes, carga, tempoDescanso));
                    } catch (Exception e) {
                        // Skip malformed exercicio line
                        System.err.println("Linha EXERCICIO ignorada por erro de parse: " + line);
                    }
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

    public void atualizarExercicio(Exercicio exercicio, int indiceBuscado) {
        try {
            Path caminho = Paths.get(dbPath);
            List<String> linhas = Files.readAllLines(caminho);
            int exercicioIndex = -1;
            int count = 0;
            for (int i = 1; i < linhas.size(); i++) { // skip header
                String line = linhas.get(i);
                if (line.startsWith("EXERCICIO")) {
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

    public void destruirExercicio(int indiceBuscado) {
        try {
            Path caminho = Paths.get(dbPath);
            List<String> linhas = Files.readAllLines(caminho);
            int exercicioIndex = -1;
            int count = 0;
            for (int i = 1; i < linhas.size(); i++) { // skip header
                String line = linhas.get(i);
                if (line.startsWith("EXERCICIO")) {
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
