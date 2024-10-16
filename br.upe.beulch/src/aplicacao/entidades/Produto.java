package aplicacao.entidades;

import padroesProjeto.observer.Subject;

public interface Produto extends Subject {
    public float getPrecoAtual();
    public String getNome();
    public boolean isDisponivel();
    public void setDisponibilidade(boolean disponivel);
    public void setPrecoAtual(float novoPreco);
}
