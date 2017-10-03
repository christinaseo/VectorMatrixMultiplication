import linalg.LinAlgException;
import linalg.Matrix; // This is Matrix from the linear algebra package you are writing 
import linalg.Vector; // This is Vector from the linear algebra package you are writing 

/** This is a small example of test cases.  Write your own test cases to understand all
 *  of the methods in Matrix and Vector.  To test correctness of your implementation,  
 *  see if the output on your tests matches the results of the same tests on the solution
 *
 *  NOTE: see TestLinAlgSoln which provides results for the solution by importing 
 *        soln.Matrix and soln.Vector from the solution jar as opposed to linalg.Matrix 
 *        and linalg.Vector that you are writing.  All that changes are the import
 *        statements at the top. 
 * 
 * @author ssanner@mie.utoronto.ca
 *
 */
public class TestLinAlg {

	public static void main(String[] args) {
		try {
			// Note: you need to write your own tests, this is only a small sample and it does not
			//       test cases that throw an Exception.
			/**Vector v = new Vector("[ 1 2 3 4 5 ]");
                        
                        //v.getdim()
                        
			System.out.println("1. test constructor and toString(): " + v); // This automatically invokes v.toString()!
			System.out.println("2. test scalar addition: " + v.scalarAdd(1));
			System.out.println("3. ensure v was not modified: " + v);
			v.scalarAddInPlace(2);
			System.out.println("4. now v should be modified: " + v);
			
			Matrix m = Matrix.GetIdentity(5);
			System.out.println("5. identity matrix m:\n" + m);
			System.out.println("6. still identity after self-multiply:\n" + Matrix.Multiply(m, m)); 
			
			m.set(2, 0, 2);
			m.set(0, 2, 3);
			m.set(4, 0, 5);

			System.out.println("7. m should be modified:\n" + m); // Remember: this automatically invokes m.toString()!
			System.out.println("8. result should not be the identity:\n" + Matrix.Multiply(m, m));
			System.out.println("9. example matrix/vector multiply: " + Matrix.Multiply(m, v));
			
			Matrix m2 = new Matrix(m);
			System.out.println("10. should be equal: " + m2.equals(m));
			m2.set(0, 1, 2d);
			System.out.println("11. should not be equal: " + m2.equals(m));
                        */
                                
                        // Test the 3 types of constructors along with toString() method
			Vector v1 = new Vector("[ 1 2 3 4 5 ]");
			System.out.println("1a. test constructor (string init) and toString(): " + v1); 
                        
                        Vector v2 = new Vector(v1);
			System.out.println("1b. test constructor (copy init) and toString(): " + v2); 
                        
                        Vector v3 = new Vector(2);
			System.out.println("1c. test constructor (size init) and toString(): " + v3); 
                        
                        // Test the equals() method
			System.out.println("2a. test equals() -> should be true: " + v1.equals(v2)); 
                        System.out.println("2b. test equals() -> should be false: " + v2.equals(v3));
                        
                        //Test the getter methods: getDim() and get(index) 
                        System.out.println("3a. test getDim() of v1 -> should be 5: " + v1.getDim());
                        System.out.println("3b. test equals() -> should be 5: " + v1.get(4));
                        
                        //Test the set method: set(index, value)
                        v1.set(4, 10.0);
                        System.out.println("4. test set(5, 10.0): " + v1);
                        
                        //Test changeDim(size)
                        v1.changeDim(10);
                        System.out.println("5a. test changeDim(10): " + v1);
                        
                        //Test scalarAddInPlace(double) and scalarAdd()
                        System.out.println("6a. test scalar addition: " + v1.scalarAdd(1));
			System.out.println("6b. ensure v1 was not modified: " + v1);
			v1.scalarAddInPlace(1);
			System.out.println("6c. now v1 should be modified: " + v1);
                        
                        //Test scalarMultInPlace() and ScalarMult()
                        System.out.println("7a. test scalar multiplication: " + v2.scalarMult(2));
			System.out.println("7b. ensure v2 was not modified: " + v2);
			v2.scalarMultInPlace(2);
			System.out.println("7c. now v2 should be modified: " + v2);
                        
                        //Test elementwiseAddInPlace() and elementwiseAdd()
                        System.out.println("8a. test vector addition: " + v2.elementwiseAdd(v2));
			System.out.println("8b. ensure v2 was not modified: " + v2);
			v2.elementwiseAddInPlace(v2);
			System.out.println("8c. now v2 should be modified: " + v2);
                        
                        //Test elementwiseMultInPlace() and elementwiseMult()
                        System.out.println("9a. test vector multiplication: " + v2.elementwiseMult(v2));
			System.out.println("9b. ensure v2 was not modified: " + v2);
			v2.elementwiseMultInPlace(v2);
			System.out.println("9c. now v2 should be modified: " + v2);
                        
                        //Test InnerProd()
                        System.out.println("10. now v2 should be modified: " + v2.InnerProd(v2, v2));
                        System.out.println("\n\n________________________________________________________________\n\n");
                        
                        // Test the 2 types of matrix constructors along with toString() method
			Matrix m1 = new Matrix(2, 2);
			System.out.println("1a. test constructor (string init) and toString(): " + m1); 
                        
                        Matrix m2 = new Matrix(m1);
			System.out.println("1b. test constructor (copy init) and toString(): " + m2); 
                        
                        // Test the equals() method
			System.out.println("2a. test equals() -> should be true: " + m1.equals(m2)); 
                        System.out.println("2b. test equals() -> should be false: " + m2.equals(v3));
                        
                        //Test the getter methods: getDim() and get(index) 
                        System.out.println("3a. test getNumRows() of v1 -> should be 2: " + m1.getNumRows());
                        System.out.println("3b. test getNumCols() -> should be 2: " + m1.getNumCols());
                        System.out.println("3c. test get(row, col) -> should be 0: " + m1.get(0, 0));
                        System.out.println("3d. test get(row, col) -> should be [0, 0]: " + m1.getRow(0));
                        
                        //Test the set method: set(index, value)
                        m1.set(1, 0, 2);
                        m1.set(0, 1, 3);
			m2.set(0, 1, 3);
			m2.set(1, 1, 5);
                        System.out.println("4a. test set(): " + m1);
                        System.out.println("4b. test set(): " + m2);
                        
                        //Test GetIdentity(size) method
                        System.out.println("5a. test GetIdentity(4): " + m1.GetIdentity(4));
                        System.out.println("5b. m1 should not change: " + m1);
                        
                        //Test Multiply(m1, m2)
                        System.out.println("6a. test Matrix Multiply(m1, m2): " + m1.Multiply(m1, m2));
                        System.out.println("6b. m1 should not change: " + m1);
                        
                        //Test Multiply(m, v)
                        v3.set(0, 1);
                        v3.set(1, 1);
                        System.out.println("7a. test Matrix Multiply(m1, v3): " + m1.Multiply(m1, v3));
                        System.out.println("7b. m1 should not change: " + m1);        
                            
		} catch (LinAlgException e) {
			System.out.println("ERROR: " + e.getMessage());
			System.exit(1); // Exits the program
		}
	}

}
