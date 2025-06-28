package br.cefet.model;

public class Contato {
    private TipoContato tipo;
    private String conteudo;

    public Contato(TipoContato tipo, String conteudo){
        setTipo(tipo);
        setConteudo(conteudo);
    }

    public TipoContato getTipo(){
        return tipo;
    }

    public String getConteudo(){
        return conteudo;
    }

    public void setTipo(TipoContato tipo){
        this.tipo = tipo;
    }

    public void setConteudo(String conteudo){
        this.conteudo = conteudo;
    }
}
