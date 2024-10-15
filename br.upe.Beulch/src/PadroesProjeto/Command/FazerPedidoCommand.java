package PadroesProjeto.Command;

import Aplicacao.entidades.Pedido;
import Aplicacao.entidades.Cliente;
import Aplicacao.entidades.Produto;
import PadroesProjeto.FactoryMethod.Factory;
import PadroesProjeto.FactoryMethod.FactoryBolo;
import PadroesProjeto.FactoryMethod.FactoryCafe;
import PadroesProjeto.FactoryMethod.FactoryLivro;
import PadroesProjeto.Strategy.Enum.TipoCartao;
import PadroesProjeto.Strategy.Implementacao.Cartao;
import PadroesProjeto.Strategy.Implementacao.Especie;
import PadroesProjeto.Strategy.Implementacao.Pix;
import PadroesProjeto.Strategy.Interface.PagamentoStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FazerPedidoCommand implements Command{

    private Cliente cliente;
    List<Pedido> pedidos;

    public FazerPedidoCommand(Cliente cliente, List<Pedido> pedidos) {
        this.cliente = cliente;
        this.pedidos = pedidos;
    }

    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        Factory factory = null;
        List<Produto> produtos = new ArrayList<>();
        Pedido pedido = new Pedido(cliente.getNome());

        char continuar = 's';

        while (continuar == 's' || continuar == 'S') {
            System.out.println("Você deseja um café, um bolo ou um livro?");
            System.out.println("[1] para café\n[2] para bolo\n[3] para livro");

            int escolha = sc.nextInt();

            switch (escolha) {
                case 1:
                    factory = new FactoryCafe();
                    produtos.add(factory.criarProduto("Café"));
                    break;
                case 2:
                    factory = new FactoryBolo();
                    produtos.add(factory.criarProduto("Bolo"));
                    break;
                case 3:
                    factory = new FactoryLivro();
                    produtos.add(factory.criarProduto("Livro"));
                    break;
            }

            System.out.println("Você deseja mais algum item?");
            System.out.println("Digite:\n[s] para sim\n[n] para não");
            continuar = sc.next().charAt(0);
            System.out.println("_________________________________________");
        }

        System.out.println("Qual será a forma de pagamento?");
        System.out.println("Digite:\n[1] para pix\n[2] para cartão\n[3] para espécie");

        int formaDePagamento = sc.nextInt();
        PagamentoStrategy forma = null;

        pedido.setConteudoPedido(produtos);
        float soma = pedido.calcularPagamento();
        pedido.setValorPedido(soma);

        switch (formaDePagamento){
            case 1:
                System.out.println("Digite o nome do seu banco");
                String banco = sc.next();
                forma = new Pix(cliente.getNome(), banco, soma);
                pedido.setPagamentoStrategy(forma);
                forma.realizarPagamento(soma);
                break;
            case 2:
                System.out.println("Digite o número do seu cartão, validade e seu CVV");
                String numeroCartao = sc.next();
                String validade = sc.next();
                String cvv = sc.next();

                System.out.println("O cartão é de crédito ou de débito?");
                System.out.println("Digite:\n[1] para cartão de crédito\n[2] para cartão de débito");
                int escolhaCartao = sc.nextInt();

                if (escolhaCartao == 1){
                    System.out.print("Digite a quantidade de parcelas: ");
                    int parcelas = sc.nextInt();

                    forma = new Cartao(numeroCartao, cliente.getNome(), validade,
                            cvv, soma, TipoCartao.CREDITO, parcelas);
                }
                else {
                    forma = new Cartao(numeroCartao, cliente.getNome(), validade,
                            cvv, soma, TipoCartao.DEBITO, 1);
                }
                pedido.setPagamentoStrategy(forma);
                forma.realizarPagamento(soma);
                break;
            case 3:
                forma = new Especie(cliente.getNome(), soma);
                pedido.setPagamentoStrategy(forma);
                forma.realizarPagamento(soma);
                break;
        }
        pedidos.add(pedido);

        pedido.adicionarObservador(cliente);
        pedido.notificar();
        System.out.println();
    }
}
