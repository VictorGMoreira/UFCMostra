package ufcmostra.modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Palestra extends Atividade {
    public Palestra(int id, String titulo, String descricao, String local, LocalDate data,
                    LocalTime horaInicio, LocalTime horaFim, int vagas) {
        super(id, titulo, descricao, local, data, horaInicio, horaFim, vagas);
    }

    @Override
    public String getTipo() {
        return "Palestra";
    }

    @Override
    public String getResumo() {
        return getTipo() + ": " + getTitulo() + " - " + getDescricao();
    }
}
