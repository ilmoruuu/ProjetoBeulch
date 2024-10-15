package PadroesProjeto.Strategy.Pagamento.Implementacao;

import PadroesProjeto.Strategy.Pagamento.Interface.PagamentoStrategy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pix implements PagamentoStrategy {
    private String nomeTitular;
    private String banco;
    private float recebido;

    public Pix(String nomeTitular, String banco, float recebido) {
        this.nomeTitular = nomeTitular;
        this.banco = banco;
        this.recebido = recebido;
    }

    @Override
    public void realizarPagamento(float valor) {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataFormatada = localDateTime.format(formatter);


        System.out.println("________________PIX__________________");
        System.out.printf("Para:. Cafeteria Beulch \nDe:. '%s'\nBanco:. %s\n", nomeTitular,banco);
        System.out.printf("Data e Hora: %s\n", dataFormatada);

        if (recebido < valor) {
            System.out.println("Pagamento inválido\n"+
                    "_________________________________________");
            throw new IllegalArgumentException("O valor recebido é inválido! Tente novamente!");
        }

        System.out.printf("\nPagamento de R$: %.2f\n", valor);

        System.out.println("\nPagamento Realizado com Sucesso!\n\nObrigado! ;)");
        System.out.println("_____________________________________");
    }
}