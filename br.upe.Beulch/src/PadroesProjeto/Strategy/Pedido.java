package PadroesProjeto.Strategy;

public class Pedido {
    private PagamentoStrategy pagamentoStrategy;

    public void setPagamentoStrategy(PagamentoStrategy pagamentoStrategy) {
        this.pagamentoStrategy = pagamentoStrategy;
    }

    public void realizarPagamento(float valor) {
        pagamentoStrategy.realizarPagamento(valor);
    }
}
