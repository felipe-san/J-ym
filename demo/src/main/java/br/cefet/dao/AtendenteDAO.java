package br.cefet.dao;

import br.cefet.model.Atendente;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AtendenteDAO {

    public AtendenteDAO(){

    }

    public List<Atendente> lerAtendentes(){
        List<Atendente> atendentes = new ArrayList<>();
        
        return atendentes;
    }

    public void criarAtendente(Atendente atendente){
        System.out.println("Salvando atendente");


        try {
            FileWriter writer = new FileWriter("/home/felipe/Área de Trabalho/Feh/Antonio/Coisas de Java/J-ym/demo/src/main/java/br/cefet/db/db.csv", true);
            writer.write(atendente.getMatricula() + "," + atendente.getNome() + "," + atendente.getGenero() + "," + "R$" + atendente.getSalario() + "," + atendente.getSetor() + "," + atendente.getTurno() + "," + atendente.getDataNascimento() + "," + atendente.getTipoContrato() + "," + atendente.getStatus() + "," + atendente.getDataAdmissao() + "," + atendente.getCtps() + "," +  System.lineSeparator());
            writer.close();
            System.out.println(atendente.getNome());

        } catch (IOException e){
            System.out.println("DAO deu merda...");
            e.printStackTrace();
        }
        

    }
}
