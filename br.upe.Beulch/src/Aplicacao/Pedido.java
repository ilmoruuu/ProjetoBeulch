package Aplicacao;

import PadroesProjeto.Strategy.Pagamento.Interface.PagamentoStrategy;

public class Pedido {
    private PagamentoStrategy pagamentoStrategy;

    public void setPagamentoStrategy(PagamentoStrategy pagamentoStrategy) {
        this.pagamentoStrategy = pagamentoStrategy;
    }

    public void realizarPagamento(float valorSerPago) {
        pagamentoStrategy.realizarPagamento(valorSerPago);
    }
}

