/**
 * Class performs the Negation for Integer type operands
 * 
 * @author Rahul Kumar
 *
 */

public class IntegerNegation implements Action {

	/**
	 * method - performAction
	 * performAction Method of Action Class
	 */
	@Override
	public void performAction() {
		int first_operand = 0;
		int result = 0;
		
		first_operand = Util.getIntegerInput("");
		
		result = -first_operand;
		System.out.println("Negation : "+ result);

	}

}
