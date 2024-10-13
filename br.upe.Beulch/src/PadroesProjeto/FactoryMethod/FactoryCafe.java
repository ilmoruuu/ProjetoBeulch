package PadroesProjeto.FactoryMethod;

public class FactoryCafe extends Factory{
    @Override
    public Produto criarProduto(String nome, String preco) {
        return new Cafe(nome, preco);
    }
}
