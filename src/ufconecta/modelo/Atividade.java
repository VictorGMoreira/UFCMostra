package ufconecta.modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Atividade {
    private int id;
    private String titulo;
    private String descricao;
    private String local;
    private LocalDate data;
    private LocalTime horaInicio;
    private LocalTime horaFim;
    private int vagas;
    private boolean cancelada;
    private Edicao edicao;
    private List<Inscricao> inscricoes;
    private List<Palestrante> palestrantes;

    public Atividade(int id, String descricao, String local, LocalDate data,
                     LocalTime horaInicio, LocalTime horaFim, int vagas ){

        this.id = id;
        this.descricao = descricao;
        this.local = local;
        this.data = data;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.vagas = vagas;
    }

     public String getTitulo() {
        return titulo;
    }
     public String getDescricao(){
        return descricao;
     }

     public void editar(String titulo, String descricao, String local, LocalDate data,
                        LocalTime horaInicio, LocalTime horaFim, int vagas){

     }
}
