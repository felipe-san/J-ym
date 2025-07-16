package br.cefet.dao;

import br.cefet.model.Contato;
import br.cefet.model.TipoContato;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {
    private String dbPath = FileSystems.getDefault().getPath("").toAbsolutePath().toString().concat("/demo/src/main/java/br/cefet/db/db.csv");

    public ContatoDAO(){

    }

    public List<Contato> lerContatos(){
        List<Contato> contatos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(dbPath))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null){
                String data[] = line.split(",");
                if (data[0].contains("CONTATO")){
                    contatos.add(new Contato(TipoContato.valueOf(data[18]), data[19]));
                }
            }
            
        } catch (IOException e) {
            System.out.println("DAO deu merda...");
            e.printStackTrace();
        }
        
        return contatos;
    }

    public void criarContato(Contato contato){

        try {
            FileWriter writer = new FileWriter(dbPath, true);
            writer.write("CONTATO" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," +  "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + contato.getTipo() + "," + contato.getConteudo() + System.lineSeparator());
            writer.close();
            System.out.println("Salvando contato ");

        } catch (IOException e){
            System.out.println("DAO deu merda...");
            e.printStackTrace();
        }
    }

    public void atualizarContato(Contato contato, int indiceBuscado){
        try (BufferedReader reader = new BufferedReader(new FileReader(dbPath))) {
            reader.readLine();
            Path caminho = FileSystems.getDefault().getPath(new File("").getAbsolutePath().concat("/demo/src/main/java/br/cefet/db/"), "db.csv");
            String contatoAtualizado = "CONTATO" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," +  "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + contato.getTipo() + "," + contato.getConteudo();
            List<String> linhas = Files.readAllLines(caminho);
            int indiceTrue = 1;
            int numContatos = 0;

            //definir indice para utilização no set
            for (String linha : linhas) {
                if (linha.contains("CONTATO")){
                    numContatos++;
                }
                
                if (numContatos == indiceBuscado){
                    break;
                } 
                
                
                
                indiceTrue++;
            }

            linhas.set(indiceTrue - 1, contatoAtualizado);
            Files.write(caminho, linhas);
            System.err.println("Contato Atualizado");
        } catch (IOException e) {
            System.out.println("DAO deu merda...");
            e.printStackTrace();
        }
    }

    public void destruirContato(int indiceBuscado){
        try (BufferedReader reader = new BufferedReader(new FileReader(dbPath))) {
            reader.readLine();
            Path caminho = FileSystems.getDefault().getPath(new File("").getAbsolutePath().concat("/demo/src/main/java/br/cefet/db/"), "db.csv");
            List<String> linhas = Files.readAllLines(caminho);
            int indiceTrue = 1;
            int numContatos = 0;
            
            //definir indice para utilização no set
            for (String linha : linhas) {
                if (linha.contains("CONTATO")){
                    numContatos++;
                }

                if (numContatos == indiceBuscado){
                    break;
                } 
                
                indiceTrue++;
            }
            
            linhas.remove(indiceTrue - 1);
            Files.write(caminho, linhas);
            System.err.println("Contato destruído");
        } catch (IOException e) {
            System.out.println("DAO deu merda...");
            e.printStackTrace();
        }
    }
}
