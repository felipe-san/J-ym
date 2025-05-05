package br.cefet;

public class Treinador extends Funcionario {
    private boolean disponivel;
    private String cref;

    public Treinador(int matricula, String cref, boolean disponivel, String genero, float salario, String nome, String setor, String dataNascimento, tipoContrato tipoContrato, String status, String dataAdmissao, String ctps){
        super(matricula, genero, salario, nome, setor, dataNascimento, tipoContrato, status, dataAdmissao, ctps);
        setCref(cref);
        setDisponivel(disponivel);
    }

    public boolean isDisponivel(){
        return disponivel;
    }

    public String getCref(){
        return cref;
    }

    public void setCref(String cref){
        this.cref = cref;
    }

    public void setDisponivel(boolean disponivel){
        this.disponivel = disponivel;
    }
}
