package PadroesProjeto.FactoryMethod;

public class FactoryLivro extends Factory {
    @Override
    public Produto criarProduto(String nome, String preco) {
        return new Livro(nome, preco);
    }
}
