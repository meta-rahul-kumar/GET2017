import java.util.InputMismatchException;
import java.util.Scanner;

public class Util implements Action{
	static final Scanner sc = new Scanner(System.in);
	
	public static int getIntegerInput(String name) {
		int first_operand = 0;
		while(true) {
		    try
		    {
		    	System.out.println("Enter "+ name +" Number");
				first_operand = Util.sc.nextInt();
				break;
		    } 
		    catch (InputMismatchException y)
		    {
			    System.out.println("You must enter a number.");
			    Util.sc.nextLine();

		    }  
		}  
		
		return first_operand;

	}

	public static float getFloatInput(String name) {
		float first_operand = 0;
		while(true) {
		    try
		    {
		    	System.out.println("Enter "+ name +" Number");
				first_operand = Util.sc.nextFloat();
				break;
		    } 
		    catch (InputMismatchException y)
		    {
			    System.out.println("You must enter a number.");
			    Util.sc.nextLine();

		    }  
		}  
		
		return first_operand;
	}

	@Override
	public void performAction() {
		
		
	}
	
	
}
