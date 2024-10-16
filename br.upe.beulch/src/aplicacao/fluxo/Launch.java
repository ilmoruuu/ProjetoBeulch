package aplicacao.fluxo;

import aplicacao.entidades.Cliente;
import aplicacao.entidades.Pedido;
import padroesProjeto.command.commandInterface.Command;
import padroesProjeto.command.commandImplementacao.FazerPedidoCommand;
import padroesProjeto.command.commandImplementacao.VerHistoricoCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Launch {
    public static void iniciar(){
        Scanner scan  = new Scanner(System.in);
        System.out.println("    ____                   __           __\n" +
                "   / __ )  ___   __  __   / /  _____   / /_\n" +
                "  / __  | / _ \\ / / / /  / /  / ___/  / __ \\\n" +
                " / /_/ / /  __// /_/ /  / /  / /__   / / / /\n" +
                "/_____/  \\___/ \\__,_/  /_/   \\___/  /_/ /_/\n" +
                "\n");

        System.out.println("_____________BEM VINDO______________");
        System.out.print("Digite o seu nome: ");

        String nome = scan.nextLine();

        Cliente cliente = new Cliente(nome);
        Pedido pedido = new Pedido(cliente.getNome());

        List<Pedido> pedidos = new ArrayList<>();

        boolean continuar = true;
        while(continuar){
            System.out.printf("O que você deseja fazer, %s?\n", cliente.getNome());
            System.out.println("Digite:\n[1] Fazer Pedido\n[2] Ver histórico\n[3] sair");
            String escolha = scan.nextLine();

            if (escolha.equals("1")){
                continuar = false;
            }
            else if (escolha.equals("2")) {
                Command fazerPedidoCommand = new FazerPedidoCommand(cliente, pedidos);
                fazerPedidoCommand.execute();
            }
            else if(escolha.equals("3")){
                Command verHistoricoCommand = new VerHistoricoCommand(pedidos);
                verHistoricoCommand.execute();

            } else {
                System.out.println("Opa, não entendi! Você pode digitar válido?\n" +
                        "Usamos apenas números de 1 à 3! ;)");
            }
        }
        System.out.println("Nos vemos depois, até mais!");
    }
}
