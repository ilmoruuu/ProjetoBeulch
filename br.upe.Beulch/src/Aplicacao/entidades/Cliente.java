package Aplicacao.entidades;

import PadroesProjeto.Observer.Notificacao.Interface.ClienteObserver;

public class Cliente implements ClienteObserver {
    private String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }

    @Override
    public void atualizar(Produto produto) {
        if (!produto.isDisponivel()) {
            System.out.println("O produto " + produto.getNome() + " está indisponível no momento.");
        } else {
            System.out.println("O produto " + produto.getNome() + " está disponível no momento.");

        }
    }

    @Override
    public void atualizar(Pedido pedido) {
            try {
                System.out.println("Pagamento confirmado!");
                Thread.sleep(3000);

                System.out.println("Seu pedido estará pronto para retirada em instantes!");
                Thread.sleep(3000);

                System.out.println("3...");
                Thread.sleep(3000);

                System.out.println("2...");
                Thread.sleep(3000);

                System.out.println("1...");
                Thread.sleep(3000);

                System.out.println("Seu pedido está pronto para ser retirado! Aproveite!");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
