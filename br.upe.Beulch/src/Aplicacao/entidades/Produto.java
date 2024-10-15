package Aplicacao.entidades;

import PadroesProjeto.Observer.Notificacao.Interface.Subject;

public interface Produto extends Subject {
    public float getPrecoAtual();
    public float getPrecoAnterior();
    public String getNome();
    public boolean isDisponivel();
    public void setDisponibilidade(boolean disponibilidade);
    public void setPrecoProduto(float valor);
}
