import java.util.Scanner;

public class IndexOfElement implements Action {

	@Override
	public void performAction(ArrayList<Integer> list) {
			int element = 0;
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter Element Value to get Position");
			element = sc.nextInt();
			System.out.println("Position : " + list.indexOf(element));
	}

}
