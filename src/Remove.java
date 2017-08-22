import java.util.Scanner;

public class Remove implements Action {

	@Override
	public void performAction() {
		int element = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Element value to delete");
		element = sc.nextInt();
		if (ArrayList.getInstance().remove((Object)element)) {
			System.out.println("Element Deleted !!");
		}else {
			System.out.println("Element Not Exists !!");
		}
		
		Object[] lists = ArrayList.getInstance().show();
		
		System.out.print("List : ");
		for (int i = 0 ; i < ArrayList.getInstance().size; i++) {
			System.out.print(lists[i] + " ");
		}
		System.out.println();
	}

}
