package br.cefet;

public interface Repository <Type> {
    void salvar(Type t);
    void apagar(Type t);
    void alterar(Type t);
    List<Type> buscar();
}
