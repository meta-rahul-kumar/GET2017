import java.util.Scanner;

public class GetElement implements Action {

	@Override
	public void performAction(ArrayList<Integer> list) {
		int position = 0;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Position to get Element");
		position = sc.nextInt();
		System.out.println("Element : " + list.get(position));
	}

}
