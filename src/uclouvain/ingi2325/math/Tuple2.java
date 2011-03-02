package uclouvain.ingi2325.math;

/**
 * Represents a tuple of two float.
 * 
 * @author Antoine Cailliau <antoine.cailliau@uclouvain.be>
 * @author Julien Dupuis
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

}
