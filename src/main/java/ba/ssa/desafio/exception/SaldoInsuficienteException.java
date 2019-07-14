package ba.ssa.desafio.exception;

public class SaldoInsuficienteException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3106731449357908667L;

	public SaldoInsuficienteException(String mensagem) {
		super(mensagem);
	}

}
