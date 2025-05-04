package br.cefet;

public class Endereco {
    private String logradouro;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String cep;
    private String estado;

    public Endereco(String logradouro, int numero, String complemento, String bairro, String cidade, String cep, String estado){
        setBairro(bairro);
        setCep(cep);
        setCidade(cidade);
        setComplemento(complemento);
        setEstado(estado);
        setLogradouro(logradouro);
        setNumero(numero);
    }

    public String getLogradouro() {
        return logradouro;
    }

    public int getNumero(){
        return numero;
    }

    public String getComplemento(){
        return complemento;
    }

    public String getBairro(){
        return bairro;
    }

    public String getCep(){
        return cep;
    }

    public String getCidade(){
        return cidade;
    }

    public String getEstado(){
        return estado;
    }

    public void setLogradouro(String logradouro){
        this.logradouro = logradouro;
    }

    public void setNumero(int numero){
        this.numero = numero;
    }

    public void setComplemento(String complemento){
        this.complemento = complemento;
    }

    public void setBairro(String bairro){
        this.bairro = bairro;
    }

    public void setCep(String cep){
        this.cep = cep;
    }

    public void setCidade(String cidade){
        this.cidade = cidade;
    }

    public void setEstado(String estado){
        this.estado = estado;
    }
}
