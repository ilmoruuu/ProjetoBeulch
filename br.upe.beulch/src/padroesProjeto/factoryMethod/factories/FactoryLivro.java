package padroesProjeto.factoryMethod.factories;


import aplicacao.entidades.Produto;
import padroesProjeto.factoryMethod.produtos.Livro;

public class FactoryLivro extends Factory {

    @Override
    public Produto criarProduto(String nome) {
        return new Livro(nome);
    }
}
