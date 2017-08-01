/**
 * Class performs the Division for Integer type operands
 * 
 * @author Rahul Kumar
 *
 */

public class IntegerDivision implements Action {

	/**
	 * method - performAction
	 * performAction Method of Action Class
	 */
	@Override
	public void performAction() {
		int first_operand = 0;
		int second_operand = 0;
		int result = 0;
		
		first_operand = Util.getIntegerInput("First");
		second_operand = Util.getIntegerInput("Second");
		
		result = first_operand / second_operand;
		System.out.println("Division : "+ result);

	}

}
