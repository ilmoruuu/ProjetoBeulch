package padroesProjeto.strategy.strategyImplementacao;

import padroesProjeto.strategy.strategyEnum.TipoCartao;
import padroesProjeto.strategy.strategyInterface.PagamentoStrategy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Cartao implements PagamentoStrategy {
    private final String numeroCartao;
    private final String nomeTitular;
    private final String validade;
    private final String CVV;
    private float recebido;
    private int parcelas;
    private final TipoCartao tipoCartao;

    public Cartao(String numeroCartao, String nomeTitular, String validade,
                  String CVV, float recebido, TipoCartao tipoCartao, int parcelas) {
        this.numeroCartao = numeroCartao;
        this.nomeTitular = nomeTitular;
        this.validade = validade;
        this.CVV = CVV;
        this.recebido = recebido;
        this.tipoCartao = tipoCartao;
        if (tipoCartao == TipoCartao.CREDITO) {
            setParcelas(parcelas);
        }
    }

    public void setParcelas(int parcelas) {
        if (parcelas < 1 || parcelas > 3) {
            throw new IndexOutOfBoundsException("Esse valor não é permitido!\n Só aceitamos de 1x à 3x");
        }
        this.parcelas = parcelas;
    }

    @Override
    public void realizarPagamento(float valorConta) {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataFormatada = localDateTime.format(formatter);

        if (tipoCartao == TipoCartao.CREDITO) {
            realizarPagamentoCredito(valorConta, dataFormatada);
        } else {
            realizarPagamentoDebito(valorConta, dataFormatada);
        }
    }

    private void realizarPagamentoCredito(float valor, String dataFormatada) {
        float taxa = (valor * 0.03f);
        float valorParcelas = (valor + taxa) / parcelas;

        System.out.println("________________CRÉDITO__________________");
        System.out.printf("Para:. Cafeteria Beulch \nDe:. %s\n", nomeTitular);
        System.out.printf("Data e Hora: %s\n", dataFormatada);

        if (recebido < valor) {
            System.out.println("\nPagamento inválido\n" + "_________________________________________");
            throw new IllegalArgumentException("O valor recebido é inválido! Tente novamente!");
        }

        System.out.printf("\nPagamento de R$: %.2f" + " divido em %d vezes\n\n", (valor + taxa), parcelas);
        for (int i = 1; i <= parcelas; i++) {
            System.out.printf("Parcela %d de R$: %.2f\n", i, valorParcelas);
        }
    }

    private void realizarPagamentoDebito(float valor, String dataFormatada) {
        System.out.println("________________DÉBITO__________________");
        System.out.printf("Para:. Cafeteria Beulch \nDe:. %s\n", nomeTitular);
        System.out.printf("Data e Hora: %s\n", dataFormatada);

        if (recebido < valor) {
            System.out.println("Pagamento inválido\n" + "_________________________________________");
            throw new IllegalArgumentException("O valor recebido é inválido! Tente novamente!");
        }

        System.out.printf("\nPagamento de R$: %.2f\n", (valor + (valor * 0.025f)));
    }

    @Override
    public String toString(){
        return "Pagamento com cartão";
    }
}
