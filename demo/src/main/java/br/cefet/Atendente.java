package br.cefet;

public class Atendente extends Funcionario {
    public Atendente(int matricula, String genero, float salario, String nome, String setor, String dataNascimento, TipoContrato tipoContrato, String status, String dataAdmissao, String ctps){
        super(matricula, genero, salario, nome, setor, dataNascimento, tipoContrato, status, dataAdmissao, ctps);
    }
}
