package padroesProjeto.factoryMethod.factories;

import aplicacao.entidades.Produto;
import padroesProjeto.factoryMethod.produtos.Cafe;

public class FactoryCafe extends Factory {
    @Override
    public Produto criarProduto(String nome) {
        return new Cafe(nome);
    }
}
