package Question1;

import java.util.Scanner;

/**
 * class adds the button and regions in the calculator windows
 * 
 * @version 1.0 19 July 2017
 * @author User17
 *
 */

public class Calculator implements Operations{
	
	/*
	 * defination of addOperation
	 * (non-Javadoc)
	 * @see Question1.Operations#addOperation(double, double)
	 */
	public double addOperation(double firstOperand, double secondOperand) {
		double result = firstOperand + secondOperand;
		
		return result;
	}
	
	/*
	 * defination of subtractOperation
	 * (non-Javadoc)
	 * @see Question1.Operations#subtractOperation(double, double)
	 */
	public double subtractOperation(double firstOperand, double secondOperand) {
		double result = firstOperand - secondOperand;
		
		return result;
	}
	
	/*
	 * defination of multiplicationOperation
	 * (non-Javadoc)
	 * @see Question1.Operations#multiplicationOperation(double, double)
	 */
	public double multiplicationOperation(double firstOperand, double secondOperand) {
		double result = firstOperand * secondOperand;
		
		return result;
	}
	
	/*
	 * defination of divisionOperation
	 * (non-Javadoc)
	 * @see Question1.Operations#divisionOperation(double, double)
	 */
	public double divisionOperation(double firstOperand, double secondOperand) {
		double result = firstOperand / secondOperand;
		
		return result;
	}
	
	/*
	 * defination of modOperation
	 * (non-Javadoc)
	 * @see Question1.Operations#modOperation(double, double)
	 */
	public double modOperation(double firstOperand, double secondOperand) {
		double result = firstOperand % secondOperand;
		
		return result;
	}
	
	/*
	 * defination of negation operation
	 * (non-Javadoc)
	 * @see Question1.Operations#negationOperation(double)
	 */
	public double negationOperation(double firstOperand) {
		double result = -firstOperand;
		
		return result;
	}
	
	public double getInput(String number) {
		Scanner input = new Scanner(System.in);
		double operand = 0;
		
		do{
			try {
	        	System.out.print("Please Enter The "+ number +" Number: ");
		        operand = input.nextDouble();
		        break;
			}catch(Exception e) {
				System.out.println("It Must be a Number.");
				input.nextLine();
			}
		}while(true);
		
		input.close();
		return operand;
	}
	
