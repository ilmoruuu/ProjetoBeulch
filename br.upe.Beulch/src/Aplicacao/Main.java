package Aplicacao;

import PadroesProjeto.FactoryMethod.FactoryCafe;
import PadroesProjeto.FactoryMethod.Produto;

public class Main {
    public static void main(String[] args) {
//        Pedido novoPedido = new Pedido();
//        novoPedido.setPagamentoStrategy(new Pix("Murilo","Nubank Pagamentos S.A",45));
//        novoPedido.realizarPagamento(45);

        FactoryCafe factoryCafe = new FactoryCafe();
        Produto cafe = factoryCafe.criarProduto("Expresso", "2.50");
        System.out.println(cafe);
    }
}