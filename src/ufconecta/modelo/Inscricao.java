
package ufconecta.modelo;

import java.time.LocalDateTime;
import ufconecta.excecao.DadosInvalidosException;
import ufconecta.excecao.RegraNegocioException;

/**
 * Classe que representa a inscrição de um participante em uma atividade.
 * Armazena os dados da inscrição e seu estado (ativa ou cancelada).
 */
public class Inscricao {

    // Identificador da inscrição
    private int id;

    // Participante que realizou a inscrição
    private Participante participante;

    // Atividade na qual o participante está inscrito
    private Atividade atividade;

    // Data e horário em que a inscrição foi realizada
    private LocalDateTime dataHora;

    // Indica se a inscrição está ativa
    private boolean ativa;

    // Construtor para uma nova inscrição, utilizando a data e hora atuais
    public Inscricao(int id, Participante participante, Atividade atividade) {
        this(id, participante, atividade, LocalDateTime.now(), true);
    }

    // Construtor sobrecarregado utilizado para reconstruir inscrições já registradas
    public Inscricao(int id, Participante participante, Atividade atividade,
                     LocalDateTime dataHora, boolean ativa) {

        // Verifica se os dados obrigatórios foram informados
        if (participante == null) {
            throw new DadosInvalidosException("Participante é obrigatório.");
        }

        if (atividade == null) {
            throw new DadosInvalidosException("Atividade é obrigatória.");
        }

        this.id = id;
        this.participante = participante;
        this.atividade = atividade;
        this.dataHora = dataHora;
        this.ativa = ativa;
    }

    // Cancela a inscrição, caso ela ainda esteja ativa
    public void cancelar() {
        if (!ativa) {
            throw new RegraNegocioException("Inscrição " + id + " já está cancelada.");
        }

        ativa = false;
    }

    // Verifica se a inscrição está ativa
    public boolean isAtiva() {
        return ativa;
    }

    // Retorna o identificador da inscrição
    public int getId() {
        return id;
    }

    // Retorna o participante inscrito
    public Participante getParticipante() {
        return participante;
    }

    // Retorna a atividade relacionada à inscrição
    public Atividade getAtividade() {
        return atividade;
    }

    // Retorna a data e o horário da inscrição
    public LocalDateTime getDataHora() {
        return dataHora;
    }

    // Retorna uma representação textual da inscrição
    @Override
    public String toString() {
        return "Inscrição #" + id + " - " + participante.getNome()
                + " em '" + atividade.getTitulo()
                + "' (" + (ativa ? "ativa" : "cancelada") + ")";
    }
}
