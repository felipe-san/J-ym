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
                    TipoTurno turno = null;
                    try {
                        turno = TipoTurno.valueOf(data[6].toUpperCase());
                    } catch (Exception e) {
                        // Se não for um valor válido, deixa como null
                    }
                    atendentes.add(new Atendente(turno, Integer.parseInt(data[1]), data[3], Float.parseFloat(data[4]), data[2], data[5], data[7], TipoContrato.valueOf(data[8]), data[9], data[10], data[11]));
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
            writer.write("ATENDENTE" + "," + atendente.getMatricula() + "," + atendente.getNome() + "," + atendente.getGenero() + "," + atendente.getSalario() + "," + atendente.getSetor() + "," + (atendente.getTurno() != null ? atendente.getTurno().getTurno() : "") + "," + formatarData(atendente.getDataNascimento()) + "," + atendente.getTipoContrato() + "," + atendente.getStatus() + "," + formatarData(atendente.getDataAdmissao()) + "," + atendente.getCtps() + "," +  System.lineSeparator());
            writer.close();
            System.out.println("Salvando atendente " + atendente.getNome());

        } catch (IOException e){
            System.out.println("DAO deu merda...");
            e.printStackTrace();
        }
    }

    private String formatarData(String data) {
        if (data == null || data.isEmpty()) return "";
        // Aceita yyyy-MM-dd ou dd/MM/yyyy e converte para dd/MM/yyyy
        if (data.matches("\\d{4}-\\d{2}-\\d{2}")) {
            String[] parts = data.split("-");
            return parts[2] + "/" + parts[1] + "/" + parts[0];
        }
        return data;
    }

    public void atualizarAtendente(Atendente atendente, int indiceBuscado){
        try {
            Path caminho = Paths.get(dbPath);
            List<String> linhas = Files.readAllLines(caminho);
            int atendenteIndex = -1;
            for (int i = 0, count = 0; i < linhas.size(); i++) {
                if (linhas.get(i).startsWith("ATENDENTE")) {
                    if (count == indiceBuscado) {
                        atendenteIndex = i;
                        break;
                    }
                    count++;
                }
            }
            if (atendenteIndex != -1) {
                String atendenteAtualizado = "ATENDENTE" + "," + atendente.getMatricula() + "," + atendente.getNome() + "," + atendente.getGenero() + "," + atendente.getSalario() + "," + atendente.getSetor() + "," + (atendente.getTurno() != null ? atendente.getTurno().getTurno() : "") + "," + formatarData(atendente.getDataNascimento()) + "," + atendente.getTipoContrato() + "," + atendente.getStatus() + "," + formatarData(atendente.getDataAdmissao()) + "," + atendente.getCtps();
                linhas.set(atendenteIndex, atendenteAtualizado);
                Files.write(caminho, linhas);
                System.out.println("Atendente " + atendente.getNome() + " atualizado");
            }
        } catch (IOException e) {
            System.out.println("DAO deu merda...");
            e.printStackTrace();
        }
    }

    public void destruirAtendente(int indiceBuscado){
        try {
            Path caminho = Paths.get(dbPath);
            List<String> linhas = Files.readAllLines(caminho);
            int atendenteIndex = -1;
            for (int i = 0, count = 0; i < linhas.size(); i++) {
                if (linhas.get(i).startsWith("ATENDENTE")) {
                    if (count == indiceBuscado) {
                        atendenteIndex = i;
                        break;
                    }
                    count++;
                }
            }
            if (atendenteIndex != -1) {
                linhas.remove(atendenteIndex);
                Files.write(caminho, linhas);
                System.out.println("Atendente destruído");
            }
        } catch (IOException e) {
            System.out.println("DAO deu merda...");
            e.printStackTrace();
        }
    }
}
