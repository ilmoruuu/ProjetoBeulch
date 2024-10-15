package Aplicacao;

import Aplicacao.entidades.Cliente;
import Aplicacao.entidades.Pedido;
import Aplicacao.entidades.Produto;
import PadroesProjeto.Command.Command;
import PadroesProjeto.Command.FazerPedidoCommand;
import PadroesProjeto.Command.VerHistoricoCommand;
import PadroesProjeto.FactoryMethod.FactoryBolo;
import PadroesProjeto.FactoryMethod.FactoryCafe;
import PadroesProjeto.Strategy.Implementacao.Pix;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        LocalDateTime data = LocalDateTime.now();
        FactoryCafe factoryCafe = new FactoryCafe();
        FactoryBolo factoryBolo = new FactoryBolo();
        Produto bolo = factoryBolo.criarProduto("bolo");
        Produto cafe = factoryCafe.criarProduto("cafe");

        Cliente cliente = new Cliente("Pedro", "Pedro@gmail.com", "123");

        /* O pedido deve vir tanto com o pagamentoStrategy quanto
         com o conteudoPedido nulos, para que o execute() da classe
         Command faça as atribuições */
//        Pedido pedido = new Pedido(new Pix("p","a", 20),
//                Arrays.asList(cafe), "Pedro", data);
//        pedido.setValorPedido(20);
//
//        Pedido pedido2 = new Pedido(new Pix("eu","a", 12),
//                Arrays.asList(bolo), "Pedro", data);
//        pedido2.setValorPedido(12);

        Pedido pedido = new Pedido(null, null, "Pedro", null);

        //List<Pedido> pedidos = Arrays.asList(pedido, pedido2);

        Command command = new FazerPedidoCommand(pedido, cliente);
        command.execute();

        // Pedido pedido = new Pedido
        // pedido.
    }

}