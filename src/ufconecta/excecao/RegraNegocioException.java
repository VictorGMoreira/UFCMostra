package ufconecta.excecao;

/** Violação de regra: duplicidade, sem vagas, atividade cancelada, remoção com vínculos... */
public class RegraNegocioException extends UFConectaException {
    public RegraNegocioException(String mensagem) { super(mensagem); }
}
