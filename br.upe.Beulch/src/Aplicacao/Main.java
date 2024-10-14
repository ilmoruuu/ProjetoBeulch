package Aplicacao;

import PadroesProjeto.FactoryMethod.Produto;
import PadroesProjeto.Observer.Cliente;
import PadroesProjeto.Observer.ProdutoObserver;
import PadroesProjeto.FactoryMethod.FactoryCafe;
import PadroesProjeto.Strategy.Pagamento.Implementacao.Pix;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("João", "joao@email.com", "123");
        Cliente cliente2 = new Cliente("Pedro", "pedro@email.com", "456");

        ProdutoObserver produto1 = new ProdutoObserver("café", 3f);
        Pedido pedido = new Pedido();

        produto1.adicionarObservador(cliente1);

        produto1.setDisponibilidade(true);
        produto1.setPrecoProduto(30f);
        produto1.setDisponibilidade(false);
        produto1.setDisponibilidade(true);


        Pedido novoPedido = new Pedido();
        novoPedido.setPagamentoStrategy(new Pix("Murilo","Nubank Pagamentos S.A",45));
        novoPedido.realizarPagamento(45);

        FactoryCafe factoryCafe = new FactoryCafe();
        Produto cafe = factoryCafe.criarProduto("Expresso", "2.50");
        System.out.println(cafe);


    }
}