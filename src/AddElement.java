import java.util.Scanner;

public class AddElement implements Action {

	@SuppressWarnings("unchecked")
	@Override
	public void performAction() {
		int data = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Element Value");
		data = sc.nextInt();
		ArrayList.getInstance().add(data);
		
		Object[] lists = ArrayList.getInstance().show();
		
		System.out.print("List : ");
		for (int i = 0 ; i < ArrayList.getInstance().size; i++) {
			System.out.print(lists[i] + " ");
		}
		System.out.println();
	}

}
