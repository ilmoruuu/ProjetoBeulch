package PadroesProjeto.Command;

import Aplicacao.entidades.Pedido;
import Aplicacao.entidades.Cliente;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

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
        Scanner sc = new Scanner(System.in);
        System.out.println("Você deseja um café, um bolo ou um livro?");
        System.out.println("""
                [1] para café
                [2] para bolo
                [3] para livro
                """);
    }
}
