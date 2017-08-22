import java.util.Scanner;

public class AddElementWithPosition implements Action {

	@Override
	public void performAction(ArrayList<Integer> list) {
		int data = 0;
		int position = 0;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Element Value");
		data = sc.nextInt();
		System.out.println("Enter Position to Add");
		position = sc.nextInt();
		list.add(position,data);
		
		Object[] lists = list.show();
		
		System.out.print("List : ");
		for (int i = 0 ; i < list.getSize(); i++) {
			System.out.print(lists[i] + " ");
		}
		System.out.println();
	}

}
