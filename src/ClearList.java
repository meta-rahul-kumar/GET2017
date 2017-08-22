import java.util.Scanner;

public class ClearList implements Action {

	@Override
	public void performAction() {
		ArrayList.getInstance().clear();
		System.out.println("List Cleared !!");
		Object[] lists = ArrayList.getInstance().show();
		
		System.out.print("List : ");
		for (int i = 0 ; i < ArrayList.getInstance().size; i++) {
			System.out.print(lists[i] + " ");
		}
		System.out.println();
	}

}
