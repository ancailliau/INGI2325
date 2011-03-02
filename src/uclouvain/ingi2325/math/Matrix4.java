package uclouvain.ingi2325.math;

import uclouvain.ingi2325.utils.Vector4;

/**
 * Represents a 4 by 4 matrix of floats.
 * 
 * @author Antoine Cailliau <antoine.cailliau@uclouvain.be>
 * @author Julien Dupuis
 */
public class Matrix4 {

	/**
	 * The first element of the first row.
	 */
	public float m00;

	/**
	 * The second element of the first row.
	 */
	public float m01;

	/**
	 * The third element of the first row.
	 */
	public float m02;

	/**
	 * The forth element of the first row.
	 */

	public float m03;

	/**
	 * The first element of the second row.
	 */

	public float m10;

	/**
	 * The second element of the second row.
	 */

	public float m11;

	/**
	 * The third element of the second row.
	 */

	public float m12;

	/**
	 * The fourth element of the second row.
	 */

	public float m13;

	/**
	 * The first element of the third row.
	 */

	public float m20;

	/**
	 * The second element of the third row.
	 */
	public float m21;

	/**
	 * The third element of the third row.
	 */
	public float m22;

	/**
	 * The fourth element of the third row.
	 */
	public float m23;

	/**
	 * The first element of the fourth row.
	 */
	public float m30;

	/**
	 * The second element of the fourth row.
	 */
	public float m31;

	/**
	 * The third element of the fourth row.
	 */
	public float m32;

	/**
	 * The fourth element of the fourth row.
	 */
	public float m33;

	/**
	 * Constructs and initializes a matrix to all zeros.
	 */
	public Matrix4() {
		m00 = 0.0F;
		m01 = 0.0F;
		m02 = 0.0F;
		m03 = 0.0F;
		m10 = 0.0F;
		m11 = 0.0F;
		m12 = 0.0F;
		m13 = 0.0F;
		m20 = 0.0F;
		m21 = 0.0F;
		m22 = 0.0F;
		m23 = 0.0F;
		m30 = 0.0F;
		m31 = 0.0F;
		m32 = 0.0F;
		m33 = 0.0F;
	}

	/**
	 * Constructs and initializes a matrix from the specified 16 values
	 * 
	 * @param m00
	 *            the first row, first column element
	 * @param m01
	 *            the first row, second column element
	 * @param m02
	 *            the first row, third column element
	 * @param m03
	 *            the first row, fourth column element
	 * @param m10
	 *            the second row, first column element
	 * @param m11
	 *            the second row, second column element
	 * @param m12
	 *            the second row, third column element
	 * @param m13
	 *            the second row, fourth column element
	 * @param m20
	 *            the third row, first column element
	 * @param m21
	 *            the third row, second column element
	 * @param m22
	 *            the third row, third column element
	 * @param m23
	 *            the third row, fourth column element
	 * @param m30
	 *            the fourth row, first column element
	 * @param m31
	 *            the fourth row, second column element
	 * @param m32
	 *            the fourth row, third column element
	 * @param m33
	 *            the fourth row, fourth column element
	 */
	public Matrix4(float m00, float m01, float m02, float m03, float m10,
			float m11, float m12, float m13, float m20, float m21, float m22,
			float m23, float m30, float m31, float m32, float m33) {
		this.m00 = m00;
		this.m01 = m01;
		this.m02 = m02;
		this.m03 = m03;
		this.m10 = m10;
		this.m11 = m11;
		this.m12 = m12;
		this.m13 = m13;
		this.m20 = m20;
		this.m21 = m21;
		this.m22 = m22;
		this.m23 = m23;
		this.m30 = m30;
		this.m31 = m31;
		this.m32 = m32;
		this.m33 = m33;
	}

	/**
	 * Constructs a new matrix with the same values as the matrix parameter.
	 * 
	 * @param matrix
	 *            the matrix to copy.
	 */
	public Matrix4(Matrix4 matrix) {
		m00 = matrix.m00;
		m01 = matrix.m01;
		m02 = matrix.m02;
		m03 = matrix.m03;
		m10 = matrix.m10;
		m11 = matrix.m11;
		m12 = matrix.m12;
		m13 = matrix.m13;
		m20 = matrix.m20;
		m21 = matrix.m21;
		m22 = matrix.m22;
		m23 = matrix.m23;
		m30 = matrix.m30;
		m31 = matrix.m31;
		m32 = matrix.m32;
		m33 = matrix.m33;
	}

