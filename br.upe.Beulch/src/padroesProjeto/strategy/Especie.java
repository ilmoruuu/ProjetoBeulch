package padroesProjeto.strategy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Especie implements PagamentoStrategy {
    private String nomeTitular;
    private float recebido;

    public Especie(String nomeTitular, float recebido) {
        this.nomeTitular = nomeTitular;
        this.recebido = recebido;
    }

    @Override
    public void realizarPagamento(float valor) {

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataFormatada = localDateTime.format(formatter);

        System.out.println("________________ESPÉCIE__________________");
        System.out.printf("Para:. Cafeteria Beulch \nDe:. %s\n", nomeTitular);
        System.out.printf("Data e Hora: %s\n",dataFormatada);
        System.out.printf("\nPagamento de R$: %.2f\n", valor);

        if (recebido >= valor){
            System.out.printf("Troco de R$: %.2f\n", (recebido-valor));

        } else {
            System.out.println("Pagamento inválido\n"+
                    "_________________________________________");
            throw new IllegalArgumentException("O valor recebido é inválido! Tente novamente!");

        }

        System.out.println("\nPagamento Realizado com Sucesso!\n\nObrigado! ;)");
        System.out.println("_________________________________________");
    }
}
