package padroesProjeto.factoryMethod.produtos;

import aplicacao.entidades.Produto;
import padroesProjeto.observer.ClienteObserver;

import java.util.ArrayList;
import java.util.List;

public class Cafe implements Produto {

    private String nome;
    private float precoAtual = 3;
    private boolean disponivel;
    private List<ClienteObserver> clienteObservers;

    public Cafe(String nome) {
        this.nome = nome;
        this.clienteObservers = new ArrayList<>();
        this.disponivel = true;
    }

    @Override
    public void adicionarObservador(ClienteObserver clienteObserver) {
        if (!clienteObservers.contains(clienteObserver)) {
            clienteObservers.add(clienteObserver);
        }
    }

    @Override
    public void removerObservador(ClienteObserver clienteObserver) {
        clienteObservers.remove(clienteObserver);
    }

    @Override
    public void notificar() {
        for (ClienteObserver clienteObserver : clienteObservers) {
            clienteObserver.atualizar(this);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPrecoAtual() {
        return precoAtual;
    }

    public void setPrecoAtual(float novoPreco) {
        this.precoAtual = novoPreco;
    }

    @Override
    public boolean isDisponivel() {
        return disponivel;
    }

    @Override
    public void setDisponibilidade(boolean disponivel) {
        if(!this.disponivel == disponivel){
            this.disponivel = disponivel;
        }
    }

    @Override
    public String toString(){
        return "Café";
    }

    public List<ClienteObserver> getClienteObservers() {
        return clienteObservers;
    }
}
