package PadroesProjeto.Observer;

import PadroesProjeto.Strategy.Pedido;

import java.util.List;

public class Cliente implements ClienteObserver{

    private String nome;
    private String email;
    private String telefone;
    private List<Produto> produtos;
    private List<Pedido> pedidos;

    @Override
    public void atualizar() {
    }
}
