package Aplicacao;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("João", "joao@email.com", "123");
        Cliente cliente2 = new Cliente("Pedro", "pedro@email.com", "456");

        Produto produto1 = new Produto("café", 3f);
        Pedido pedido = new Pedido();

        produto1.adicionarObservador(cliente1);

        produto1.setDisponibilidade(true);
        produto1.setPrecoProduto(30f);
        produto1.setDisponibilidade(false);
        produto1.setDisponibilidade(true);

    }
}