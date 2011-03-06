package uclouvain.ingi2325.math;

import java.util.*;

import uclouvain.ingi2325.exception.*;

/**
 * Represents a tuple of two float.
 * 
 * @author Antoine Cailliau <antoine.cailliau@uclouvain.be>
 * @author Julien Dupuis
 * @author Sébastien Doeraene <sjrdoeraene@gmail.com>
 */
public abstract class Tuple2 {

	/**
	 * The x component.
	 */
	public float x;

	/**
	 * The y component.
	 */
	public float y;

	/**
	 * Constructs and initializes a tuple to (0,0).
	 */
	public Tuple2() {
		x = 0.0F;
		y = 0.0F;
	}

	/**
	 * Constructs and initializes a tuple from the specified xy coordinates
	 */
	public Tuple2(float x, float y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Constructs and initializes a tuple from the specified tuple.
	 * 
	 * @param tuple
	 *            the tuple to copy values from.
	 */
	public Tuple2(Tuple2 tuple) {
		x = tuple.x;
		y = tuple.y;
	}

	/**
	 * Sets the value of this tuple to the specified x, y coordinates.
	 * 
	 * @param x
	 *            the x coordinate
	 * @param y
	 *            the y coordinate
	 */
	public final void set(float x, float y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Sets the value of this tuple to the value of the tuple argument.
	 * 
	 * @param tuple
	 *            the tuple to copy data from.
	 */
	public final void set(Tuple2 tuple) {
		x = tuple.x;
		y = tuple.y;
	}

	/**
	 * Returns a string that contains the values of this tuple.
	 */
	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

	/**
	 * Parse a Tuple2 from a string
	 * <p>A valid example is:
	 * <pre>5.3 -4</pre>
	 * @param string   String representation
	 * @param tuple    Tuple to be filled
	 * @return The tuple
	 * @throws ParseException string does not represent a valid Tuple2
	 */
	public static <T extends Tuple2> T valueOf(String string,
			T tuple) throws ParseException {
		StringTokenizer stringTokenizer = new StringTokenizer(string, " ");

		try {
			tuple.x = Float.parseFloat(stringTokenizer.nextToken());
			tuple.y = Float.parseFloat(stringTokenizer.nextToken());
		} catch (NoSuchElementException error) {
			throwParseException(string, tuple);
		} catch (NumberFormatException error) {
			throwParseException(string, tuple);
		}

		if (stringTokenizer.hasMoreTokens())
			throwParseException(string, tuple);

		return tuple;
	}

	/**
	 * Throw a parse exception
	 * <p>This method never returns normally.
	 * @param string   String that should have been parsed
	 * @param tuple    Tuple that would have been filled
	 * @throws ParseException
	 */
	private static void throwParseException(String string,
			Tuple2 tuple) throws ParseException {
		throw new ParseException(String.format(
				"Cannot convert '%s' into a %s", string,
				tuple.getClass().getSimpleName()));
	}

}
