package br.cefet.controller;

import br.cefet.model.Atendente;
import br.cefet.model.TipoContrato;
import br.cefet.model.TipoTurno;

public class AtendenteController {
    public void criarAtendente(TipoTurno turno, int matricula, String genero, float salario, String nome, String setor, String dataNascimento, TipoContrato tipoContrato, String status, String dataAdmissao, String ctps){
        Atendente atendente = new Atendente(turno, matricula, genero, salario, nome, setor, dataNascimento, tipoContrato, status, dataAdmissao, ctps);
        atendente.criarAtendente();
    }

    public String checkFlag(String flag){
        switch (flag) {
            case "1":
                break;
            case "2":
                break;
            case "3":
                break;
        
            default:
                System.out.println("Opção inválida.");
                flag = "invalido";
                break;
        }
        return flag;
    }
}
