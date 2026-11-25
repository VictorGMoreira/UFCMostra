
package ufconecta.modelo;

/**
 * Classe que representa um professor no sistema.
 * Herda os dados de Participante e implementa a interface Palestrante.
 */
public class Professor extends Participante implements Palestrante {

    // Número de identificação do professor na instituição
    private String siape;

    // Departamento ao qual o professor está vinculado
    private String departamento;

    // Construtor que recebe os dados do participante e as informações do professor
    public Professor(String id, String nome, String email, String curso, String unidade,
                     String siape, String departamento) {

        // Inicializa os atributos herdados da classe Participante
        super(id, nome, email, curso, unidade);

        // Valida e armazena o SIAPE
        this.siape = exigirTexto(siape, "SIAPE");

        // Valida e armazena o departamento
        this.departamento = exigirTexto(departamento, "departamento");
    }

    // Retorna o papel do participante
    @Override
    public String getPapel() {
        return "Professor";
    }

    // Retorna o SIAPE do professor
    public String getSiape() {
        return siape;
    }

    // Retorna o departamento do professor
    public String getDepartamento() {
        return departamento;
    }

    // Altera o departamento após validar o novo valor
    public void setDepartamento(String d) {
        this.departamento = exigirTexto(d, "departamento");
    }

    // Retorna os dados herdados junto com as informações específicas do professor
    @Override
    public String toString() {
        return super.toString() + " | " + getPapel()
                + " SIAPE " + siape + ", " + departamento;
    }
}
