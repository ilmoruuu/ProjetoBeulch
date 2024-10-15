package PadroesProjeto.Observer;

import Aplicacao.entidades.Pedido;
import Aplicacao.entidades.Produto;

public interface ClienteObserver {

    public void atualizar(Produto produto);
    public void atualizar(Pedido pedido);
}
