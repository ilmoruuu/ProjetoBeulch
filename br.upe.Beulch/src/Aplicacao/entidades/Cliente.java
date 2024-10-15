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
            if (!(produto.getPrecoAtual() == produto.getPrecoAnterior())) {
                System.out.println("O preço do produto " + produto.getNome() + " mudou!");
                System.out.println("Novo preço: R$ " + produto.getPrecoAtual());
            }
        }
    }

    @Override
    public void atualizar(Pedido pedido) {
        if(pedido.isConfirmado()){
            System.out.println("O pedido foi confirmado.");
        } else {
            System.out.println("O pedido foi negado.");
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
