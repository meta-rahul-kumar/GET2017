
public class SortList implements Action {

	@Override
	public void performAction(ArrayList<Integer> list) {
		list.reverseList();
		System.out.println("List Sorted !!");
		Object[] lists = list.show();
		
		System.out.print("List : ");
		for (int i = 0 ; i < list.getSize(); i++) {
			System.out.print(lists[i] + " ");
		}
		System.out.println();
	}

}
