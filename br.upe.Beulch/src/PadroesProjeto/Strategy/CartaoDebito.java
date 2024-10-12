package PadroesProjeto.Strategy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CartaoDebito implements PagamentoStrategy{
    private String numeroCartao;
    private String nomeTitular;
    private String validade;
    private String CVV;

    public CartaoDebito(String numeroCartao, String nomeTitular, String validade, String CVV) {
        this.numeroCartao = numeroCartao;
        this.nomeTitular = nomeTitular;
        this.validade = validade;
        this.CVV = CVV;
    }

    @Override
    public void realizarPagamento(float valor) {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataFormatada = localDateTime.format(formatter);

        float valorFinal = valor + (valor * 0.025f);

        System.out.println("________________DÉBITO__________________");
        System.out.printf("Para:. Cafeteria Beulch \nDe:. %s\n", nomeTitular);
        System.out.printf("Data e Hora: %s\n", dataFormatada);
        System.out.printf("\nPagamento de R$: %.2f\n", valorFinal);
        System.out.println("\nPagamento Realizado com Sucesso!\n\nObrigado! ;)");
        System.out.println("________________________________________");
    }
}
