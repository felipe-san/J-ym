package br.cefet;

public class Avaliacao {
    private float peso;
    private float altura;
    private float medidaCintura;
    private float medidaQuadril;
    private float medidaBicepsDireito;
    private float medidaBicepsEsquerdo;
    private float medidaTricepsDireito;
    private float medidaTricepsEsquerdo;
    private float medidaCoxaDireita;
    private float medidaCoxaEsquerda;
    private float medidaPanturrilhaDireita;
    private float medidaPanturrilhaEsquerda;
    private float medidaOmbroAOmbro;
    private float gorduraCorporal;
    private float massaMuscular;
    private float massaMagra;
    private String pressao;
    private float imc;
    private boolean doenteCronico;
    private boolean lesionado;
    private boolean usuarioMedicamento;
    private String objetivo;
    private boolean doresFadiga;

    public Avaliacao(float peso, float altura, float medidaCintura, float medidaQuadril, float medidaBicepsDireito, float medidaBicepsEsquerdo, float medidaTricepsDireito, float medidaTricepsEsquerdo, float medidaCoxaDireita, float medidaCoxaEsquerda, float medidaPanturrilhaDireita, float medidaPanturrilhaEsquerda, float medidaOmbroAOmbro, float gorduraCorporal, float massaMuscular, float massaMagra, boolean doenteCronico, boolean lesionado, boolean usuarioMedicamento, String objetivo, boolean doresFadiga){
        setAltura(altura);
        setDoenteCronico(doenteCronico);
        setDoresFadiga(doresFadiga);
        setLesionado(lesionado);
        setUsuarioMedicamento(usuarioMedicamento);
        setGorduraCorporal(gorduraCorporal);
        setPeso(peso);
        setImc();
        setMassaMagra(massaMagra);
        setMassaMuscular(massaMuscular);
        setMedidaBicepsDireito(medidaBicepsDireito);
        setMedidaBicepsEsquerdo(medidaBicepsEsquerdo);
        setMedidaCintura(medidaCintura);
        setMedidaCoxaDireita(medidaCoxaDireita);
        setMedidaCoxaEsquerda(medidaCoxaEsquerda);
        setMedidaOmbroAOmbro(medidaOmbroAOmbro);
        setMedidaPanturrilhaDireita(medidaPanturrilhaDireita);
        setMedidaPanturrilhaEsquerda(medidaPanturrilhaEsquerda);
        setMedidaQuadril(medidaQuadril);
        setMedidaTricepsDireito(medidaTricepsDireito);
        setMedidaTricepsEsquerdo(medidaTricepsEsquerdo);
        setObjetivo(objetivo);
        setPressao(pressao);
    }
    
    public float getAltura() {
        return altura;
    }

    public float getGorduraCorporal() {
        return gorduraCorporal;
    }

    public float getImc() {
        return imc;
    }

    public boolean isUsuarioMedicamento() {
        return usuarioMedicamento;
    }

    public float getMassaMagra() {
        return massaMagra;
    }

    public float getMassaMuscular() {
        return massaMuscular;
    }

    public float getMedidaBicepsDireito() {
        return medidaBicepsDireito;
    }

    public float getMedidaBicepsEsquerdo() {
        return medidaBicepsEsquerdo;
    }

    public float getMedidaCintura() {
        return medidaCintura;
    }

    public float getMedidaCoxaDireita() {
        return medidaCoxaDireita;
    }

    public float getMedidaCoxaEsquerda() {
        return medidaCoxaEsquerda;
    }

    public float getMedidaOmbroAOmbro() {
        return medidaOmbroAOmbro;
    }

    public float getMedidaPanturrilhaDireita() {
        return medidaPanturrilhaDireita;
    }

    public float getMedidaPanturrilhaEsquerda() {
        return medidaPanturrilhaEsquerda;
    }

    public float getMedidaQuadril() {
        return medidaQuadril;
    }

    public float getMedidaTricepsDireito() {
        return medidaTricepsDireito;
    }

    public float getMedidaTricepsEsquerdo() {
        return medidaTricepsEsquerdo;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public float getPeso() {
        return peso;
    }

    public String getPressao() {
        return pressao;
    }

    public boolean isDoenteCronico() {
        return doenteCronico;
    }

    public boolean isDoresFadiga() {
        return doresFadiga;
    }

    public boolean isLesionado() {
        return lesionado;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setMassaMagra(float massaMagra) {
        this.massaMagra = massaMagra;
    }

    public void setMassaMuscular(float massaMuscular) {
        this.massaMuscular = massaMuscular;
    }

    public void setImc() {
        this.imc = peso / (altura * altura);
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public void setPressao(String pressao) {
        this.pressao = pressao;
    }

    public void setGorduraCorporal(float gorduraCorporal) {
        this.gorduraCorporal = gorduraCorporal;
    }

    public void setMedidaBicepsDireito(float medidaBicepsDireito) {
        this.medidaBicepsDireito = medidaBicepsDireito;
    }

    public void setMedidaBicepsEsquerdo(float medidaBicepsEsquerdo) {
        this.medidaBicepsEsquerdo = medidaBicepsEsquerdo;
    }

    public void setMedidaCintura(float medidaCintura) {
        this.medidaCintura = medidaCintura;
    }

    public void setMedidaCoxaDireita(float medidaCoxaDireita) {
        this.medidaCoxaDireita = medidaCoxaDireita;
    }

    public void setMedidaCoxaEsquerda(float medidaCoxaEsquerda) {
        this.medidaCoxaEsquerda = medidaCoxaEsquerda;
    }

    public void setMedidaOmbroAOmbro(float medidaOmbroAOmbro) {
        this.medidaOmbroAOmbro = medidaOmbroAOmbro;
    }

    public void setMedidaPanturrilhaDireita(float medidaPanturrilhaDireita) {
        this.medidaPanturrilhaDireita = medidaPanturrilhaDireita;
    }

    public void setMedidaPanturrilhaEsquerda(float medidaPanturrilhaEsquerda) {
        this.medidaPanturrilhaEsquerda = medidaPanturrilhaEsquerda;
    }

    public void setMedidaQuadril(float medidaQuadril) {
        this.medidaQuadril = medidaQuadril;
    }

    public void setMedidaTricepsDireito(float medidaTricepsDireito) {
        this.medidaTricepsDireito = medidaTricepsDireito;
    }

    public void setMedidaTricepsEsquerdo(float medidaTricepsEsquerdo) {
        this.medidaTricepsEsquerdo = medidaTricepsEsquerdo;
    }

    public void setUsuarioMedicamento(boolean usuarioMedicamento) {
        this.usuarioMedicamento = usuarioMedicamento;
    }

    public void setLesionado(boolean lesionado) {
        this.lesionado = lesionado;
    }

    public void setDoenteCronico(boolean doenteCronico) {
        this.doenteCronico = doenteCronico;
    }

    public void setDoresFadiga(boolean doresFadiga) {
        this.doresFadiga = doresFadiga;
    }

}
