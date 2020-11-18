package br.com.fakebank.exception;

public class FakeBankNegocioException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FakeBankNegocioException(String msg) {
		super(msg);
	}
	
	public static FakeBankNegocioException throwException(String msg) {
		throw new FakeBankNegocioException(msg);
	}
}
