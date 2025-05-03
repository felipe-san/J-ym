package br.cefet;

public class Documento {
    private TipoDocumento tipo;
    private String conteudo;

    public Documento(TipoDocumento tipo, String conteudo){
        setTipo(tipo);
        setConteudo(conteudo);
    }

    public TipoDocumento getTipo() {
        return tipo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public void setTipo(TipoDocumento tipo) {
        this.tipo = tipo;
    }
}


