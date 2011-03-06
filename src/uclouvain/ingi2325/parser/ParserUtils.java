package uclouvain.ingi2325.parser;

import java.lang.reflect.*;
import java.util.*;

import uclouvain.ingi2325.exception.ParseException;

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
