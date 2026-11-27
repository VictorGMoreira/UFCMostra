package ufcmostra.modelo;

import java.time.LocalDateTime;
import java.util.Objects;

public class Inscricao {
    private final int id;
    private final Participante participante;
    private final Atividade atividade;
    private final LocalDateTime dataHora;
    private boolean ativa = true;

    public Inscricao(int id, Participante participante, Atividade atividade) {
        this.id = id;
        this.participante = Objects.requireNonNull(participante);
        this.atividade = Objects.requireNonNull(atividade);
        this.dataHora = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public Participante getParticipante() {
        return participante;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void cancelar() {
        ativa = false;
    }

    public boolean isAtiva() {
        return ativa;
    }
}
