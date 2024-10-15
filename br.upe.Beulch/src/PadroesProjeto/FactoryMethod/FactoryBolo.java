package PadroesProjeto.FactoryMethod;


import Aplicacao.entidades.Produto;

public class FactoryBolo extends Factory{

    @Override
    public Produto criarProduto(String nome) {
        return new Bolo(nome);
    }
}
