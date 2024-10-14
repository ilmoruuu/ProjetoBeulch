package PadroesProjeto.FactoryMethod;

public class FactoryComida extends Factory{

    @Override
    public Produto criarProduto(String nome, String preco) {
        return new Comida(nome, preco);
    }

}
