/**
 * class trigger an Action for specific event
 * @author User17
 *
 */
public class ActionableMenuItem extends MenuItem{
	
	Action action;

	/**
	 * method - triggerAction
	 * takes two double operand and perform an action
	 * returns double 
	 */
	public void triggerAction(ArrayList<Integer> list){
		 this.action.performAction(list);
	}

	/**
	 * Constructor - ActionableMenuItem 
	 * 
	 * @param action
	 */
	public ActionableMenuItem(Action action) {
		
		this.action = action;
	}


}
