package PadroesProjeto.FactoryMethod;

public class Comida implements Produto {


    private String nome;
    private String preco;

    public Comida(String nome, String preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public String nome() {
        return null;
    }

    @Override
    public String preco() {
        return null;
    }

    @Override
    public String toString() {
        return "Item: " +
                nome +
                ", preco = '" + preco + '\''
                ;
    }

}