	/**
	 * Returns a string that contains the values of this matrix.
	 */
	@Override
	public String toString() {
		return m00 + ", " + m01 + ", " + m02 + ", " + m03 + "\n" + m10 + ", "
				+ m11 + ", " + m12 + ", " + m13 + "\n" + m20 + ", " + m21
				+ ", " + m22 + ", " + m23 + "\n" + m30 + ", " + m31 + ", "
				+ m32 + ", " + m33 + "\n";
	}

	/**
	 * Sets the specified element of this matrix to the value provided.
	 * 
	 * @param rowIndex
	 *            the row index
	 * @param columnIndex
	 *            the column index
	 * @param value
	 *            the value
	 */
	public final void setElement(int rowIndex, int columnIndex, float value) {
		switch (rowIndex) {
		case 0:
			switch (columnIndex) {
			case 0:
				m00 = value;
				break;

			case 1:
				m01 = value;
				break;

			case 2:
				m02 = value;
				break;

			case 3:
				m03 = value;
				break;

			default:
				throw new ArrayIndexOutOfBoundsException();
			}
			break;

		case 1:
			switch (columnIndex) {
			case 0:
				m10 = value;
				break;

			case 1:
				m11 = value;
				break;

			case 2:
				m12 = value;
				break;

			case 3:
				m13 = value;
				break;

			default:
				throw new ArrayIndexOutOfBoundsException();
			}
			break;

		case 2:
			switch (columnIndex) {
			case 0:
				m20 = value;
				break;

			case 1:
				m21 = value;
				break;

			case 2:
				m22 = value;
				break;

			case 3:
				m23 = value;
				break;

			default:
				throw new ArrayIndexOutOfBoundsException();
			}
			break;

		case 3:
			switch (columnIndex) {
			case 0:
				m30 = value;
				break;

			case 1:
				m31 = value;
				break;

			case 2:
				m32 = value;
				break;

			case 3:
				m33 = value;
				break;

			default:
				throw new ArrayIndexOutOfBoundsException();
			}
			break;

		default:
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	/**
	 * Retrieves the value at the specified row and column of this matrix.
	 * 
	 * @param rowIndex
	 *            the row index
	 * @param columnIndex
	 *            the column index
	 * @return the value stored at given indexes in the represented matrix.
	 */
	public final float getElement(int rowIndex, int columnIndex) {
		switch (rowIndex) {
		default:
			break;

		case 0:
			switch (columnIndex) {
			case 0:
				return m00;

			case 1:
				return m01;

			case 2:
				return m02;

			case 3:
				return m03;
			}
			break;

		case 1:
			switch (columnIndex) {
			case 0:
				return m10;

			case 1:
				return m11;

			case 2:
				return m12;

			case 3:
				return m13;
			}
			break;

		case 2:
			switch (columnIndex) {
			case 0:
				return m20;

			case 1:
				return m21;

			case 2:
				return m22;

			case 3:
				return m23;
			}
			break;

		case 3:
			switch (columnIndex) {
			case 0:
				return m30;

			case 1:
				return m31;

			case 2:
				return m32;

			case 3:
				return m33;
			}
			break;
		}
		throw new ArrayIndexOutOfBoundsException();
	}

	/**
	 * Copies the matrix values in the specified row into the vector parameter.
	 * 
	 * @param rowIndex
	 *            the row index
	 * @param vector
	 *            the vector used to copy the values.
	 */
	public final void getRow(int rowIndex, Tuple4 vector) {
		if (rowIndex == 0) {
			vector.x = m00;
			vector.y = m01;
			vector.z = m02;
			vector.w = m03;
		} else if (rowIndex == 1) {
			vector.x = m10;
			vector.y = m11;
			vector.z = m12;
			vector.w = m13;
		} else if (rowIndex == 2) {
			vector.x = m20;
			vector.y = m21;
			vector.z = m22;
			vector.w = m23;
		} else if (rowIndex == 3) {
			vector.x = m30;
			vector.y = m31;
			vector.z = m32;
			vector.w = m33;
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	/**
	 * Copies the matrix values in the specified column into the vector
	 * parameter. Vector must be initialized.
	 * 
	 * @param columnIndex
	 *            the column index.
	 * @param v
	 *            the vector to store the values.
	 */
	public final void getColumn(int columnIndex, Tuple4 v) {
		if (columnIndex == 0) {
			v.x = m00;
			v.y = m10;
			v.z = m20;
			v.w = m30;
		} else if (columnIndex == 1) {
			v.x = m01;
			v.y = m11;
			v.z = m21;
			v.w = m31;
		} else if (columnIndex == 2) {
			v.x = m02;
			v.y = m12;
			v.z = m22;
			v.w = m32;
		} else if (columnIndex == 3) {
			v.x = m03;
			v.y = m13;
			v.z = m23;
			v.w = m33;
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	/**
	 * Sets the specified row of this matrix to the four values provided.
	 * 
	 * @param rowIndex
	 *            the row index
	 * @param m0
	 *            the first value of the row
	 * @param m1
	 *            the second value of the row
	 * @param m2
	 *            the third value of the row
	 * @param m3
	 *            the fourth value of the row
	 */
	public final void setRow(int rowIndex, float m0, float m1, float m2,
			float m3) {
		switch (rowIndex) {
		case 0:
			m00 = m0;
			m01 = m1;
			m02 = m2;
			m03 = m3;
			break;

		case 1:
			m10 = m0;
			m11 = m1;
			m12 = m2;
			m13 = m3;
			break;

		case 2:
			m20 = m0;
			m21 = m1;
			m22 = m2;
			m23 = m3;
			break;

		case 3:
			m30 = m0;
			m31 = m1;
			m32 = m2;
			m33 = m3;
			break;

		default:
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	/**
	 * Sets the specified row of this matrix to the Vector provided.
	 * 
	 * @param rowIndex
	 *            the row index.
	 * @param vector
	 *            the vector representing the values to use as replacement.
	 */
	public final void setRow(int rowIndex, Tuple4 vector) {
		setRow(rowIndex, vector.x, vector.y, vector.z, vector.w);
	}

	/**
	 * Sets the specified column of this matrix to the four values provided.
	 * 
	 * @param columnIndex
	 *            the column index
	 * @param m0
	 *            the first value for the column
	 * @param m1
	 *            the second value for the column
	 * @param m2
	 *            the third value for the column
	 * @param m3
	 *            the fourth value for the column
	 */
	public final void setColumn(int columnIndex, float m0, float m1, float m2,
			float m3) {
		switch (columnIndex) {
		case 0:
			m00 = m0;
			m10 = m1;
			m20 = m2;
			m30 = m3;
			break;

		case 1:
			m01 = m0;
			m11 = m1;
			m21 = m2;
			m31 = m3;
			break;

		case 2:
			m02 = m0;
			m12 = m1;
			m22 = m2;
			m32 = m3;
			break;

		case 3:
			m03 = m0;
			m13 = m1;
			m23 = m2;
			m33 = m3;
			break;

		default:
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	/**
	 * Sets the specified column of this matrix to the vector provided.
	 * 
	 * @param columnIndex
	 *            the column index
	 * @param vector
	 *            the vector to use a replacement
	 */
	public final void setColumn(int columnIndex, Vector4 vector) {
		setColumn(columnIndex, vector.x, vector.y, vector.z, vector.w);
	}

	/**
	 * Sets this matrix to all zeros.
	 */
	public final void resetToZero() {
		m00 = 0.0F;
		m01 = 0.0F;
		m02 = 0.0F;
		m03 = 0.0F;
		m10 = 0.0F;
		m11 = 0.0F;
		m12 = 0.0F;
		m13 = 0.0F;
		m20 = 0.0F;
		m21 = 0.0F;
		m22 = 0.0F;
		m23 = 0.0F;
		m30 = 0.0F;
		m31 = 0.0F;
		m32 = 0.0F;
		m33 = 0.0F;
	}

	/**
	 * Sets this matrix to identity.
	 */
	public final void resetToIdentity() {
		m00 = 1.0F;
		m01 = 0.0F;
		m02 = 0.0F;
		m03 = 0.0F;
		m10 = 0.0F;
		m11 = 1.0F;
		m12 = 0.0F;
		m13 = 0.0F;
		m20 = 0.0F;
		m21 = 0.0F;
		m22 = 1.0F;
		m23 = 0.0F;
		m30 = 0.0F;
		m31 = 0.0F;
		m32 = 0.0F;
		m33 = 1.0F;
	}
}
