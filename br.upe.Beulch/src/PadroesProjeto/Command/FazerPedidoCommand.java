package PadroesProjeto.Command;

import Aplicacao.entidades.Pedido;
import Aplicacao.entidades.Cliente;

import javax.sound.midi.Soundbank;

public class FazerPedidoCommand implements Command{

    private Pedido pedido;
    private Cliente cliente;

    public FazerPedidoCommand(Pedido pedido, Cliente cliente){
        this.pedido = pedido;
        this.cliente = cliente;
    }

    /*
    * A Launch vai instanciar a classe FazerPedidoCommand com um Pedido e um
    * Cliente. Através dessa classe, o pedido vai ser feito.
    *  */
    @Override
    public void execute() {
        System.out.println("O que você deseja fazer?");
        System.out.println("[1] Fazer pedido");
        System.out.println("[2] Olhar histórico");
    }
}
