package br.cefet;

import java.util.List;
import java.util.ArrayList;

/**
 * Represents a student with a subscription and evaluations.
 * Inherits basic personal information from the Pessoa class.
 * @author Your Name
 */
public class Aluno extends Pessoa{
    private Assinatura assinatura;
    private List<Avaliacao> avaliacoes;  

    /**
     * Constructs a new Aluno (Student) with basic personal information.
     * Initializes an empty list of evaluations.
     * 
     * @param nome The student's name
     * @param matricula The student's registration number
     * @param dataNascimento The student's birth date (format DD/MM/YYYY)
     * @param genero The student's gender
     */
    public Aluno(String nome, int matricula, String dataNascimento, String genero){
        super(nome, matricula, dataNascimento, genero);
        avaliacoes = new ArrayList<>();
    }

    /**
     * Gets the student's subscription information
     * @return The Assinatura object associated with this student
     */
    public Assinatura getAssinatura(){
        return assinatura;
    }
    
    /**
     * Sets/Updates the student's subscription information
     * @param assinatura The Assinatura object to associate with this student
     */
    public void setAssinatura(Assinatura assinatura){
        this.assinatura = assinatura;        
    }

    /**
     * Adds a new evaluation to the student's evaluation list
     * @param avaliacao The Avaliacao object to add to the student's evaluations
     */
    public void addAvaliacao(Avaliacao avaliacao){
        this.avaliacoes.add(avaliacao);
    }
}