package linalg;

/*** A class that represents a two dimensional real-valued (double) matrix
 *   and supports various matrix computations required in linear algebra.
 *   
 *   Class and method comments are in JavaDoc: https://en.wikipedia.org/wiki/Javadoc
 * 
 * @author ssanner@mie.utoronto.ca, christina.seo@mail.utoronto.ca
 *
 */
public class Matrix {

	private int _nRows = 1; // Number of rows in this matrix; nomenclature: _ for data member, n for integer
	private int _nCols = 1; // Number of columns in this matrix; nomenclature: _ for data member, n for integer
        private double[][] _vArray;
	
	/** Allocates a new matrix of the given row and column dimensions
	 * 
	 * @param rows
	 * @param cols
	 * @throws LinAlgException if either rows or cols is <= 0
	 */
	public Matrix(int rows, int cols) throws LinAlgException {
            if ((_nRows <= 0) || (_nCols <= 0))
                throw new LinAlgException("Rows or columns cannot be less than or equal to 0!");
            _nRows = rows;
            _nCols = cols;
            _vArray = new double[rows][cols];
	}
	
	/** Copy constructor: makes a new copy of an existing Matrix m
	 *                    (note: this explicitly allocates new memory and copies over content)
	 * 
	 * @param m
	 */
	public Matrix(Matrix m) {
        //Similar to the vector function but with a double array
            _nRows = m._nRows;
            _nCols = m._nCols;
            _vArray = new double[_nRows][_nCols];
            for (int index = 0; index < _nRows; index++)
                for (int index1 = 0 ; index1 < _nCols; index1++)
                    _vArray[index][index1] = m._vArray[index][index1]; 
	}

	/** Constructs a String representation of this Matrix
	 * 
	 */
	public String toString() {
            StringBuilder sb = new StringBuilder();
            //Square brackets in the for loops so they will print at the start and end of every line
            for (int i = 0; i < _nRows; i++){
            sb.append("[");   
                for (int j = 0; j < _nCols; j++) {
                    sb.append(String.format(" %6.3f ", _vArray[i][j])); 
                    //Once we have reached the end of the row, print the next values on a new line
                    if (j == _nCols-1){
                        sb.append(" ]");
                        sb.append("\n");
                    }
                }
            }
        return sb.toString();
	}

	/** Tests whether another Object o (most often a matrix) is a equal to *this*
	 *  (i.e., are the dimensions the same and all elements equal each other?)
	 * 
	 * @param o the object to compare to
	 */
	public boolean equals(Object o) {
             if (o instanceof Matrix) {
                    Matrix m = (Matrix)o; 
                    if (_nRows != m._nRows && _nCols != m._nCols)
                        return false; 
                    for (int index = 0; index < _nRows; index++)
                        for(int index1 = 0; index1 < _nCols; index1++)
                            if (_vArray[index][index1] != m._vArray[index][index1])
                                return false; 
                    return true; // Everything matched... objects are equal!
            } else 
                return false; // Two objects cannot be equal if they don't have the same class type
        }
	
	
	/** Return the number of rows in this matrix
	 *   
	 * @return 
	 */
	public int getNumRows() {
		return _nRows;
	}

	/** Return the number of columns in this matrix
	 *   
	 * @return 
	 */
	public int getNumCols() {
		return _nCols;
	}

	/** Return the scalar value at the given row and column of the matrix
	 * 
	 * @param row
	 * @param col
	 * @return
	 * @throws LinAlgException if row or col indices are out of bounds
	 */
	public double get(int row, int col) throws LinAlgException {
            if ((row >= _nRows) || (row < 0) || (col >= _nCols) || (col < 0))
                throw new LinAlgException ("Column or row out of bounds!");
        return _vArray [row][col];
	}
	
	/** Return the Vector of numbers corresponding to the provided row index
	 * 
	 * @param row
	 * @return
	 * @throws LinAlgException if row is out of bounds
	 */
	public Vector getRow(int row) throws LinAlgException {
            if (row >= _nRows || row < 0)
                throw new LinAlgException ("Row out of bounds!");
            //create a vector and copy the values in
            Vector _newV = new Vector(_nCols);
            for (int i = 0; i<_nCols; i++)
                _newV.set(i, _vArray[row][i]);
        return _newV;
	}

	/** Set the row and col of this matrix to the provided val
	 * 
	 * @param row
	 * @param col
	 * @param val
	 * @throws LinAlgException if row or col indices are out of bounds
	 */
	public void set(int row, int col, double val) throws LinAlgException {
	    if ((row >= _nRows) || (row < 0) || (col >= _nCols) || (col < 0))
                throw new LinAlgException("Invalid index.");
            _vArray[row][col] = val;
	}
	
	/** Return a new Matrix that is the transpose of *this*, i.e., if "transpose"
	 *  is the transpose of Matrix m then for all row, col: transpose[row,col] = m[col,row]
	 *  (should not modify *this*)
	 * 
	 * @return
	 * @throws LinAlgException
	 */
	public Matrix transpose() throws LinAlgException {
            //Similar to the vector function
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
            if (size <= 0)
                throw new LinAlgException("Size is too small!");
            Matrix _nMat = new Matrix(size,size);
            for (int i = 0; i < size ; i++)
                for (int j = 0; j < size; j++)
                    if (i == j)
                        _nMat.set(i,j,1);
        return _nMat;
	}
	
	/** Returns the Matrix result of multiplying Matrix m1 and m2
	 *  (look up the definition of matrix multiply if you don't remember it)
	 * 
	 * @param m1
	 * @param m2
	 * @return
	 * @throws LinAlgException if m1 columns do not match the size of m2 rows
	 */
	public static Matrix Multiply(Matrix m1, Matrix m2) throws LinAlgException {
            if (m1.getNumCols() != m2.getNumRows())
                throw new LinAlgException ("m1 columns do not match the size of m2 rows!");
            Matrix _nMat = new Matrix(m1.getNumRows(), m2.getNumCols());
            //Nested for loops to go through the indices and multiply
            for (int j = 0; j < m2._nCols; j++)
                for (int i = 0; i < m1._nRows; i++)
                    for (int k = 0; k < m2._nRows; k++)
                    _nMat.set(j,i, _nMat.get(j,i) + m1.get(j,k)* m2.get(k,i));
        return _nMat;
	}
		
	/** Returns the Vector result of multiplying Matrix m by Vector v (assuming v is a column vector)
	 * 
	 * @param m
	 * @param v
	 * @return
	 * @throws LinAlgException if m columns do match the size of v
	 */
	public static Vector Multiply(Matrix m, Vector v) throws LinAlgException {
            if (m.getNumCols() != v.getDim())
                throw new LinAlgException ("m columns do not match the size of v!");
            Vector _nVec = new Vector (v.getDim());
            //Nested for loop to go through the indices and multiply
            for (int j = 0; j < _nVec.getDim(); j++)
                    for (int k = 0; k < _nVec.getDim(); k++)
                    _nVec.set(j, _nVec.get(j) + v.get(k)* m.get(j,k));
        return _nVec;
	}

}
