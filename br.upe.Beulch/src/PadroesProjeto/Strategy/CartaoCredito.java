package PadroesProjeto.Strategy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CartaoCredito implements PagamentoStrategy{
    private String numeroCartao;
    private String nomeTitular;
    private String validade;
    private String CVV;
    private int parcelas;

    public CartaoCredito(String numeroCartao, String nomeTitular, String validade, String CVV, int parcelas) {
        this.numeroCartao = numeroCartao;
        this.nomeTitular = nomeTitular;
        this.validade = validade;
        this.CVV = CVV;
        setParcelas(parcelas);
    }

    public void setParcelas(int parcelas) {
        if (parcelas < 1 || parcelas > 3) {
            throw new IndexOutOfBoundsException("Esse valor não é permitido!\n Só aceitamos de 1x à 3x");
        }
        this.parcelas = parcelas;
    }

    @Override
    public void realizarPagamento(float valor) {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataFormatada = localDateTime.format(formatter);

        float taxa = (valor * 0.03f);
        float valorParcelas = (valor+taxa)/parcelas;
        System.out.println("________________CRÉDITO__________________");
        System.out.printf("Para:. Cafeteria Beulch \nDe:. %s\n", nomeTitular);
        System.out.printf("Data e Hora: %s\n",dataFormatada);
        System.out.printf("\nPagamento de R$: %.2f" + " divido em %d vezes", (valor+taxa), parcelas);

        for (int i = 1; i <= parcelas; i++){
            System.out.printf("Parcela %d " + "de R$: %.2f\n", i, valorParcelas);
        }

        System.out.println("\nPagamento Realizado com Sucesso!\nObrigado! ;)");
        System.out.println("_________________________________________");
    }
}
