package ufcmostra.modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Atividade {
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
    private final List<Inscricao> inscricoes;
    private final List<Palestrante> palestrantes;

    // Construtor de Atividade
    protected Atividade(int id, String titulo, String descricao, String local, LocalDate data,
                        LocalTime horaInicio, LocalTime horaFim, int vagas) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.local = local;
        this.data = data;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.vagas = vagas;
        this.cancelada = false;
        this.inscricoes = new ArrayList<>();
        this.palestrantes = new ArrayList<>();
    }

    // Getters
    public int getId() {return id;}
    public String getTitulo() {return titulo;}
    public String getDescricao() {return descricao;}
    public String getLocal() {return local;}
    public LocalDate getData() {return data;}
    public LocalTime getHoraInicio() {return horaInicio;}
    public LocalTime getHoraFim() {return horaFim;}
    public int getVagas() {return vagas;}
    public Edicao getEdicao() {return edicao;}


    void vincularEdicao(Edicao edicao) {
        this.edicao = edicao;
    }
    public List<Inscricao> getInscricoes() {
        return new ArrayList<>(inscricoes);
    }
    public List<Palestrante> getPalestrantes() {
        return new ArrayList<>(palestrantes);
    }
    public abstract String getTipo();

    public abstract String getResumo();

    public void editar(String titulo, String descricao, String local, LocalDate data,
                       LocalTime horaInicio, LocalTime horaFim, int vagas) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.local = local;
        this.data = data;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.vagas = vagas;
    }

    public void cancelar() {
        this.cancelada = true;
    }

    public boolean isCancelada() {
        return this.cancelada;
    }

    // retorna true se a atividade estiver ativa(!cancelada) e
    // chama a função contar inscritos e ver se o número é menor que a quantidade de vagas
    public boolean temVagas() {
        return !cancelada && contarInscritos() < vagas;
    }

    // retorna true se as duas atividades forem
    public boolean conflitaCom(Atividade outra) {
        return outra != null && outra != this
                && !cancelada && !outra.cancelada
                && data != null && data.equals(outra.data)
                && horaInicio != null && horaFim != null
                && outra.horaInicio != null && outra.horaFim != null
                && horaInicio.isBefore(horaFim) && outra.horaInicio.isBefore(outra.horaFim)
                && horaInicio.isBefore(outra.horaFim) && outra.horaInicio.isBefore(horaFim);
    }

    public void adicionarInscricao(Inscricao inscricao) {
        if (inscricao != null && inscricao.getAtividade() == this && inscricao.isAtiva()
                && !inscricoes.contains(inscricao) && temVagas()) {
            inscricoes.add(inscricao);
        }
    }

    public void removerInscricao(Inscricao inscricao) {
        inscricoes.remove(inscricao);
    }

    public int contarInscritos() {
        int total = 0;
        for (Inscricao inscricao : inscricoes) {
            if (inscricao.isAtiva()) {
                total++;
            }
        }
        return total;
    }

    public void adicionarPalestrante(Palestrante p) {
        if (p != null && !palestrantes.contains(p)) {
            palestrantes.add(p);
        }
    }
}
