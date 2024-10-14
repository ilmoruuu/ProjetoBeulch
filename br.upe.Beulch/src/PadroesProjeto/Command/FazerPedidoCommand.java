package PadroesProjeto.Command;

import Aplicacao.Pedido;
import Aplicacao.Cliente;

public class FazerPedidoCommand implements Command{

    private Pedido pedido;
    private Cliente cliente;

    public FazerPedidoCommand(Pedido pedido, Cliente cliente){
        this.pedido = pedido;
        this.cliente = cliente;
    }

    @Override
    public void execute() {

    }
}
