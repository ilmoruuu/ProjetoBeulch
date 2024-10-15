package Aplicacao.entidades;

import PadroesProjeto.Observer.Notificacao.Interface.ClienteObserver;

public class Cliente implements ClienteObserver {
    private String nome;
    private String email;
    private String telefone;

    public Cliente(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
