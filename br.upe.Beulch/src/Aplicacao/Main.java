package Aplicacao;

import PadroesProjeto.FactoryMethod.*;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("João", "joao@email.com", "123");
        Cliente cliente2 = new Cliente("Pedro", "pedro@email.com", "456");

        Produto produto1 = new Cafe("café", 3f);

        /*
        * Essa linha tá comentada por eu estar com preguiça
        * de adicionar todos os parâmetros que o Pedido requer
        * */
        //Pedido pedido = new Pedido();

        Factory cafeFactory= new FactoryCafe();
        Produto cafe = cafeFactory.criarProduto("Espresso", 22);

        Factory livroFactory = new FactoryLivro();
        Produto livro = livroFactory.criarProduto("Padroes de Projeto", 35678);


        produto1.adicionarObservador(cliente1);
        produto1.setDisponibilidade(true);
        produto1.setPrecoProduto(30f);
        produto1.setDisponibilidade(false);
        produto1.setDisponibilidade(true);

    }
}