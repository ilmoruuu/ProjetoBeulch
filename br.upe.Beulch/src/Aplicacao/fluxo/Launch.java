package Aplicacao.fluxo;

import Aplicacao.entidades.Cliente;
import Aplicacao.entidades.Pedido;
import Aplicacao.entidades.Produto;
import PadroesProjeto.Command.Command;
import PadroesProjeto.Command.FazerPedidoCommand;
import PadroesProjeto.Command.VerHistoricoCommand;
import PadroesProjeto.FactoryMethod.Cafe;
import PadroesProjeto.FactoryMethod.FactoryCafe;
import PadroesProjeto.Strategy.Implementacao.Pix;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Launch {
    
    public static void iniciar(){
        Scanner scan  = new Scanner(System.in);
        System.out.println("_____________BEM_VINDO______________");
        System.out.print("Digite o seu nome: ");

        String nome = scan.nextLine();

        Cliente cliente = new Cliente(nome);
        Pedido pedido = new Pedido(cliente.getNome());

        List<Pedido> pedidos = new ArrayList<>();

        boolean continuar = true;
        while(continuar){
            System.out.printf("O que você deseja fazer, %s?\n", cliente.getNome());
            System.out.println("Digite:\n[1] Fazer Pedido\n[2] Ver histórico\n[3] sair");
            int escolha = scan.nextInt();
            if (escolha == 3){
                continuar = false;
            }
            else if (escolha == 1) {
                Command fazerPedidoCommand = new FazerPedidoCommand(cliente, pedidos);
                fazerPedidoCommand.execute();
            }
            else if(escolha == 2){
                Command verHistoricoCommand = new VerHistoricoCommand(pedidos);
                verHistoricoCommand.execute();
            }
        }
        System.out.println("Nos vemos depois, até mais!");
    }
}
