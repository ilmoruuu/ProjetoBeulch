package PadroesProjeto.Observer;

import Aplicacao.Pedido;

public interface ClienteObserver {

    public void atualizar(ProdutoObserver produto);
    public void atualizar(Pedido pedido);
}
