package uclouvain.ingi2325.parser;

import java.util.StringTokenizer;

import uclouvain.ingi2325.exception.ParseException;
import uclouvain.ingi2325.math.Tuple2;
import uclouvain.ingi2325.math.Tuple3;
import uclouvain.ingi2325.utils.Color;
import uclouvain.ingi2325.utils.Point3D;
import uclouvain.ingi2325.utils.TextureCoordinates;
import uclouvain.ingi2325.utils.Vector3D;

/**
 * Utilities class used to parse Strings, floats, arrays of floats, ...
 * 
 * @author Antoine Cailliau <antoine.cailliau@uclouvain.be>
 * @author Julien Dupuis
 */
public class ParserUtils {

	/**
	 * Parse a float from a string.
	 * 
	 * @param string
	 *            representing a float
	 * @return the float contained in the string
	 * @throws ParseException
	 *             Thrown if parsing failed
	 */
	static float parseFloat(String string) throws ParseException {
		try {
			return Float.parseFloat(string);
		} catch (Exception e) {
			throw new ParseException("Could not parse float from \"" + string
					+ "\".");
		}
	}

	/**
	 * Parse a boolean from a string.
	 * 
	 * @param string
	 *            representing a boolean
	 * @return the boolean contained in the string
	 * @throws ParseException
	 *             Thrown if parsing failed
	 */
	static boolean parseBoolean(String string) throws ParseException {
		if (string.equals("true")) {
			return true;
		} else if (string.equals("false")) {
			return false;
		} else {
			throw new ParseException("Could not parse boolean from \"" + string
					+ "\".");
		}
	}

	/**
	 * Parse a vector from a string.
	 * 
	 * @param string
	 *            representing a string
	 * @return the vector represented by the string
	 * @throws ParseException
	 *             Thrown if parsing failed
	 */
	static Vector3D parseVector3f(String string) throws ParseException {
		StringTokenizer stringTokenizer = new StringTokenizer(string, " ");

		Vector3D vector3f = new Vector3D();

		try {
			vector3f.x = Float.parseFloat(stringTokenizer.nextToken());
			vector3f.y = Float.parseFloat(stringTokenizer.nextToken());
			vector3f.z = Float.parseFloat(stringTokenizer.nextToken());
		} catch (Exception e) {
			throw new ParseException("Could not parse Vector3f from \""
					+ string + "\".");
		}

		if (stringTokenizer.hasMoreTokens()) {
			throw new ParseException("Could not parse Vector3f from \""
					+ string + "\".");
		}

		return vector3f;
	}

	/**
	 * Parse a 3d point from a string.
	 * 
	 * @param string
	 *            representing the point
	 * @return the point represented by the string
	 * @throws ParseException
	 *             Thrown if parsing failed
	 */

	static Point3D parsePoint3f(String string) throws ParseException {
		StringTokenizer stringTokenizer = new StringTokenizer(string, " ");

		Point3D point3f = new Point3D();

		try {
			point3f.x = Float.parseFloat(stringTokenizer.nextToken());
			point3f.y = Float.parseFloat(stringTokenizer.nextToken());
			point3f.z = Float.parseFloat(stringTokenizer.nextToken());
		} catch (Exception e) {
			throw new ParseException("Could not parse Vector3f from \""
					+ string + "\".");
		}

		if (stringTokenizer.hasMoreTokens()) {
			throw new ParseException("Could not parse Vector3f from \""
					+ string + "\".");
		}

		return point3f;
	}

	/**
	 * Parse a color from a string.
	 * 
	 * @param string
	 *            representing a color
	 * @return the color represented by the string
	 * @throws ParseException
	 *             Thrown if parsing failed
	 */

	static Color parseColor3f(String string) throws ParseException {
		StringTokenizer stringTokenizer = new StringTokenizer(string, " ");

		Color color3f = new Color();

		try {
			color3f.x = Float.parseFloat(stringTokenizer.nextToken());
			color3f.y = Float.parseFloat(stringTokenizer.nextToken());
			color3f.z = Float.parseFloat(stringTokenizer.nextToken());
		} catch (Exception e) {
			throw new ParseException("Could not parse Vector3f from \""
					+ string + "\".");
		}

		if (stringTokenizer.hasMoreTokens()) {
			throw new ParseException("Could not parse Vector3f from \""
					+ string + "\".");
		}

		return color3f;
	}

