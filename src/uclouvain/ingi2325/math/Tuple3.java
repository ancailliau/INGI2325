package uclouvain.ingi2325.math;

/**
 * Represents a tuple of three float.
 * 
 * @author Antoine Cailliau <antoine.cailliau@uclouvain.be>
 * @author Julien Dupuis
 */
public abstract class Tuple3 {

	/**
	 * The x coordinate.
	 */
	public float x;

	/**
	 * The y coordinate.
	 */
	public float y;

	/**
	 * The z coordinate.
	 */
	public float z;

	/**
	 * Constructs and initializes a new tuple to (0,0,0).
	 */
	public Tuple3() {
		x = 0.0F;
		y = 0.0F;
		z = 0.0F;
	}

	/**
	 * Constructs and initializes a Tuple3f from the specified xyz coordinates.
	 * 
	 * @param x
	 *            the x-coordinate
	 * @param y
	 *            the y-coordinate
	 * @param z
	 *            the z-coordinate
	 */
	public Tuple3(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * Constructs and initializes a tuple from the specified tuple.
	 * 
	 * @param tuple
	 *            a tuple representing the tuple to copy
	 */
	public Tuple3(Tuple3 tuple) {
		x = tuple.x;
		y = tuple.y;
		z = tuple.z;
	}

	/**
	 * Returns a string that contains the values of this Tuple3f
	 */
	@Override
	public String toString() {
		return "(" + x + ", " + y + ", " + z + ")";
	}

	/**
	 * Sets the value of this tuple to the specified xyz coordinates.
	 * 
	 * @param x
	 *            the x-coordinate
	 * @param y
	 *            the y-coordinate
	 * @param z
	 *            the z-coordinate
	 */
	public final void set(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * Sets the value of this tuple to the value of tuple t1.
	 * 
	 * @param tuple
	 *            the tuple to copy
	 */
	public final void set(Tuple3 tuple) {
		set(tuple.x, tuple.y, tuple.z);
	}

	/**
	 * Gets the value of this tuple and copies the values into t.
	 * 
	 * @param t
	 *            the tuple
	 */
	public final void get(Tuple3 t) {
		t.x = x;
		t.y = y;
		t.z = z;
	}

}
