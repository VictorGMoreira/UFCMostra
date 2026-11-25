
package ufconecta.modelo;

import ufconecta.excecao.DadosInvalidosException;

/**
 * Classe associativa que representa a relação entre um Participante e um Trabalho.
 * Armazena também o papel de responsável e a ordem de autoria.
 */
public class Autoria {

    // Participante que faz parte da autoria do trabalho
    private Participante participante;

    // Trabalho ao qual o participante está associado
    private Trabalho trabalho;

    // Indica se o participante é o responsável pelo trabalho
    private boolean responsavel;

    // Posição do participante na lista de autores
    private int ordem;

    // Construtor que cria uma associação entre participante e trabalho
    public Autoria(Participante participante, Trabalho trabalho, boolean responsavel, int ordem) {

        // Verifica se os dados obrigatórios foram informados
        if (participante == null) {
            throw new DadosInvalidosException("Autor é obrigatório.");
        }

        if (trabalho == null) {
            throw new DadosInvalidosException("Trabalho é obrigatório.");
        }

        if (ordem < 1) {
            throw new DadosInvalidosException("A ordem do autor deve ser >= 1.");
        }

        this.participante = participante;
        this.trabalho = trabalho;
        this.responsavel = responsavel;
        this.ordem = ordem;
    }

    // Retorna se o participante é o responsável pelo trabalho
    public boolean isResponsavel() {
        return responsavel;
    }

    // Altera a condição de responsável do participante
    public void setResponsavel(boolean responsavel) {
        this.responsavel = responsavel;
    }

    // Retorna o participante associado
    public Participante getParticipante() {
        return participante;
    }

    // Retorna o trabalho associado
    public Trabalho getTrabalho() {
        return trabalho;
    }

    // Retorna a posição do participante na autoria
    public int getOrdem() {
        return ordem;
    }

    // Retorna uma representação textual da autoria
    @Override
    public String toString() {
        return ordem + ". " + participante.getNome()
                + (responsavel ? " (responsável)" : "");
    }
}
