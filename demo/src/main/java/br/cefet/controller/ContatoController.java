package br.cefet.controller;

import java.util.List;

import br.cefet.dao.ContatoDAO;
import br.cefet.model.Contato;
import br.cefet.model.TipoContato;

public class ContatoController {
    private ContatoDAO contatoDAO;

    public ContatoController(){
        contatoDAO = new ContatoDAO();
    }

    public List<Contato> lerContatos(){
        List<Contato> contatos = contatoDAO.lerContatos();
        return contatos;
    }


    public void criarContato(TipoContato tipo, String conteudo){
        Contato contato = new Contato(tipo, conteudo);
        contatoDAO.criarContato(contato);
    }

    public void atualizarContato(int indice, TipoContato tipo, String conteudo){
        Contato contato = new Contato(tipo, conteudo);
        contatoDAO.atualizarContato(contato, indice);
    }

    public void destruirContato(int indice){
        contatoDAO.destruirContato(indice);
    }

    public String checkFlag(String flag, String options){
        if (!options.contains(flag)){
            System.out.println("Opção inválida.");
            flag = "invalido";
        }
        return flag;
    }

   
}
