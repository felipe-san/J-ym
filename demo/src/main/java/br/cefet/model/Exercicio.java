package br.cefet.model;

public class Exercicio {
    private String nome;
    private String local;
    private int series;
    private int repeticoes;
    private float carga;
    private int tempoDescanso;

    public Exercicio() {
    }

    public Exercicio(String nome, String local, int series, int repeticoes, float carga, int tempoDescanso){
        setCarga(carga);
        setNome(nome);
        setLocal(local);
        setSeries(series);
        setRepeticoes(repeticoes);
        setTempoDescanso(tempoDescanso);
    }

    public String getNome(){
        return nome;
    }

    public String getLocal(){
        return local;
    }

    public int getSeries(){
        return series;
    }

    public int getRepeticoes(){
        return repeticoes;
    }

    public float getCarga(){
        return carga;
    }

    public int getTempoDescanso(){
        return tempoDescanso;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setLocal(String local){
        this.local = local;
    }

    public void setSeries(int series){
        this.series = series;
    }

    public void setRepeticoes(int repeticoes){
        this.repeticoes = repeticoes;
    }

    public void setCarga(float carga){
        this.carga = carga;
    }

    public void setTempoDescanso(int tempoDescanso){
        this.tempoDescanso = tempoDescanso;
    }
}
