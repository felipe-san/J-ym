package br.cefet;
public class Funcionario {
    private int matricula;
    private boolean disponivel;
    private float salario;
    private String nome;
    private String cargo;
    private String setor;
    private String dataNascimento;
    private String tipoContrato;
    private String status;
    private String dataAdmissao;
    private String cpf;
    private String endereco;    
    private String ctps;
    private String email;
    private String telefone;

    public Funcionario(int matricula, boolean disponivel, float salario, String nome, String cargo, String setor, String dataNascimento, String tipoContrato, String status, String dataAdmissao, String cpf, String endereco, String ctps, String email, String telefone){
        setCargo(cargo);
        setCpf(cpf);
        setCtps(ctps);
        setDataAdmissao(dataAdmissao);
        setDataNascimento(dataNascimento);
        setDisponivel(disponivel);
        setEmail(email);
        setEndereco(endereco);
        setMatricula(matricula);
        setNome(nome);
        setSalario(salario);
        setSetor(setor);
        setStatus(status);
        setTelefone(telefone);
        setTipoContrato(tipoContrato);
    }
    
    public String getNome(){
        return nome; 
    }
    
    public String getDataAdmissao(){
        return dataAdmissao;
    }

    public boolean isDisponivel(){
        return disponivel;
    }

    public String getCargo(){
        return cargo;
    }

    public String getStatus(){
        return status;
    }

    public String getCpf(){
        return cpf; 
    }
    
    public String getEndereco(){
        return endereco; 
    }
    
    public String getTipoContrato(){
        return tipoContrato;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }
    
    public String getSetor() {
        return setor;
    }

    public String getCtps() {
        return ctps;
    }

    public int getMatricula() {
        return matricula;
    }

    public float getSalario(){
        return salario;
    } 

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }
    
    public void setDataAdmissao(String dataAdmissao){
        this.dataAdmissao = dataAdmissao;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPeso(String ctps) {
        this.ctps = ctps;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}



