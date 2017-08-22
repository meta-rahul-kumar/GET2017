import java.util.Scanner;

public class RemoveFromLocation implements Action {

	@Override
	public void performAction() {
		int location = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter location to remove element");
		location = sc.nextInt();
		System.out.println("Deleted Element : " + ArrayList.getInstance().remove(location));
		
		Object[] lists = ArrayList.getInstance().show();
		
		System.out.print("List : ");
		for (int i = 0 ; i < ArrayList.getInstance().size; i++) {
			System.out.print(lists[i] + " ");
		}
		System.out.println();
	}

}
