package Aplicacao;

import PadroesProjeto.FactoryMethod.Cafe;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("João","joao@gmail.com", "123");

        Produto cafe = new Cafe("Expresso", 3f);

        cafe.adicionarObservador(cliente);
        cafe.setPrecoProduto(5f);
        cafe.setDisponibilidade(false);

    }
}