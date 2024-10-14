package Aplicacao;

import PadroesProjeto.Strategy.Pagamento.Interface.PagamentoStrategy;

import PadroesProjeto.Observer.Notificacao.Interface.ClienteObserver;
import PadroesProjeto.Observer.Notificacao.Interface.Subject;

import java.util.ArrayList;
import java.util.List;

public class Pedido implements Subject {

    private PagamentoStrategy pagamentoStrategy;
    private boolean confirmado;
    private List<ClienteObserver> clienteObservers;

    public Pedido() {
        this.clienteObservers = new ArrayList<>();
        this.confirmado = false;
    }


    public void setPagamentoStrategy(PagamentoStrategy pagamentoStrategy) {
        this.pagamentoStrategy = pagamentoStrategy;
    }

    public void realizarPagamento(float valorSerPago) {
        pagamentoStrategy.realizarPagamento(valorSerPago);
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

    public void setConfirmado(boolean confirmado) {
        if(this.confirmado != confirmado) {
            this.confirmado = confirmado;
            notificar();
        }
    }

    public boolean isConfirmado() {
        return confirmado;
    }

}