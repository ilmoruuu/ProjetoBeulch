package PadroesProjeto.Command;

import Aplicacao.Pedido;

public abstract class Command {

    protected Pedido pedido;

    public abstract Pedido execute();
}
