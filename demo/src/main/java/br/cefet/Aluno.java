package br.cefet;

public class Aluno extends Pessoa{
    private Assinatura assinatura;
    
    
    // private String endereco; // vai pra endereco
   
    //private float peso; // vai pra avaliacao
    //private float altura; // vai pra avaliacao
    //private String email; // vai pra contato
    // private float imc; // vai pra avaliacao
    // private Plano plano; // vai pra assinatura

    public Aluno(String nome, int matricula, String cpf, String dataNascimento, String genero){
        super(nome, matricula, cpf, dataNascimento, genero);
    }

    public Assinatura getAssinatura() {
        return assinatura;
    }
    
}
