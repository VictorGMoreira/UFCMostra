
package ufconecta.modelo;

import java.util.Objects;
import ufconecta.excecao.DadosInvalidosException;

/**
 * Classe abstrata que representa um participante do sistema.
 * Serve como base para classes como Estudante e Professor.
 */
public abstract class Participante {

    // Identificador único do participante
    private String id;

    // Nome completo do participante
    private String nome;

    // E-mail para contato
    private String email;

    // Curso ao qual o participante está vinculado
    private String curso;

    // Unidade acadêmica do participante
    private String unidade;

    // Construtor protegido para inicializar os dados do participante
    protected Participante(String id, String nome, String email, String curso, String unidade) {
        this.id = exigirTexto(id, "id");
        this.nome = exigirTexto(nome, "nome");
        this.email = validarEmail(email);
        this.curso = exigirTexto(curso, "curso");
        this.unidade = exigirTexto(unidade, "unidade");
    }

    // Retorna o papel do participante, implementado pelas subclasses
    public abstract String getPapel();

    // Verifica se um texto é válido e remove espaços desnecessários
    protected static String exigirTexto(String valor, String campo) {
        if (valor == null || valor.isBlank()) {
            throw new DadosInvalidosException("O campo '" + campo + "' é obrigatório.");
        }

        return valor.trim();
    }

    // Verifica se o e-mail possui um formato válido
    private static String validarEmail(String email) {
        String e = exigirTexto(email, "e-mail");

        if (!e.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")) {
            throw new DadosInvalidosException("E-mail inválido: " + e);
        }

        return e;
    }

    // Atualiza todos os dados editáveis após realizar as validações
    public void atualizar(String nome, String email, String curso, String unidade) {

        // Valida os novos dados antes de modificar os atributos
        String n = exigirTexto(nome, "nome");
        String e = validarEmail(email);
        String c = exigirTexto(curso, "curso");
        String u = exigirTexto(unidade, "unidade");

        // Atualiza os atributos com os valores validados
        this.nome = n;
        this.email = e;
        this.curso = c;
        this.unidade = u;
    }

    // Retorna o identificador do participante
    public String getId() {
        return id;
    }

    // Retorna o nome do participante
    public String getNome() {
        return nome;
    }

    // Retorna o e-mail do participante
    public String getEmail() {
        return email;
    }

    // Retorna o curso do participante
    public String getCurso() {
        return curso;
    }

    // Retorna a unidade acadêmica do participante
    public String getUnidade() {
        return unidade;
    }

    // Altera o nome após validar o novo valor
    public void setNome(String nome) {
        this.nome = exigirTexto(nome, "nome");
    }

    // Altera o e-mail após validar seu formato
    public void setEmail(String email) {
        this.email = validarEmail(email);
    }

    // Altera o curso após validar o novo valor
    public void setCurso(String curso) {
        this.curso = exigirTexto(curso, "curso");
    }

    // Altera a unidade após validar o novo valor
    public void setUnidade(String unidade) {
        this.unidade = exigirTexto(unidade, "unidade");
    }

    // Compara dois participantes utilizando seus identificadores
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Participante)) return false;

        return id.equals(((Participante) o).id);
    }

    // Gera um código hash baseado no identificador do participante
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // Retorna os dados do participante em formato textual
    @Override
    public String toString() {
        return String.format("[%s] %s (%s) - %s / %s",
                id, nome, email, curso, unidade);
    }
}
