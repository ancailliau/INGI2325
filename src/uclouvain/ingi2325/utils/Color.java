package uclouvain.ingi2325.utils;

import uclouvain.ingi2325.exception.*;
import uclouvain.ingi2325.math.Tuple3;

/**
 * Represents a color by its three RGB components
 * 
 * @author Antoine Cailliau <antoine.cailliau@uclouvain.be>
 * @author Julien Dupuis
 * @author Sébastien Doeraene <sjrdoeraene@gmail.com>
 */
public class Color extends Tuple3 {

	/**
	 * Constructs and initializes a color from the three given values.
	 * 
	 * @param r
	 *            the red component
	 * @param g
	 *            the green component
	 * @param b
	 *            the blue component
	 */
	public Color(float r, float g, float b) {
		super(r, g, b);
	}

	/**
	 * Constructs and initializes a color from the specified AWT Color object.
	 * 
	 * @param color
	 *            the color
	 */
	public Color(java.awt.Color color) {
		super(color.getRed() / 255F, color.getGreen() / 255F,
				color.getBlue() / 255F);
	}

	/**
	 * Constructs a black color
	 */
	public Color() {
		super(0, 0, 0);
	}

	/**
	 * Sets the r,g,b values of this color object to those of the specified AWT
	 * Color object.
	 * 
	 * @param color
	 */
	public final void set(java.awt.Color color) {
		x = color.getRed() / 255F;
		y = color.getGreen() / 255F;
		z = color.getBlue() / 255F;
	}

	/**
	 * Returns a new AWT color object initialized with the r,g,b values of this
	 * color object.
	 * 
	 * @return the color
	 */
	public final java.awt.Color get() {
		int i = Math.round(x * 255F);
		int j = Math.round(y * 255F);
		int k = Math.round(z * 255F);
		return new java.awt.Color(i, j, k);
	}

	/**
	 * Parse a Color from a string
	 * @param string   String representation
	 * @return The Color represented by string
	 * @throws ParseException string is not a valid Color
	 * @see Tuple3#valueOf(String, Tuple3)
	 */
	public static Color valueOf(String string) throws ParseException {
		return valueOf(string, new Color());
	}
}
