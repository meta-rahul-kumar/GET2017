import java.util.Scanner;

public class MergeList implements Action {

	@Override
	public void performAction(ArrayList<Integer> list) {
		int element;
		char choice;
		ArrayList<Integer> arrayList = new ArrayList<>();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Enter Element in Second List");
			element = sc.nextInt();
			arrayList.add(element);
			System.out.println("Want to Enter more Elements ? [Y/N]");
			choice = sc.next().charAt(0);
			
		} while (choice == 'Y' || choice == 'y');
		
		list.mergeLists(arrayList);
		
		Object[] lists = list.show();
		
		System.out.print("List : ");
		for (int i = 0 ; i < list.getSize(); i++) {
			System.out.print(lists[i] + " ");
		}
		System.out.println();	
	}

}
