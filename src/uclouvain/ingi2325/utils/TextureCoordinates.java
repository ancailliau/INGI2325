package uclouvain.ingi2325.utils;

import uclouvain.ingi2325.exception.*;
import uclouvain.ingi2325.math.Tuple2;

/**
 * Represents the couple for texture coordinates
 * 
 * @author Antoine Cailliau <antoine.cailliau@uclouvain.be>
 * @author Julien Dupuis
 * @author Sébastien Doeraene <sjrdoeraene@gmail.com>
 */
public class TextureCoordinates extends Tuple2 {

	/**
	 * Parse a TextureCoordinates from a string
	 * @param string   String representation
	 * @return The TextureCoordinates represented by string
	 * @throws ParseException string is not a valid TextureCoordinates
	 * @see Tuple2#valueOf(String, Tuple2)
	 */
	public static TextureCoordinates valueOf(
			String string) throws ParseException {
		return valueOf(string, new TextureCoordinates());
	}
}
