package ufconecta.excecao;

/** Participante, inscrição ou outro registro inexistente. */
public class EntidadeNaoEncontradaException extends UFConectaException {
    public EntidadeNaoEncontradaException(String mensagem) { super(mensagem); }
}
