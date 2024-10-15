package PadroesProjeto.FactoryMethod;

import Aplicacao.entidades.Produto;

public class FactoryCafe extends Factory{
    @Override
    public Produto criarProduto(String nome, float precoAtual) {
        return new Cafe(nome, precoAtual);
    }
}
