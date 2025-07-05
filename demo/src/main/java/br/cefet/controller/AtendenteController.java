package br.cefet.controller;

import java.util.List;

import br.cefet.dao.AtendenteDAO;
import br.cefet.model.Atendente;
import br.cefet.model.TipoContrato;
import br.cefet.model.TipoTurno;

public class AtendenteController {
    private AtendenteDAO atendenteDAO;

    public AtendenteController(){
        atendenteDAO = new AtendenteDAO();
    }

    public List<Atendente> lerAtendentes(){
        List<Atendente> atendentes = atendenteDAO.lerAtendentes();
        return atendentes;
    }


    public void criarAtendente(TipoTurno turno, int matricula, String genero, float salario, String nome, String setor, String dataNascimento, TipoContrato tipoContrato, String status, String dataAdmissao, String ctps){
        Atendente atendente = new Atendente(turno, matricula, genero, salario, nome, setor, dataNascimento, tipoContrato, status, dataAdmissao, ctps);
        atendenteDAO.criarAtendente(atendente);
    }

    public void atualizarAtendente(int indice, TipoTurno turno, int matricula, String genero, float salario, String nome, String setor, String dataNascimento, TipoContrato tipoContrato, String status, String dataAdmissao, String ctps){
        Atendente atendente = new Atendente(turno, matricula, genero, salario, nome, setor, dataNascimento, tipoContrato, status, dataAdmissao, ctps);
        atendenteDAO.atualizarAtendente(atendente, indice);
    }

    public void destruirAtendente(int indice){
        atendenteDAO.destruirAtendente(indice);
    }

    public String checkFlag(String flag, String options){
        if (!options.contains(flag)){
            System.out.println("Opção inválida.");
            flag = "invalido";
        }
        return flag;
    }

   
}
