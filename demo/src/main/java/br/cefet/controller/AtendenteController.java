package br.cefet.controller;

import br.cefet.model.Atendente;

public class AtendenteController {
    public void criarAtendente(String nome){
        Atendente atendente = new Atendente(null, 0, nome, 0, nome, nome, nome, null, nome, nome, nome);
        atendente.criarAtendente();
    }
}
