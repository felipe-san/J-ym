package br.cefet.model;

public class Assinatura {
    private Plano plano;
    private String dataInicioContrato;
    private String dataFimContrato;
    private Aluno aluno;
    private Treinador treinador;

    public Assinatura(Aluno aluno, Treinador treinador, String dataInicioContrato, String dataFimContrato, Plano plano){
        setAluno(aluno);
        setDataFimContrato(dataFimContrato);
        setDataInicioContrato(dataInicioContrato);
        setPlano(plano);
        setTreinador(treinador);
    }

    public String getDataInicioContrato() {
        return dataInicioContrato;
    }

    public Treinador getTreinador() {
        return treinador;
    }

    public String getDataFimContrato() {
        return dataFimContrato;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setDataInicioContrato(String dataInicioContrato) {
        this.dataInicioContrato = dataInicioContrato;
    }

    public void setDataFimContrato(String dataFimContrato) {
        this.dataFimContrato = dataFimContrato;
    }

    public void setTreinador(Treinador treinador) {
        this.treinador = treinador;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }
}
