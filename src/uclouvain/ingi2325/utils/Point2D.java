package uclouvain.ingi2325.utils;

import uclouvain.ingi2325.exception.*;
import uclouvain.ingi2325.math.Tuple2;

/**
 * Represents a 2D point by its two x, y components
 * 
 * @author Antoine Cailliau <antoine.cailliau@uclouvain.be>
 * @author Julien Dupuis
 * @author Sébastien Doeraene <sjrdoeraene@gmail.com>
 */
public class Point2D extends Tuple2 {

	/**
	 * Parse a Point2D from a string
	 * @param string   String representation
	 * @return The Point2D represented by string
	 * @throws ParseException string is not a valid Point2D
	 * @see Tuple2#valueOf(String, Tuple2)
	 */
	public static Point2D valueOf(String string) throws ParseException {
		return valueOf(string, new Point2D());
	}
}
