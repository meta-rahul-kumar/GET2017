import java.util.Scanner;

public class Remove implements Action {

	@Override
	public void performAction(ArrayList<Integer> list) {
		int element = 0;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Element value to delete");
		element = sc.nextInt();
		if (list.remove((Object)element)) {
			System.out.println("Element Deleted !!");
		}else {
			System.out.println("Element Not Exists !!");
		}
		
		Object[] lists = list.show();
		
		System.out.print("List : ");
		for (int i = 0 ; i < list.getSize(); i++) {
			System.out.print(lists[i] + " ");
		}
		System.out.println();
	}

}
