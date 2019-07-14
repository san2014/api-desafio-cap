package ba.ssa.desafio.exception;

public class ValorSaqueNaoPermitidoException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7001788972150401788L;
	
	public ValorSaqueNaoPermitidoException(String mensagem) {
		super(mensagem);
	}

}
