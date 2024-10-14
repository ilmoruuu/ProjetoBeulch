package Aplicacao;

import PadroesProjeto.Observer.Cliente;
import PadroesProjeto.Observer.Produto;
import PadroesProjeto.Strategy.Pedido;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("João", "joao@email.com", "123");
        Cliente cliente2 = new Cliente("Pedro", "pedro@email.com", "456");

        Produto produto1 = new Produto("café", 3f);
        Produto produto2 = new Produto("livro", 25f);

        // Clientes observam os produtos
        produto1.adicionarObservador(cliente1);

        produto1.setDisponibilidade(true);  // Nenhuma saída, pois a disponibilidade não mudou
        produto1.setPrecoProduto(3300f);   // Saída: "O preço do produto Notebook mudou!"
        produto1.setPrecoProduto(3300f);   // Nenhuma saída, pois o preço permanece o mesmo
        produto1.setDisponibilidade(false); // Saída: "O produto Notebook está indisponível no momento."
        produto1.setDisponibilidade(false);


    }
}