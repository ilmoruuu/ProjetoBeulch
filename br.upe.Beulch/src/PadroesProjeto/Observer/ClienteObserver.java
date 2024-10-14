package PadroesProjeto.Observer;

import PadroesProjeto.Strategy.Pedido;

public interface ClienteObserver {

    public void atualizar(Produto produto);
    public void atualizar(Pedido pedido);
}
