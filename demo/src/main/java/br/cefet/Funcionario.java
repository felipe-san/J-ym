package br.cefet;
public class Funcionario extends Pessoa {
    private float salario;
    private String setor;
    private TipoContrato tipoContrato;
    private String status;
    private String dataAdmissao;  
    private String ctps;

    public Funcionario(int matricula, String genero, float salario, String nome, String setor, String dataNascimento, TipoContrato tipoContrato, String status, String dataAdmissao, String ctps){
        super(nome, matricula, dataNascimento, genero);
        setCtps(ctps);
        setDataAdmissao(dataAdmissao);
        setDataNascimento(dataNascimento);
        setMatricula(matricula);
        setSalario(salario);
        setSetor(setor);
        setStatus(status);
        setTipoContrato(tipoContrato);
    }
    
    public String getDataAdmissao(){
        return dataAdmissao;
    }

    public String getStatus(){
        return status;
    }

    public TipoContrato getTipoContrato(){
        return tipoContrato;
    }

    public String getSetor() {
        return setor;
    }

    public String getCtps() {
        return ctps;
    }

    public float getSalario(){
        return salario;
    } 

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }
    
    public void setDataAdmissao(String dataAdmissao){
        this.dataAdmissao = dataAdmissao;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTipoContrato(TipoContrato tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

}



