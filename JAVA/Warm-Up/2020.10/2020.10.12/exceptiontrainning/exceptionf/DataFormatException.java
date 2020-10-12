package iopractice.exceptiontrainning.exceptionf;

public class DataFormatException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 560428903058854270L;

	public DataFormatException() {
		// TODO Auto-generated constructor stub
	}

	public DataFormatException(String message) {
		super(message);
	}

	public DataFormatException(Throwable cause) {
		super(cause);
	}

	public DataFormatException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
