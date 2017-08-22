
public class ClearList implements Action {

	@Override
	public void performAction(ArrayList<Integer> list) {
		list.clear();
		System.out.println("List Cleared !!");
		Object[] lists = list.show();
		
		System.out.print("List : ");
		for (int i = 0 ; i < list.size(); i++) {
			System.out.print(lists[i] + " ");
		}
		System.out.println();
	}

}
