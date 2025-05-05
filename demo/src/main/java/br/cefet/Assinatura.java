package br.cefet;

public class Assinatura {
    private Plano plano;
    private String dataInicioContrato;
    private String dataFimContrato;
    private Aluno aluno;

    public Assinatura(Aluno aluno, String dataInicioContrato, String dataFimContrato, Plano plano){
        setAluno(aluno);
        setDataFimContrato(dataFimContrato);
        setDataInicioContrato(dataInicioContrato);
        setPlano(plano);
    }

    public String getDataInicioContrato() {
        return dataInicioContrato;
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

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }
}
