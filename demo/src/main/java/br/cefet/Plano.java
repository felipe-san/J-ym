package br.cefet;

public class Plano {
    private float valor;
    private String formaPagamento;
    private TipoPlano tipo;
    private String dataInicio;
    private String dataVencimento;
    
    public Plano(){
        
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public TipoPlano getTipo() {
        return tipo;
    }

    public float getValor() {
        return valor;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setValor(float valor){
        this.valor = valor;
    }

    public void setFormaPagamento(String formaPagamento){
        this.formaPagamento = formaPagamento;
    }

    public void setTipo(TipoPlano tipo){
        this.tipo = tipo;
    }

    public void setDataVencimento(String dataVencimento){
        this.dataVencimento = dataVencimento;
    }

}
