import java.util.Scanner;

public class IndexOfElement implements Action {

	@Override
	public void performAction() {
			int element = 0;
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter Element Value to get Position");
			element = sc.nextInt();
			System.out.println("Position : " + ArrayList.getInstance().indexOf(element));
	}

}
