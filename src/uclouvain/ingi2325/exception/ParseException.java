package uclouvain.ingi2325.exception;

/**
 * Represents a parsing exception
 * 
 * @author Antoine Cailliau <antoine.cailliau@uclouvain.be>
 * @author Julien Dupuis
 */
public class ParseException extends Exception {
	private static final long serialVersionUID = -4922810844499906083L;

	public ParseException(String message) {
		super(message);
	}
}
