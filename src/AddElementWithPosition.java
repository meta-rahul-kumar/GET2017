import java.util.Scanner;

public class AddElementWithPosition implements Action {

	@SuppressWarnings({ "unchecked", "static-access" })
	@Override
	public void performAction() {
		int data = 0;
		int position = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Element Value");
		data = sc.nextInt();
		System.out.println("Enter Position to Add");
		position = sc.nextInt();
		ArrayList.getInstance().add(position,data);
		
		Object[] lists = ArrayList.getInstance().show();
		
		System.out.print("List : ");
		for (int i = 0 ; i < ArrayList.getInstance().size; i++) {
			System.out.print(lists[i] + " ");
		}
		System.out.println();
	}

}
