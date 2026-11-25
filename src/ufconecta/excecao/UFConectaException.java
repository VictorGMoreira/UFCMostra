package ufconecta.excecao;

/** Raiz das exceções do sistema (não verificada, para não poluir as assinaturas). */
public class UFConectaException extends RuntimeException {
    public UFConectaException(String mensagem) { super(mensagem); }
}
