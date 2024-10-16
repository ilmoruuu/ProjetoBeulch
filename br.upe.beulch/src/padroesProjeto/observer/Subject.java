package padroesProjeto.observer;

public interface Subject {

    public void adicionarObservador(ClienteObserver clienteObserver);
    public void removerObservador(ClienteObserver clienteObserver);
    public void notificar();

}
