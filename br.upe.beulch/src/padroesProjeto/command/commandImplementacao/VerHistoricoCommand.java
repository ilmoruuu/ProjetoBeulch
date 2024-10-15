package padroesProjeto.command.commandImplementacao;


import aplicacao.entidades.Pedido;
import padroesProjeto.command.commandInterface.Command;

import java.util.List;

public class VerHistoricoCommand implements Command {

    private List<Pedido> pedidosRealizados;

    public VerHistoricoCommand(List<Pedido> pedidosRealizados){
        this.pedidosRealizados = pedidosRealizados;
    }

    @Override
    public void execute() {
        if (pedidosRealizados.isEmpty()){
            System.out.println("Não houveram pedidos realizados anteriormente");
            System.out.println();
            return;
        }

        System.out.println("Aqui está o seu histórico de pedidos");
        System.out.println("_________________________________________");
        for (Pedido p: pedidosRealizados){
            desenharPedido(p);
        }
    }

    public void desenharPedido(Pedido pedido){
        System.out.printf("Nome do cliente: %s\n", pedido.getNomeCliente());
        System.out.printf("Produto: %s\n", pedido.getConteudoPedido().toString());
        System.out.printf("Valor pago: %.2f\n", pedido.getValorPedido());
        System.out.printf("Tipo de pagamento: %s\n", pedido.getPagamentoStrategy().toString());
        System.out.println("_________________________________________");
    }

    public List<Pedido> getPedidosRealizados() {
        return pedidosRealizados;
    }

    public void setPedidosRealizados(List<Pedido> pedidosRealizados) {
        this.pedidosRealizados = pedidosRealizados;
    }

}
