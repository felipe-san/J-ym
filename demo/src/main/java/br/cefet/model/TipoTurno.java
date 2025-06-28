package br.cefet.model;

public enum TipoTurno {
    MANHA("Manhã"),
    TARDE("Tarde"),
    NOITE("Noite");

    private String valorTurno;
    TipoTurno(String valorTurno){
        this.valorTurno = valorTurno;
    }

    public String getTurno(){
        return valorTurno;
    }
}
