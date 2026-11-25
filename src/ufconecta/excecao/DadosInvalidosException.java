package ufconecta.excecao;

/** Campo obrigatório vazio, e-mail malformado, argumento nulo etc. */
public class DadosInvalidosException extends UFConectaException {
    public DadosInvalidosException(String mensagem) { super(mensagem); }
}
