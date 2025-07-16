package br.cefet.dao;

import br.cefet.model.Documento;
import br.cefet.model.TipoDocumento;

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

public class DocumentoDAO {
    private String dbPath = FileSystems.getDefault().getPath("").toAbsolutePath().toString().concat("/demo/src/main/java/br/cefet/db/db.csv");

    public DocumentoDAO(){

    }

    public List<Documento> lerDocumentos(){
        List<Documento> Documentos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(dbPath))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null){
                String data[] = line.split(",");
                if (data[0].contains("DOCUMENTO")){
                    Documentos.add(new Documento(TipoDocumento.valueOf(data[20]), data[21]));
                }
            }
            
        } catch (IOException e) {
            System.out.println("DAO deu merda...");
            e.printStackTrace();
        }
        
        return Documentos;
    }

    public void criarDocumento(Documento documento){

        try {
            FileWriter writer = new FileWriter(dbPath, true);
            writer.write("DOCUMENTO" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," +  "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + documento.getTipo() + "," + documento.getConteudo() + System.lineSeparator());
            writer.close();
            System.out.println("Salvando Documento ");

        } catch (IOException e){
            System.out.println("DAO deu merda...");
            e.printStackTrace();
        }
    }

    public void atualizarDocumento(Documento documento, int indiceBuscado){
        try (BufferedReader reader = new BufferedReader(new FileReader(dbPath))) {
            reader.readLine();
            Path caminho = FileSystems.getDefault().getPath(new File("").getAbsolutePath().concat("/demo/src/main/java/br/cefet/db/"), "db.csv");
            String documentoAtualizado = "DOCUMENTO" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," +  "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + "" + "," + documento.getTipo() + "," + documento.getConteudo();
            List<String> linhas = Files.readAllLines(caminho);
            int indiceTrue = 1;
            int numDocumentos = 0;

            //definir indice para utilização no set
            for (String linha : linhas) {
                if (linha.contains("DOCUMENTO")){
                    numDocumentos++;
                }
                
                if (numDocumentos == indiceBuscado){
                    break;
                } 
                
                
                
                indiceTrue++;
            }

            linhas.set(indiceTrue - 1, documentoAtualizado);
            Files.write(caminho, linhas);
            System.err.println("Documento Atualizado");
        } catch (IOException e) {
            System.out.println("DAO deu merda...");
            e.printStackTrace();
        }
    }

    public void destruirDocumento(int indiceBuscado){
        try (BufferedReader reader = new BufferedReader(new FileReader(dbPath))) {
            reader.readLine();
            Path caminho = FileSystems.getDefault().getPath(new File("").getAbsolutePath().concat("/demo/src/main/java/br/cefet/db/"), "db.csv");
            List<String> linhas = Files.readAllLines(caminho);
            int indiceTrue = 1;
            int numDocumentos = 0;
            
            //definir indice para utilização no set
            for (String linha : linhas) {
                if (linha.contains("DOCUMENTO")){
                    numDocumentos++;
                }

                if (numDocumentos == indiceBuscado){
                    break;
                } 
                
                indiceTrue++;
            }
            
            linhas.remove(indiceTrue - 1);
            Files.write(caminho, linhas);
            System.err.println("Documento destruído");
        } catch (IOException e) {
            System.out.println("DAO deu merda...");
            e.printStackTrace();
        }
    }
}

