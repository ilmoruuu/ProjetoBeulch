package Aplicacao;

import PadroesProjeto.Observer.Notificacao.Interface.ClienteObserver;
import PadroesProjeto.Observer.Notificacao.Interface.Subject;

import java.util.ArrayList;
import java.util.List;

public class Produto implements Subject {

    private String nome;
    private boolean disponivel;
    private Float precoAtual;
    private Float precoAnterior;
    private List<ClienteObserver> clienteObservers;


    public Produto(String nome, Float precoAtual) {
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

    public void setDisponibilidade(boolean disponivel) {
        if (this.disponivel != disponivel) {
            this.disponivel = disponivel;
            notificar();
        }
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getPrecoAtual() {
        return precoAtual;
    }

    public Float getPrecoAnterior() {
        return precoAnterior;
    }

    public void setPrecoProduto(Float novoPreco) {
        if (!this.precoAtual.equals(novoPreco)) {
            this.precoAnterior = this.precoAtual;
            this.precoAtual = novoPreco;
            notificar();
        }
    }

}
