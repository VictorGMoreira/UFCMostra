package ufcmostra.modelo;

public class Trabalho {
    private String situacao = "SUBMETIDO";
    private Edicao edicao;

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        if (!"SUBMETIDO".equals(situacao) && !"EM_AVALIACAO".equals(situacao)
                && !"APROVADO".equals(situacao) && !"NAO_APROVADO".equals(situacao)
                && !"CANCELADO".equals(situacao)) {
            throw new IllegalArgumentException("Situação de trabalho inválida: " + situacao);
        }
        this.situacao = situacao;
    }

    public Edicao getEdicao() {
        return edicao;
    }

    void vincularEdicao(Edicao edicao) {
        this.edicao = edicao;
    }
}
