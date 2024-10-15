package PadroesProjeto.FactoryMethod;


import Aplicacao.entidades.Produto;

public class FactoryLivro extends Factory {

    @Override
    public Produto criarProduto(String nome) {
        return new Livro(nome);
    }
}
