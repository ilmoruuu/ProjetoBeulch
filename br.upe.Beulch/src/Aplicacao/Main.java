package Aplicacao;

import Aplicacao.entidades.Cliente;
import Aplicacao.entidades.Pedido;
import Aplicacao.entidades.Produto;
import PadroesProjeto.Command.Command;
import PadroesProjeto.Command.FazerPedidoCommand;
import PadroesProjeto.FactoryMethod.FactoryCafe;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        LocalDateTime data = LocalDateTime.now();
        FactoryCafe factoryCafe = new FactoryCafe();
        Produto cafe = factoryCafe.criarProduto("cafe");

        Cliente cliente = new Cliente("Pedro", "Pedro@gmail.com", "123");

        /* O pedido deve vir tanto com o pagamentoStrategy quanto
         com o conteudoPedido nulos, para que o execute() da classe
         Command faça as atribuições */
        Pedido pedido = new Pedido(null,
                null, "Pedro", data);


        Command command = new FazerPedidoCommand(pedido, cliente);
        command.execute();

        // Pedido pedido = new Pedido
        // pedido.
    }

}