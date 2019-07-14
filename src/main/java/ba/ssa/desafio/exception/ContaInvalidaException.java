package ba.ssa.desafio.exception;

public class ContaInvalidaException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6247392667564698258L;
	
	public ContaInvalidaException(String mensagem) {
		super(mensagem);
	}

}
