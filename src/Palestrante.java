import java.util.Objects;

public class Palestrante {
    private final int id;
    private final Professor professor;

    public Palestrante(int id, Professor professor) {
        this.id = id;
        this.professor = Objects.requireNonNull(professor, "O professor é obrigatório.");
    }

    public int getId() {
        return id;
    }

    public Professor getProfessor() {
        return professor;
    }
}
