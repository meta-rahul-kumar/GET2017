/**
 * Class performs the addition for Integer type operands
 * 
 * @author Rahul Kumar
 *
 */

public class IntegerAddition implements Action{

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
		
		result = first_operand + second_operand;
		System.out.println("Addition : "+ result);
		
	}
	
	
}
