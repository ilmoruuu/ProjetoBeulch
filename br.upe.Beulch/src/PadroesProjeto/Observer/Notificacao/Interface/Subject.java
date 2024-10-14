package PadroesProjeto.Observer.Notificacao.Interface;

public interface Subject {

    public void adicionarObservador(ClienteObserver clienteObserver);
    public void removerObservador(ClienteObserver clienteObserver);
    public void notificar();

}
