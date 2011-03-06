package uclouvain.ingi2325.utils;

import uclouvain.ingi2325.exception.*;
import uclouvain.ingi2325.math.*;

/**
 * Represents a vector of four float.
 * 
 * @author Antoine Cailliau <antoine.cailliau@uclouvain.be>
 * @author Julien Dupuis
 * @author Sébastien Doeraene <sjrdoeraene@gmail.com>
 */
public class Vector4 extends Tuple4 {

	/**
	 * Parse a Vector4 from a string
	 * @param string   String representation
	 * @return The Vector4 represented by string
	 * @throws ParseException string is not a valid Vector4
	 * @see Tuple4#valueOf(String, Tuple4)
	 */
	public static Vector4 valueOf(String string) throws ParseException {
		return valueOf(string, new Vector4());
	}
}
