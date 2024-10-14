package PadroesProjeto.FactoryMethod;

public class Livro implements Produto {

    private String nome;
    private String preco;

    public Livro(String nome, String preco) {
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
        return "Título: " +
                nome +
                ", preco = '" + preco + '\''
                ;
    }

}
