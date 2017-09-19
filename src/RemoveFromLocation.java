import java.util.Scanner;

public class RemoveFromLocation implements Action {

	@Override
	public void performAction(ArrayList<Integer> list) {
		int location = 0;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter location to remove element");
		location = sc.nextInt();
		System.out.println("Deleted Element : " + list.remove(location));
		
		Object[] lists = list.show();
		
		System.out.print("List : ");
		for (int i = 0 ; i < list.getSize(); i++) {
			System.out.print(lists[i] + " ");
		}
		System.out.println();
	}

}
