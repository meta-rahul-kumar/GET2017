/**
 * Class performs the Negation for float type operands
 * 
 * @author Rahul Kumar
 *
 */

public class FloatNegation implements Action {

	/**
	 * method - performAction
	 * performAction Method of Action Class
	 */
	@Override
	public void performAction() {
		float first_operand = 0;
		float result = 0;

		first_operand = Util.getFloatInput("");
		
		result = -first_operand;
		System.out.println("Negation : "+ String.format("%.2f", result));

	}

}
