package PadroesProjeto.FactoryMethod;


import Aplicacao.entidades.Produto;

public class FactoryLivro extends Factory {

    @Override
    public Produto criarProduto(String nome, float precoAtual) {
        return new Livro(nome, precoAtual);
    }
}
