import java.util.Scanner;

public class AddElement implements Action {

	@Override
	public void performAction(ArrayList<Integer> list) {
		int data = 0;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Element Value");
		data = sc.nextInt();
		list.add(data);
		
		Object[] lists = list.show();
		
		System.out.print("List : ");
		for (int i = 0 ; i < list.size; i++) {
			System.out.print(lists[i] + " ");
		}
		System.out.println();
	}

}