	/**
	 * Parse a texture coordinate from a string.
	 * 
	 * @param string
	 *            representing a texture coordinate
	 * @return the texture coordinate represented in the string
	 * @throws ParseException
	 *             Thrown if parsing failed
	 */

	static TextureCoordinates parseTexCoord2f(String string)
			throws ParseException {
		StringTokenizer stringTokenizer = new StringTokenizer(string, " ");

		TextureCoordinates texCoord2f = new TextureCoordinates();

		try {
			texCoord2f.x = Float.parseFloat(stringTokenizer.nextToken());
			texCoord2f.y = Float.parseFloat(stringTokenizer.nextToken());
		} catch (Exception e) {
			throw new ParseException(
					"Could not parse texture coordinate from \"" + string
							+ "\".");
		}

		if (stringTokenizer.hasMoreTokens()) {
			throw new ParseException(
					"Could not parse texture coordinate from \"" + string
							+ "\".");
		}

		return texCoord2f;
	}

	/**
	 * Parse an array of integers from a string.
	 * 
	 * @param string
	 *            representing an array of integers
	 * @return the array of integers
	 * @throws ParseException
	 *             Thrown if parsing failed
	 */

	static int[] parseIntArray(String string) throws ParseException {
		if (string == null)
			return null;
		StringTokenizer stringTokenizer = new StringTokenizer(string, ", ");

		int num = stringTokenizer.countTokens();
		int[] array = new int[num];

		try {
			for (int i = 0; i < num; i++) {
				array[i] = Integer.parseInt(stringTokenizer.nextToken());
			}
		} catch (Exception e) {
			throw new ParseException("Could not parse int array from \""
					+ string + "\".");
		}

		return array;
	}

	/**
	 * Parse an array of vector from a string.
	 * 
	 * @param string
	 *            representing an array of vectors
	 * @return the vector represented by the string
	 * @throws ParseException
	 *             Thrown if parsing failed
	 */

	static Vector3D[] parseVector3fArray(String string) throws ParseException {
		if (string == null)
			return null;
		StringTokenizer stringTokenizer = new StringTokenizer(string, ",");

		int num = stringTokenizer.countTokens();
		Vector3D[] array = new Vector3D[num];

		try {
			for (int i = 0; i < num; i++) {
				array[i] = parseVector3f(stringTokenizer.nextToken());
			}
		} catch (Exception e) {
			throw new ParseException("Could not parse Vector3f array from \""
					+ string + "\".");
		}

		return array;
	}

	/**
	 * Parse an array of point from a string.
	 * 
	 * @param string
	 *            representing a point
	 * @return the point represented by the string
	 * @throws ParseException
	 *             Thrown if parsing failed
	 */
	static Point3D[] parsePoint3fArray(String string) throws ParseException {
		StringTokenizer stringTokenizer = new StringTokenizer(string, ",");

		int num = stringTokenizer.countTokens();
		Point3D[] array = new Point3D[num];

		try {
			for (int i = 0; i < num; i++) {
				array[i] = parsePoint3f(stringTokenizer.nextToken());
			}
		} catch (Exception e) {
			throw new ParseException("Could not parse Point3f array from \""
					+ string + "\".");
		}

		return array;
	}

	/**
	 * Parse an array of color from a string.
	 * 
	 * @param string
	 *            representing the color
	 * @return the color represented by the string
	 * @throws ParseException
	 *             Thrown if parsing failed
	 */
	static Color[] parseColor3fArray(String string) throws ParseException {
		if (string == null)
			return null;
		StringTokenizer stringTokenizer = new StringTokenizer(string, ", ");

		int num = stringTokenizer.countTokens();
		Color[] array = new Color[num];

		try {
			for (int i = 0; i < num; i++) {
				array[i] = parseColor3f(stringTokenizer.nextToken());
			}
		} catch (Exception e) {
			throw new ParseException("Could not parse Color3f array from \""
					+ string + "\".");
		}

		return array;
	}

