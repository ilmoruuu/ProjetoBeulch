package Aplicacao;

import PadroesProjeto.FactoryMethod.Produto;
import PadroesProjeto.Observer.ClienteObserver;
import PadroesProjeto.Strategy.PagamentoStrategy;

import java.time.LocalDateTime;
import java.util.List;

public class Pedido {

    private List<ClienteObserver> clientes;
    private PagamentoStrategy pagamentoStrategy;
    private double ValorPedido;
    private List<PadroesProjeto.FactoryMethod.Produto> conteudoPedido;
    private String nomeCliente;
    private String cpf;
    private LocalDateTime dataHoraPedido;

    public Pedido(List<ClienteObserver> clientes, PagamentoStrategy pagamentoStrategy,
                  double valorPedido, List<Produto> conteudoPedido, String nomeCliente,
                  String cpf, LocalDateTime dataHoraPedido) {
        this.clientes = clientes;
        this.pagamentoStrategy = pagamentoStrategy;
        this.ValorPedido = valorPedido;
        this.conteudoPedido = conteudoPedido;
        this.nomeCliente = nomeCliente;
        this.cpf = cpf;
        this.dataHoraPedido = dataHoraPedido;
    }

    // Geters e Seters de cada um desses atributos

    public void setPagamentoStrategy(PagamentoStrategy pagamentoStrategy) {
        this.pagamentoStrategy = pagamentoStrategy;
    }

    public void realizarPagamento(float valorSerPago) {
        pagamentoStrategy.realizarPagamento(valorSerPago);
    }
}

