package Aplicacao.fluxo;

import Aplicacao.entidades.Cliente;
import Aplicacao.entidades.Pedido;
import PadroesProjeto.Command.Command;
import PadroesProjeto.Command.FazerPedidoCommand;

import java.util.Scanner;

public class Launch {

    public void iniciar(){

        Cliente cliente = new Cliente("null","null", "null");
        Pedido pedido = new Pedido();

        Command fazerPedidoCommand = new FazerPedidoCommand(pedido, cliente);

        Scanner scan  = new Scanner(System.in);
        System.out.println("_____________BEM_VINDO______________");
        System.out.println("Digite o seu nome: ");
        String nome = scan.nextLine();
        cliente.setNome(nome);
        pedido.adicionarObservador(cliente);

        fazerPedidoCommand.execute();
    }
}
