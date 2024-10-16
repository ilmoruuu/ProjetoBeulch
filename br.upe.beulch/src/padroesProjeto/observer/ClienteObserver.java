package padroesProjeto.observer;

import aplicacao.entidades.Pedido;
import aplicacao.entidades.Produto;

public interface ClienteObserver {

    public void atualizar(Produto produto);
    public void atualizar(Pedido pedido);
}
