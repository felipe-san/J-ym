package br.cefet.model;

public enum TipoContrato {
    PJ("Pessoa Jurídica"),
    CLT("Carteira de Trabalho"),
    PRESTADOR("Prestador de Serviços");

    private String valorContrato;
    TipoContrato(String valorContrato){
        this.valorContrato = valorContrato;
    }

    public String getContrato(){
        return valorContrato;
    }
}
