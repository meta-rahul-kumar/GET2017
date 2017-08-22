
public class SortList implements Action {

	@Override
	public void performAction() {
		ArrayList.getInstance().reverseList();
		System.out.println("List Sorted !!");
		Object[] lists = ArrayList.getInstance().show();
		
		System.out.print("List : ");
		for (int i = 0 ; i < ArrayList.getInstance().size; i++) {
			System.out.print(lists[i] + " ");
		}
		System.out.println();
	}

}
