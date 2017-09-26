package linalg;

/*** A class that represents a two dimensional real-valued (double) matrix
 *   and supports various matrix computations required in linear algebra.
 *   
 *   Class and method comments are in JavaDoc: https://en.wikipedia.org/wiki/Javadoc
 * 
 * @author ssanner@mie.utoronto.ca, <YOUR_EMAIL>
 *
 */
public class Matrix {

	private int _nRows; // Number of rows in this matrix; nomenclature: _ for data member, n for integer
	private int _nCols; // Number of columns in this matrix; nomenclature: _ for data member, n for integer
	// TODO: add your own data member to represent the matrix content
	//       you could use a 2D array, or an array of Vectors (e.g., for each row)
	
	/** Allocates a new matrix of the given row and column dimensions
	 * 
	 * @param rows
	 * @param cols
	 * @throws LinAlgException if either rows or cols is <= 0
	 */
	public Matrix(int rows, int cols) throws LinAlgException {
		// TODO: hint: see the corresponding Vector constructor
	}
	
	/** Copy constructor: makes a new copy of an existing Matrix m
	 *                    (note: this explicitly allocates new memory and copies over content)
	 * 
	 * @param m
	 */
	public Matrix(Matrix m) {
		// TODO: hint: see the corresponding Vector "copy constructor" for an example
	}

	/** Constructs a String representation of this Matrix
	 * 
	 */
	public String toString() {
		// TODO: hint: see Vector.toString() for an example
		return null;
	}

	/** Tests whether another Object o (most often a matrix) is a equal to *this*
	 *  (i.e., are the dimensions the same and all elements equal each other?)
	 * 
	 * @param o the object to compare to
	 */
	public boolean equals(Object o) {
		// TODO: hint: see Vector.equals(), you can also use Vector.equals() for checking equality 
		//             of row vectors if you store your matrix as an array of Vectors for rows
		
		// TODO: this should not always return false!
		return false; // This should not always return false!
	}
	
	/** Return the number of rows in this matrix
	 *   
	 * @return 
	 */
	public int getNumRows() {
		// TODO (this should not return -1!)
		return -1;
	}

	/** Return the number of columns in this matrix
	 *   
	 * @return 
	 */
	public int getNumCols() {
		// TODO (this should not return -1!)
		return -1;
	}

	/** Return the scalar value at the given row and column of the matrix
	 * 
	 * @param row
	 * @param col
	 * @return
	 * @throws LinAlgException if row or col indices are out of bounds
	 */
	public double get(int row, int col) throws LinAlgException {
		// TODO (this should not return -1!)
		return -1;
	}
	
	/** Return the Vector of numbers corresponding to the provided row index
	 * 
	 * @param row
	 * @return
	 * @throws LinAlgException if row is out of bounds
	 */
	public Vector getRow(int row) throws LinAlgException {
		// TODO (this should not return null!)
		return null;
	}

	/** Set the row and col of this matrix to the provided val
	 * 
	 * @param row
	 * @param col
	 * @param val
	 * @throws LinAlgException if row or col indices are out of bounds
	 */
	public void set(int row, int col, double val) throws LinAlgException {
		// TODO
	}
	
	/** Return a new Matrix that is the transpose of *this*, i.e., if "transpose"
	 *  is the transpose of Matrix m then for all row, col: transpose[row,col] = m[col,row]
	 *  (should not modify *this*)
	 * 
	 * @return
	 * @throws LinAlgException
	 */
	public Matrix transpose() throws LinAlgException {
		Matrix transpose = new Matrix(_nCols, _nRows);
		for (int row = 0; row < _nRows; row++) {
			for (int col = 0; col < _nCols; col++) {
				transpose.set(col, row, get(row,col));
			}
		}
		return transpose;
	}

	/** Return a new Matrix that is the square identity matrix (1's on diagonal, 0's elsewhere) 
	 *  with the number of rows, cols given by size.  E.g., if size = 3 then the returned matrix
	 *  would be the following:
	 *  
	 *  [ 1 0 0 ]
	 *  [ 0 1 0 ]
	 *  [ 0 0 1 ]
	 * 
	 * @param size
	 * @return
	 * @throws LinAlgException if the size is <= 0
	 */
	public static Matrix GetIdentity(int size) throws LinAlgException {
		// TODO: this should not return null!
		return null;
	}
	
	/** Returns the Matrix result of multiplying Matrix m1 and m2
	 *  (look up the definition of matrix multiply if you don't remember it)
	 * 
	 * @param m1
	 * @param m2
	 * @return
	 * @throws LinAlgException if m1 columns do not match the size of m2 rows
	 */
	public static Matrix Multiply(Matrix m1, Matrix m2) {
		// TODO: this should not return null!
		return null;
	}
		
	/** Returns the Vector result of multiplying Matrix m by Vector v (assuming v is a column vector)
	 * 
	 * @param m
	 * @param v
	 * @return
	 * @throws LinAlgException if m columns do match the size of v
	 */
	public static Vector Multiply(Matrix m, Vector v) throws LinAlgException {
		// TODO: this should not return null!
		return null;
	}

}
