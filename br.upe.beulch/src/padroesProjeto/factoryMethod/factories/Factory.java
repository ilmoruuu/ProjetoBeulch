package padroesProjeto.factoryMethod.factories;

import aplicacao.entidades.Produto;

public abstract class Factory {

    public abstract Produto criarProduto(String nome);

}
