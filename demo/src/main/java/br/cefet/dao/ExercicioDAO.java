package br.cefet.dao;

import br.cefet.model.Exercicio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ExercicioDAO {
    private String dbPath = "/home/felipe/Área de Trabalho/Feh/Antonio/Coisas de Java/J-ym/demo/src/main/java/br/cefet/db/db.csv";

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
        try (BufferedReader reader = new BufferedReader(new FileReader(dbPath))) {
            reader.readLine();
            Path caminho = FileSystems.getDefault().getPath("/home/felipe/Área de Trabalho/Feh/Antonio/Coisas de Java/J-ym/demo/src/main/java/br/cefet/db/", "db.csv");
            String exercicioAtualizado = "EXERCICIO" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," +  exercicio.getNome() + "," + exercicio.getLocal() + "," + exercicio.getSeries() + "," + exercicio.getRepeticoes() + "," + exercicio.getCarga() + "," + exercicio.getTempoDescanso();
            List<String> linhas = Files.readAllLines(caminho);
            int indiceTrue = 1;
            int numExercicios = 0;

            //definir indice para utilização no set
            for (String linha : linhas) {
                if (linha.contains("EXERCICIO")){
                    numExercicios++;
                }
                
                if (numExercicios == indiceBuscado){
                    break;
                }
                
                indiceTrue++;

            }
            
            linhas.set(indiceTrue - 1, exercicioAtualizado);
            Files.write(caminho, linhas);
            System.err.println("Exercicio Atualizado");
        } catch (IOException e) {
            System.out.println("DAO deu merda...");
            e.printStackTrace();
        }
    }

    public void destruirExercicio(int indiceBuscado){
        try (BufferedReader reader = new BufferedReader(new FileReader(dbPath))) {
            reader.readLine();
            Path caminho = FileSystems.getDefault().getPath("/home/felipe/Área de Trabalho/Feh/Antonio/Coisas de Java/J-ym/demo/src/main/java/br/cefet/db/", "db.csv");
            List<String> linhas = Files.readAllLines(caminho);
            int indiceTrue = 1;
            int numExercicios = 0;

            //definir indice para utilização no set
            for (String linha : linhas) {
                
                if (linha.contains("EXERCICIO")){
                    numExercicios++;
                }
                
                if (numExercicios == indiceBuscado){
                    break;
                }

                System.out.println("\n" + linha);
                System.out.println("Quantidade de exercicios: " + numExercicios + " - indice: " + indiceTrue);

                indiceTrue++;
            }
            
            linhas.remove(indiceTrue - 1);
            Files.write(caminho, linhas);
            System.out.println("Exercicio destruído");
        } catch (IOException e) {
            System.out.println("DAO deu merda...");
            e.printStackTrace();
        }
    }
}
