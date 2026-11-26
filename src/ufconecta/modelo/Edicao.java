package ufconecta.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Edicao {
    private int id;
    private int ano;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String descricao;
    private List<Atividade> atividades;
    private List<Trabalho> trabalhos;

    public Edicao(int id, int ano, LocalDate dataInicio, LocalDate dataFim, String descricao) {
        this.id = id;
        this.ano = ano;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.descricao = descricao;
        this.atividades = new ArrayList<>();
        this.trabalhos = new ArrayList<>();
    }

    public void adicionarAtividade(Atividade atividade) {
        if (atividade != null && !this.atividades.contains(atividade)) {
            this.atividades.add(atividade);
        }
    }

    public void removerAtividade(Atividade atividade) {
        this.atividades.remove(atividade);
    }

    public void adicionarTrabalho(Trabalho trabalho) {
        if (trabalho != null && !this.trabalhos.contains(trabalho)) {
            this.trabalhos.add(trabalho);
        }
    }

    public boolean contemData(LocalDate data) {
        if (data == null || dataInicio == null || dataFim == null) {
            return false;
        }
        return !data.isBefore(dataInicio) && !data.isAfter(dataFim);
    }

    public List<Atividade> listarAtividades() {
        return new ArrayList<>(atividades);
    }

    public List<Atividade> listarAtividades(String tipo) {
        List<Atividade> filtradas = new ArrayList<>();
        if (tipo == null) {
            return filtradas;
        }
        for (Atividade atividade : atividades) {
            if (tipo.equalsIgnoreCase(atividade.getTipo())) {
                filtradas.add(atividade);
            }
        }
        return filtradas;
    }

    public List<Atividade> listarAtividades(LocalDate inicio, LocalDate fim) {
        List<Atividade> filtradas = new ArrayList<>();
        if (inicio == null || fim == null) {
            return filtradas;
        }
        for (Atividade atividade : atividades) {
            LocalDate dataAtividade = atividade.getData();
            if (dataAtividade != null && !dataAtividade.isBefore(inicio) && !dataAtividade.isAfter(fim)) {
                filtradas.add(atividade);
            }
        }
        return filtradas;
    }

    public List<Trabalho> listarTrabalhosAprovados() {
        List<Trabalho> aprovados = new ArrayList<>();
        for (Trabalho trabalho : trabalhos) {
            if ("APROVADO".equalsIgnoreCase(trabalho.getSituacao())) {
                aprovados.add(trabalho);
            }
        }
        return aprovados;
    }

    public int getId() {
        return id;
    }

    public int getAno() {
        return ano;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Trabalho> getTrabalhos() {
        return new ArrayList<>(trabalhos);
    }
}