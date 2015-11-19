package hu.innodox.fileviewer.exception;

public class ProcessingException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4548332480153501872L;
	
	
	public ProcessingException(String path, String errMessage){
		super("Error while trying to process the following file ==> [ "+path+" ] Error message ==> [ "+errMessage+" ]");
	}

}
