package br.cefet;
public class Aluno {
    private String nome;
    private String cpf;
    private String endereco;
    private int matricula;
    private String dataNascimento;
    private String genero;
    private float peso;
    private float altura;
    private String email;
    private String telefone;
    private float imc;
    private Plano plano;

    public Aluno(String nome, int matricula, String dataNascimento){
        setNome(nome);
        
    }

    public Plano getPlano(){
        return plano;
    }

    public String getNome(){
        return nome; 
    }
    
    public String getCpf(){
        return cpf; 
    }
    
    public String getEndereco(){
        return endereco; 
    }
    
    public int getMatricula(){
        return matricula; 
    }
    
    public String getDataNascimento() {
        return dataNascimento;
    }
    
    public String getGenero() {
        return genero;
    }

    public String getEmail() {
        return email;
    }

    public float getPeso() {
        return peso;
    }

    public float getAltura() {
        return altura;
    }

    public String getTelefone() {
        return telefone;
    }

    public float getImc() {
        return imc;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPlano(Plano plano){
        if (this.plano != plano){
            plano.addAluno(this);
        }
        this.plano = plano;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setImc() {
        imc = this.peso / (this.altura * this.altura);
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void cadastro(){
        //sda 
    }

    public void CriarFichaTreino(){
        //
    }
}
