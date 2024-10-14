package PadroesProjeto.FactoryMethod;

import Aplicacao.Produto;

public abstract class Factory {

    public abstract Produto criarProduto(String nome, float precoAtual);

}
