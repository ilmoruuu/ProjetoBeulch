package PadroesProjeto.FactoryMethod;

import Aplicacao.entidades.Produto;

public class FactoryCafe extends Factory{
    @Override
    public Produto criarProduto(String nome) {
        return new Cafe(nome);
    }
}
