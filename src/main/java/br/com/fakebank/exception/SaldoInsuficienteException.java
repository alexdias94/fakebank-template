package br.com.fakebank.exception;

public class SaldoInsuficienteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SaldoInsuficienteException(String msg) {
		super(msg);
	}

	public static SaldoInsuficienteException throwException(String msg) {
		throw new SaldoInsuficienteException(msg);
	}
}