	/**
	 * Parse an array of texture coordinate from a string.
	 * 
	 * @param string
	 *            representing an array of texture coordinate
	 * @return the array of texture coordinate
	 * @throws ParseException
	 *             Thrown if parsing failed
	 */
	static TextureCoordinates[] parseTexCoord2fArray(String string)
			throws ParseException {
		if (string == null)
			return null;
		StringTokenizer stringTokenizer = new StringTokenizer(string, ",");

		int num = stringTokenizer.countTokens();
		TextureCoordinates[] array = new TextureCoordinates[num];

		try {
			for (int i = 0; i < num; i++) {
				array[i] = parseTexCoord2f(stringTokenizer.nextToken());
			}
		} catch (Exception e) {
			throw new ParseException("Could not parse TexCoord2f array from \""
					+ string + "\".");
		}

		return array;
	}

	/**
	 * Parse an array of strings from a string.
	 * 
	 * @param string
	 *            representing an array of string
	 * @return the array of string
	 * @throws ParseException
	 *             Thrown if parsing failed
	 */
	static String[] parseStringArray(String string) throws ParseException {
		StringTokenizer stringTokenizer = new StringTokenizer(string, ", ");

		int num = stringTokenizer.countTokens();
		String[] array = new String[num];

		try {
			for (int i = 0; i < num; i++) {
				array[i] = stringTokenizer.nextToken();
			}
		} catch (Exception e) {
			throw new ParseException("Could not parse String array from \""
					+ string + "\".");
		}

		return array;
	}

	/**
	 * Returns a string representing a tuple
	 * 
	 * @param tuple
	 *            the tuple to represent
	 * @return a string representation of the tuple
	 */
	static String formatTuple3f(Tuple3 tuple) {
		return "" + tuple.x + " " + tuple.y + " " + tuple.z + "";
	}

	/**
	 * Returns a string representing a tuple
	 * 
	 * @param tuple
	 *            the tuple to represent
	 * @return a string representation of the tuple
	 */
	static String formatTuple2f(Tuple2 tuple) {
		return "" + tuple.x + " " + tuple.y + "";
	}

	/**
	 * Returns a string representing the array of tuple
	 * 
	 * @param array
	 *            the array
	 * @return a string representation of the array
	 */
	static String formatTuple3fArray(Tuple3[] array) {
		if (array.length == 0) {
			return null;
		} else {
			String string = formatTuple3f(array[0]);
			for (int i = 1; i < array.length; i++) {
				string += ", " + formatTuple3f(array[i]);
			}
			return string;
		}
	}

	/**
	 * Returns a string representing the array of tuple
	 * 
	 * @param array
	 *            the array
	 * @return a string representation of the array
	 */
	static String formatTuple2fArray(Tuple2[] array) {
		if (array.length == 0) {
			return null;
		} else {
			String string = formatTuple2f(array[0]);
			for (int i = 1; i < array.length; i++) {
				string += ", " + formatTuple2f(array[i]);
			}
			return string;
		}
	}

	/**
	 * Returns a string representing the array of integers
	 * 
	 * @param array
	 *            the array
	 * @return a string representation of the array
	 */
	static String formatIntArray(int[] array) {
		if (array.length == 0) {
			return null;
		} else {
			String string = "" + array[0];
			for (int i = 1; i < array.length; i++) {
				string += ", " + array[i];
			}
			return string;
		}
	}

	/**
	 * Returns a string representing the array of string
	 * 
	 * @param array
	 *            the array
	 * @return a string representation of the array
	 */
	static String formatStringArray(String[] array) {
		if (array.length == 0) {
			return null;
		} else {
			String string = "" + array[0];
			for (int i = 1; i < array.length; i++) {
				string += ", " + array[i];
			}
			return string;
		}
	}
}
