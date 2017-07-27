package Question1;

/**
 * interface having prototypes of diffrent calculator operations
 * 
 * @version 1.0 19 July 2017
 * @author User17
 *
 */
public interface Operations {
	
	/**
	 * prototype of add operation of calculator
	 * 
	 * @param firstOperand
	 * @param secondOperand
	 * @return
	 */
	public double addOperation(double firstOperand, double secondOperand);
	
	/**
	 * prototype of subtract operation of calculator
	 * 
	 * @param firstOperand
	 * @param secondOperand
	 * @return
	 */
	public double subtractOperation(double firstOperand, double secondOperand);
	
	/**
	 * prototype of multiplication operation of calculator
	 * 
	 * @param firstOperand
	 * @param secondOperand
	 * @return
	 */
	public double multiplicationOperation(double firstOperand, double secondOperand);
	
	/**
	 * prototype of division operation of calculator
	 * 
	 * @param firstOperand
	 * @param secondOperand
	 * @return
	 */
	public double divisionOperation(double firstOperand, double secondOperand);
	
	/**
	 * prototype of modulas operation of calculator
	 * 
	 * @param firstOperand
	 * @param secondOperand
	 * @return
	 */
	public double modOperation(double firstOperand, double secondOperand);
	
	/**
	 * prototype of negation operation of calculator
	 * 
	 * @param firstOperand
	 * @return
	 */
	public double negationOperation(double firstOperand);
}