	public static void main(String[] args) {
		 Calculator calculator = new Calculator();
		 Display viewAnser = new Display();
		 Buttons button = new Buttons();
		 Scanner input = new Scanner(System.in);
		 double firstOperand = 0;
		 double secondOperand = 0;
		 char choice;
		 int userChoice = 0;
		 String currentAnswer = null;
		 double answer = 0;
	        
	        do {
	        	System.out.println(button.showButton());
		        System.out.println("Please Select Operation to Perform:");
		        System.out.println("1-Addition");
		        System.out.println("2-Subtraction");
		        System.out.println("3-Division");
		        System.out.println("4-Multiplication");
		        System.out.println("5-Modulas");
		        System.out.println("6-Negation");
		        
		        do{
					try {
						 userChoice = input.nextInt();
					}catch(Exception e) {
						System.out.println("It Must be an Integer and greater than 0. Please Try Again");
						userChoice = 0;
						input.nextLine();
					}
					if (userChoice <= 0 || userChoice > 6) {
						System.out.println("Wrong Choice. Please Try Again");
						continue;
					}else {
						break;
					}
				} while (true);
	
		        switch (userChoice){
		        case 1:
			        if(currentAnswer == null) {
			        	// operation has no old answer
			        	do {
			        		try {
					        	System.out.print("Please Enter The First Number: ");
						        firstOperand = input.nextDouble();
						        System.out.print("Please Enter The Second Number: ");
						        secondOperand = input.nextDouble();
						        break;
			        		} catch (Exception e) {
			        			System.out.println("Operand Must be Number.");
			        			input.nextLine();
			        		}
			        	}while(true);
			        	answer = calculator.addOperation(firstOperand, secondOperand);
			        } else {
			        	// operation has old answer
			        	do {
			        		try {
					        	System.out.print("Please Enter The First Number: ");
						        secondOperand = input.nextDouble();
						        break;
			        		} catch (Exception e) {
			        			System.out.println("Operand Must be Number.");
			        			input.nextLine();
			        		}
			        	}while(true);
			        	answer = calculator.addOperation(Double.parseDouble(currentAnswer), secondOperand);
			        }
		            break;
		            
		        case 2:
		        	if(currentAnswer == null) {
		        		// operation has no old answer
		        		do {
			        		try {
					        	System.out.print("Please Enter The First Number: ");
						        firstOperand = input.nextDouble();
						        System.out.print("Please Enter The Second Number: ");
						        secondOperand = input.nextDouble();
						        break;
			        		} catch (Exception e) {
			        			System.out.println("Operand Must be Number.");
			        			input.nextLine();
			        		}
			        	}while(true);
				        answer = calculator.subtractOperation(firstOperand, secondOperand);
		        	} else {
		        		// operation has no old answer
		        		do {
			        		try {
					        	System.out.print("Please Enter The First Number: ");
						        secondOperand = input.nextDouble();
						        break;
			        		} catch (Exception e) {
			        			System.out.println("Operand Must be Number.");
			        			input.nextLine();
			        		}
			        	}while(true);
			        	answer = calculator.subtractOperation(Double.parseDouble(currentAnswer), secondOperand);
		        	}
		            break;
		            
		        case 3:
		        	if(currentAnswer == null) {
		        		// operation has no old answer
		        		do {
			        		try {
					        	System.out.print("Please Enter The First Number: ");
						        firstOperand = input.nextDouble();
						        System.out.print("Please Enter The Second Number: ");
						        secondOperand = input.nextDouble();
						        break;
			        		} catch (Exception e) {
			        			System.out.println("Operand Must be Number.");
			        			input.nextLine();
			        		}
			        	}while(true);
				        answer = calculator.divisionOperation(firstOperand, secondOperand);
		        	} else {
		        		// operation has no old answer
		        		do {
			        		try {
					        	System.out.print("Please Enter The First Number: ");
						        secondOperand = input.nextDouble();
						        break;
			        		} catch (Exception e) {
			        			System.out.println("Operand Must be Number.");
			        			input.nextLine();
			        		}
			        	}while(true);
			        	answer = calculator.divisionOperation(Double.parseDouble(currentAnswer), secondOperand);
		        	}
		            break;
		            
		        case 4:
		        	if(currentAnswer == null) {
		        		// operation has no old answer
		        		do {
			        		try {
					        	System.out.print("Please Enter The First Number: ");
						        firstOperand = input.nextDouble();
						        System.out.print("Please Enter The Second Number: ");
						        secondOperand = input.nextDouble();
						        break;
			        		} catch (Exception e) {
			        			System.out.println("Operand Must be Number.");
			        			input.nextLine();
			        		}
			        	}while(true);
				        answer = calculator.multiplicationOperation(firstOperand, secondOperand);
		        	} else {
		        		// operation has no old answer
		        		do {
			        		try {
					        	System.out.print("Please Enter The First Number: ");
						        secondOperand = input.nextDouble();
						        break;
			        		} catch (Exception e) {
			        			System.out.println("Operand Must be Number.");
			        			input.nextLine();
			        		}
			        	}while(true);
			        	answer = calculator.multiplicationOperation(Double.parseDouble(currentAnswer), secondOperand);
		        	}
		            break;
		            
		        case 5:
		        	if(currentAnswer == null) {
		        		// operation has no old answer
		        		do {
			        		try {
					        	System.out.print("Please Enter The First Number: ");
						        firstOperand = input.nextDouble();
						        System.out.print("Please Enter The Second Number: ");
						        secondOperand = input.nextDouble();
						        break;
			        		} catch (Exception e) {
			        			System.out.println("Operand Must be Number.");
			        			input.nextLine();
			        		}
			        	}while(true);
				        answer = calculator.modOperation(firstOperand, secondOperand);
		        	} else {
		        		// operation has no old answer
		        		do {
			        		try {
					        	System.out.print("Please Enter The First Number: ");
						        secondOperand = input.nextDouble();
						        break;
			        		} catch (Exception e) {
			        			System.out.println("Operand Must be Number.");
			        			input.nextLine();
			        		}
			        	}while(true);
			        	answer = calculator.modOperation(Double.parseDouble(currentAnswer), secondOperand);
		        	}
		            break;
		            
		        case 6:
		        	if(currentAnswer == null) {
		        		// operation has no old answer
		        		do {
			        		try {
					        	System.out.print("Please Enter The First Number: ");
						        firstOperand = input.nextDouble();
						        break;
			        		} catch (Exception e) {
			        			System.out.println("Operand Must be Number.");
			        			input.nextLine();
			        		}
			        	}while(true);
				        answer = calculator.negationOperation(firstOperand);
		        	} else {
		        		// operation has no old answer
		        		answer = calculator.negationOperation(Double.parseDouble(currentAnswer));
		        	}
		        	break;
		        default:
		        		System.out.println("Choice must be between 1 and 6");
		        }
		        
		        currentAnswer = Double.toString(viewAnser.displayResult(answer));
		        System.out.println(viewAnser.displayResult(answer));
		        System.out.println("Want to continue with current Answer ? Y/N ");
		        input.nextLine();
		        choice = input.nextLine().charAt(0);
		        
	        }while(choice == 'y' || choice == 'Y');
	        input.close();
	}
}
