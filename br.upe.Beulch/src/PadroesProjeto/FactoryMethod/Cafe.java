package PadroesProjeto.FactoryMethod;

import Aplicacao.Produto;
import PadroesProjeto.Observer.ClienteObserver;

import java.util.ArrayList;
import java.util.List;

public class Cafe implements Produto {

    private String nome;
    private float precoAtual;
    private float precoAnterior;
    private boolean disponivel;
    private List<ClienteObserver> clienteObservers;

    public Cafe(String nome, float precoAtual) {
        this.nome = nome;
        this.precoAtual = precoAtual;
        this.clienteObservers = new ArrayList<>();
        this.disponivel = true;
        this.precoAnterior = precoAtual;
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
        this.precoAnterior = precoAtual;
        precoAtual = novoPreco;
    }

    public float getPrecoAnterior() {
        return precoAnterior;
    }

    public void setPrecoAnterior(float precoAnterior) {
        this.precoAnterior = precoAnterior;
    }

    @Override
    public boolean isDisponivel() {
        return disponivel;
    }

    @Override
    public void setDisponibilidade(boolean disponivel) {
        if(!(this.disponivel == disponivel)){
            this.disponivel = disponivel;
            notificar();
        }
    }

    @Override
    public void setPrecoProduto(float valor) {
        if(!(this.precoAtual == valor)){
            precoAnterior = precoAtual;
            precoAtual = valor;
            notificar();
        }
    }

}
