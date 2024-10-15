package PadroesProjeto.FactoryMethod;

import Aplicacao.entidades.Produto;

public abstract class Factory {

    public abstract Produto criarProduto(String nome, float precoAtual);

}
