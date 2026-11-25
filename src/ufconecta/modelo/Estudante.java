
package ufconecta.modelo;

import ufconecta.excecao.DadosInvalidosException;

/**
 * Classe que representa um estudante.
 * Herda os atributos e métodos da classe Participante.
 */
public class Estudante extends Participante {

    // Matrícula acadêmica do estudante
    private String matricula;

    // Semestre atual do estudante no curso
    private int semestre;

    // Construtor que recebe os dados do participante e os dados específicos do estudante
    public Estudante(String id, String nome, String email, String curso, String unidade,
                     String matricula, int semestre) {

        // Inicializa os atributos herdados da classe Participante
        super(id, nome, email, curso, unidade);

        // Verifica se a matrícula foi informada corretamente
        this.matricula = exigirTexto(matricula, "matrícula");

        // Define o semestre utilizando o método de validação
        setSemestre(semestre);
    }

    // Retorna o papel do participante
    @Override
    public String getPapel() {
        return "Estudante";
    }

    // Retorna a matrícula do estudante
    public String getMatricula() {
        return matricula;
    }

    // Retorna o semestre atual do estudante
    public int getSemestre() {
        return semestre;
    }

    // Altera o semestre após verificar se o valor é válido
    public void setSemestre(int semestre) {
        if (semestre < 1) {
            throw new DadosInvalidosException("Semestre deve ser >= 1.");
        }

        this.semestre = semestre;
    }

    // Retorna os dados do participante junto com as informações do estudante
    @Override
    public String toString() {
        return super.toString() + " | " + getPapel()
                + " mat. " + matricula + ", " + semestre + "º sem.";
    }
}
