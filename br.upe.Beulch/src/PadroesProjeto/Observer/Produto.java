package PadroesProjeto.Observer;

import java.util.ArrayList;
import java.util.List;

public class Produto implements Subject {

    private String nome;
    private Float precoProduto;
    private boolean disponivel;
    private List<ClienteObserver> clienteObservers;


    public Produto(String nome, Float precoProduto) {
        this.nome = nome;
        this.precoProduto = precoProduto;
        this.clienteObservers = new ArrayList<>();
        this.disponivel = true;
    }

    @Override
    public void adicionarObservador(ClienteObserver clienteObserver) {
        if(!clienteObservers.contains(clienteObserver)){
            clienteObservers.add(clienteObserver);
        }
    }

    @Override
    public void removerObservador(ClienteObserver clienteObserver) {
        clienteObservers.remove(clienteObserver);
    }

    @Override
    public void notificar() {
        for (ClienteObserver clienteObserver : clienteObservers) {
            clienteObserver.atualizar();
        }
    }

    public void setDisponibilidade(boolean disponivel) {
        this.disponivel = disponivel;
        notificar();
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(Float precoProduto) {
        this.precoProduto = precoProduto;
    }

}
