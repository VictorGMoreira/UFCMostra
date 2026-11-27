package ufcmostra.modelo;

import java.util.ArrayList;
import java.util.List;

public class Evento {
    private String nome;
    private String descricao;
    private List<Edicao> edicoes;

    public Evento(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.edicoes = new ArrayList<>();
    }

    public void adicionarEdicao(Edicao edicao) {
        if (edicao != null && !this.edicoes.contains(edicao)) {
            this.edicoes.add(edicao);
        }
    }

    public Edicao buscarEdicao(int ano) {
        for (Edicao edicao : edicoes) {
            if (edicao.getAno() == ano) {
                return edicao;
            }
        }
        return null;
    }

    public List<Edicao> getEdicoes() {
        return new ArrayList<>(edicoes);
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}