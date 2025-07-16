package br.cefet.controller;

import java.util.List;

import br.cefet.dao.DocumentoDAO;
import br.cefet.model.Documento;
import br.cefet.model.TipoDocumento;

public class DocumentoController {
    private DocumentoDAO documentoDAO;

    public DocumentoController(){
        documentoDAO = new DocumentoDAO();
    }

    public List<Documento> lerDocumentos(){
        List<Documento> documentos = documentoDAO.lerDocumentos();
        return documentos;
    }


    public void criarDocumento(TipoDocumento tipo, String conteudo){
        Documento documento = new Documento(tipo, conteudo);
        documentoDAO.criarDocumento(documento);
    }

    public void atualizarDocumento(int indice, TipoDocumento tipo, String conteudo){
        Documento documento = new Documento(tipo, conteudo);
        documentoDAO.atualizarDocumento(documento, indice);
    }

    public void destruirDocumento(int indice){
        documentoDAO.destruirDocumento(indice);
    }

    public String checkFlag(String flag, String options){
        if (!options.contains(flag)){
            System.out.println("Opção inválida.");
            flag = "invalido";
        }
        return flag;
    }

   
}
