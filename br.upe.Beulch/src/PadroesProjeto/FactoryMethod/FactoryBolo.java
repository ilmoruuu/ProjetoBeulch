package PadroesProjeto.FactoryMethod;

import Aplicacao.Produto;

public class FactoryBolo extends Factory{

    @Override
    public Produto criarProduto(String nome, float precoAtual) {
        return new Bolo(nome, precoAtual);
    }
}
