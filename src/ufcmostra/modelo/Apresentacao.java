package ufcmostra.modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Apresentacao extends Atividade {
    public Apresentacao(int id, String titulo, String descricao, String local, LocalDate data,
                        LocalTime horaInicio, LocalTime horaFim, int vagas) {
        super(id, titulo, descricao, local, data, horaInicio, horaFim, vagas);
    }

    @Override
    public String getTipo() {
        return "Apresentação";
    }

    @Override
    public String getResumo() {
        return getTipo() + ": " + getTitulo() + " - " + getDescricao();
    }
}
