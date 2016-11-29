/**
 * 
 */
package br.com.makersweb.service.exception;

/**
 * @author anderson.aristides
 */
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = -9212557840373843209L;

	/**
	 * 
	 */
	public BusinessException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public BusinessException(String message) {
		super(message);
	}

	/**
	 * @param message
	 */
	public BusinessException(String message, Boolean error, String typeError) {
		super(message);
	}
}