package PadroesProjeto.Observer;

import Aplicacao.Pedido;
import Aplicacao.Produto;

public interface ClienteObserver {

    public void atualizar(Produto produto);
    public void atualizar(Pedido pedido);
}
