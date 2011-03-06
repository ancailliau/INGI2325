package uclouvain.ingi2325.utils;

import uclouvain.ingi2325.exception.*;
import uclouvain.ingi2325.math.Tuple3;

/**
 * Represents a vector of three float.
 * 
 * @author Antoine Cailliau <antoine.cailliau@uclouvain.be>
 * @author Julien Dupuis
 * @author Sébastien Doeraene <sjrdoeraene@gmail.com>
 */
public class Vector3D extends Tuple3 {

	/**
	 * Parse a Vector3D from a string
	 * @param string   String representation
	 * @return The Vector3D represented by string
	 * @throws ParseException string is not a valid Vector3D
	 * @see Tuple3#valueOf(String, Tuple3)
	 */
	public static Vector3D valueOf(String string) throws ParseException {
		return valueOf(string, new Vector3D());
	}
}
