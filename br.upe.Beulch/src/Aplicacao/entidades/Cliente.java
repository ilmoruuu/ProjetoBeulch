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
                System.out.println("----------------------------");
                System.out.println();
                System.out.println("Pagamento confirmado!");
                Thread.sleep(3000);

                System.out.println("Seu pedido estará pronto para retirada em instantes!");
                Thread.sleep(1000);

                System.out.println("Aguarde...");
                Thread.sleep(3000);

                System.out.println("Um momento...");
                Thread.sleep(3000);

                System.out.println("Seu pedido está quase pronto...");
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
