/**
 * Class performs the Modulas for float type operands
 * 
 * @author Rahul Kumar
 *
 */

public class FloatModulas implements Action {

	/**
	 * method - performAction
	 * performAction Method of Action Class
	 */
	@Override
	public void performAction() {
		float first_operand = 0;
		float second_operand = 0;
		float result = 0;
		
		first_operand = Util.getFloatInput("First");
		second_operand = Util.getFloatInput("Second");
		
		result = first_operand % second_operand;
		System.out.println("Modulas : "+ String.format("%.2f", result));

	}

}
