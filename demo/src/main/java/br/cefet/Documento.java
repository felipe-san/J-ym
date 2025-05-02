package br.cefet;

public class Documento {
    public enum tipoDocumento {
        CPF,
        RG,
        CNH
    }

    private tipoDocumento tipo;
    private String conteudo;

    public Documento(tipoDocumento tipo, String conteudo){
        setTipo(tipo);
        setConteudo(conteudo);
    }

    public tipoDocumento getTipo() {
        return tipo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public void setTipo(tipoDocumento tipo) {
        this.tipo = tipo;
    }
}


