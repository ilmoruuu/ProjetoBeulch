package PadroesProjeto.FactoryMethod;

public class Cafe implements Produto {

    private String nome;
    private String preco;

    public Cafe(String nome, String preco) {
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
        return "Cafe " +
                nome +
                ", preco = '" + preco + '\''
                ;
    }
}
