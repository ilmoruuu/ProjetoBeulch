package Aplicacao.entidades;

import PadroesProjeto.Observer.ClienteObserver;
import PadroesProjeto.Observer.Subject;
import PadroesProjeto.Strategy.Interface.PagamentoStrategy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido implements Subject {

    private List<ClienteObserver> clientes;
    private PagamentoStrategy pagamentoStrategy;
    private double valorPedido;
    private List<Produto> conteudoPedido;
    private String nomeCliente;
    private LocalDateTime dataHoraPedido;
    private boolean confirmado;

    public Pedido(PagamentoStrategy pagamentoStrategy,
                  List<Produto> conteudoPedido, String nomeCliente,
                  LocalDateTime dataHoraPedido) {
        this.clientes = new ArrayList<>();
        this.pagamentoStrategy = pagamentoStrategy;
        this.conteudoPedido = conteudoPedido;
        this.nomeCliente = nomeCliente;
        this.dataHoraPedido = dataHoraPedido;
        calcularPagamento();
        this.confirmado = false;
    }

    @Override
    public void adicionarObservador(ClienteObserver clienteObserver) {
        if (!clientes.contains(clienteObserver)) {
            clientes.add(clienteObserver);
        }
    }

    @Override
    public void removerObservador(ClienteObserver clienteObserver) {
        clientes.remove(clienteObserver);
    }

    @Override
    public void notificar() {
        for (ClienteObserver clienteObserver : clientes) {
            clienteObserver.atualizar(this);
        }
    }

    public void calcularPagamento(){
        double acc = 0;
        for (Produto p : conteudoPedido){
            acc += p.getPrecoAtual();
        }
        this.valorPedido = acc;
    }

    public List<ClienteObserver> getCliente() {
        return clientes;
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public PagamentoStrategy getPagamentoStrategy() {
        return pagamentoStrategy;
    }

    public double getValorPedido() {
        return valorPedido;
    }

    public List<Produto> getConteudoPedido() {
        return conteudoPedido;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public LocalDateTime getDataHoraPedido() {
        return dataHoraPedido;
    }

    public void setPagamentoStrategy(PagamentoStrategy pagamentoStrategy) {
        this.pagamentoStrategy = pagamentoStrategy;
    }

    public void realizarPagamento(float valorSerPago) {
        pagamentoStrategy.realizarPagamento(valorSerPago);
    }
}

