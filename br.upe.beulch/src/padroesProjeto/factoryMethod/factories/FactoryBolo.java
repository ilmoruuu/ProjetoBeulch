package padroesProjeto.factoryMethod.factories;

import aplicacao.entidades.Produto;
import padroesProjeto.factoryMethod.produtos.Bolo;

public class FactoryBolo extends Factory {
    @Override
    public Produto criarProduto(String nome) {
        return new Bolo(nome);
    }
}
