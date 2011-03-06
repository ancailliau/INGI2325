package uclouvain.ingi2325.parser;

import java.lang.reflect.*;
import java.util.*;

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
 * @author Sébastien Doeraene <sjrdoeraene@gmail.com>
 */
public class ParserUtils {

	/** Map primitive types to their corresponding wrapper classes */
	private static final Map<Class<?>, Class<?>> wrapperClassFor =
		new HashMap<Class<?>, Class<?>>();

	static {
		wrapperClassFor.put(boolean.class, Boolean.class);
		wrapperClassFor.put(char.class, Character.class);
		wrapperClassFor.put(byte.class, Byte.class);
		wrapperClassFor.put(short.class, Short.class);
		wrapperClassFor.put(int.class, Integer.class);
		wrapperClassFor.put(long.class, Long.class);
		wrapperClassFor.put(float.class, Float.class);
		wrapperClassFor.put(double.class, Double.class);
	}

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

	/**
	 * Parse an attribute of the XML into a given type
	 * @param string           String representation
	 * @param attributeClass   Class of the attribute
	 * @return The parsed attribute
	 * @throws ParseException
	 */
	static <T> T parseAttribute(String string, Class<T> attributeClass)
			throws ParseException {
		if (attributeClass.isArray())
			return parseArrayAttribute(string, attributeClass);

		if (attributeClass.isPrimitive())
			attributeClass = getWrappingClass(attributeClass);

		try {
			Method method;

			try {
				method = attributeClass.getMethod("valueOf", String.class);
			} catch (NoSuchMethodException error) {
				method = attributeClass.getMethod("valueOf", Object.class);
			}

			Object result = method.invoke(null, string);
			return attributeClass.cast(result);
		} catch (Exception error) {
			System.err.println(error.getMessage());
			throw new ParseException(String.format(
					"Could not parse %s from \"%s\".",
					attributeClass.getSimpleName(), string));
		}
	}

	/**
	 * Parse an array attribute of the XML into a given type
	 * @param string           String representation
	 * @param attributeClass   Class of the array
	 * @return The array attribute
	 * @throws ParseException
	 */
	private static <T> T parseArrayAttribute(String string,
			Class<T> attributeClass) throws ParseException {
		Class<?> componentType = attributeClass.getComponentType();

		StringTokenizer stringTokenizer = new StringTokenizer(string, ",");

		int length = stringTokenizer.countTokens();
		T array = createArray(attributeClass, length);

		for (int i = 0; i < length; i++) {
			String item = stringTokenizer.nextToken().trim();
			Array.set(array, i, parseAttribute(item, componentType));
		}

		return array;
	}

	/**
	 * Get the wrapping class for a primitive type
	 * @param <T>             Wrapping class
	 * @param primitiveType   Primitive type
	 * @return The wrapping class T
	 */
	@SuppressWarnings("unchecked")
	private static <T> Class<T> getWrappingClass(Class<T> primitiveType) {
		return (Class<T>) wrapperClassFor.get(primitiveType);
	}

	/**
	 * Create an array of a given generic type
	 * @param <T>      Type of the array
	 * @param clazz    Class of the array
	 * @param length   Length of the array to create
	 * @return The created array
	 */
	@SuppressWarnings("unchecked")
	private static <T> T createArray(Class<T> arrayClass, int length) {
		return (T) Array.newInstance(arrayClass.getComponentType(), length);
	}

	/**
	 * Format an attribute for display
	 * @param value   Value of the attribute
	 * @return String representation of the attribute
	 */
	static String formatAttribute(Object value) {
		if (value.getClass().isArray())
			return formatArrayAttribute(value);
		else
			return value.toString();
	}

	/**
	 * Format an array attribute for display
	 * @param value   Value of the array
	 * @return String representation of the attribute
	 */
	private static String formatArrayAttribute(Object array) {
		StringBuilder result = new StringBuilder();

		try {
			int index = 0;

			while (true) {
				Object item = Array.get(array, index++);
				result.append(formatAttribute(item));
				result.append(", ");
			}
		} catch (ArrayIndexOutOfBoundsException error) {
		}

		if (result.length() > 0)
			result.setLength(result.length() - 2);

		return result.toString();
	}
}
