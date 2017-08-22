import java.util.Scanner;

public class GetElement implements Action {

	@SuppressWarnings({ "unchecked", "static-access" })
	@Override
	public void performAction() {
		int position = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Position to get Element");
		position = sc.nextInt();
		System.out.println("Element : " + ArrayList.getInstance().get(position));
	}

}
