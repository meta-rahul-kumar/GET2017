import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ArrayList<T extends Comparable<T>> implements List<T>{
	Object list[];
	static int size = 0;
	static int length;
	ArrayList() {
		
	}
	
	ArrayList(int n) {
		list = new Object[n];
		length = n;
	}
	
	@Override
	public boolean add(T element) {
		if (list.length - size == 0) {
			increaseSize();
		}
		
		list[size++] = element;
		return true;
	}

	@Override
	public void add(int index, T element) {
		if (list.length - size == 0) {
			increaseSize();
		}
		
		for (int i = size; i >= index ; i--) {
			list[i+1] = list[i];
		}
		
		list[index] = element; 
		size++;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		list = (T[]) new Comparable[length];
		size = 0;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {
		T element = null;
		if (index < 0 || index > size) {
			
		}else {
			element = (T) list[index];
		}
			
		return element;
	}

	@Override
	public int indexOf(Object element) {
		int position = -1;
		
		for (int i = 0; i < size; i++) {
			if (element == list[i]) {
				position = i;
				break;
			}
		}
		return position;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<T> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object element) {
		int position = -1;
		for (int i = 0; i < size ; i++) {
			if (element == list[i]) {
				position = i;
				break;
			}
		}
		
		element = list[position];
		
		for (int  j = position; j < size; j++) {
			list[j] = list[j+1];
		}
		
		size--;
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T remove(int index) {
		T element = null;
		if (index < 0 || index > size) {
			element = null;
		} else {
			element = (T) list[index];
			for (int i = index; i < size ; i++) {
				list[i] = list[i+1];
			}
			
			size--;
		}
		return element;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T set(int index, T element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("hiding")
	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public void reverseList() {
		for (int i = 0; i <= (size-1) / 2; i++) {
			@SuppressWarnings("unchecked")
			T temp = (T) list[i];
			list[i] = list[size - 1 - i];
			list[size - 1 - i] = temp;
		}
	}
	
	public void mergeLists(Object[] secondList) {
		int secondListLength = secondList.length;
		expandList(secondListLength);
		System.arraycopy(secondList, 0, list, size, secondListLength);
		size = size + secondListLength;
		
		
	}
	private void expandList(int secondListLength) {
		list = Arrays.copyOf(list, list.length + secondListLength);
		
	}

	public void sort() {
		for (int index1 = 0; index1 < size - 1; index1++) {
			for (int index2 = index1 + 1; index2 < size; index2++) {
				if (get(index1).compareTo(get(index2)) > 0) {
					@SuppressWarnings("unchecked")
					T element = (T) list[index1];
					list[index1] = list[index2];
					list[index2] = element;
				}
			 }
		}
	}
	
	public Object[] show() {
		return list;
	}
	
	private void increaseSize() {
		list = Arrays.copyOf(list, list.length * 2);
		System.out.println("Current Length : " + list.length);
		
	}
	

	public static void main(String args[]) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>(10);
		arrayList.add(new Integer(1));
		arrayList.add(new Integer(2));
		arrayList.add(new Integer(3));
		arrayList.add(new Integer(4));
		arrayList.add(new Integer(5));
		arrayList.add(new Integer(6));
		arrayList.add(new Integer(7));
		arrayList.add(new Integer(8));
		arrayList.add(new Integer(9));
		arrayList.add(new Integer(1));
		arrayList.add(new Integer(2));
	
		
		
		Object list[] = arrayList.show();
		
		for (int i = 0 ; i < size; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println();
		
		arrayList.add(2, 9);
		
		list = arrayList.show();
		
		for (int i = 0 ; i < size; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println();
		
		arrayList.add(0, 8);
		
		list = arrayList.show();
		
		for (int i = 0 ; i < size; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println();
		
		int element = 9;
		int location = 0;
		Integer retrivedElement = arrayList.get(location);
		
		if (retrivedElement == null) {
			System.out.println("No element found");
		} else {
			System.out.println("Element " + retrivedElement + " occures at position "+ location);
		}
		
		int position = arrayList.indexOf(element);
		
		if (position == -1) {
			System.out.println("Element " + element + " is not in arrayList");
		} else {
			System.out.println("Element " + element + " occures at position "+ position);
		}
		
		System.out.println();
		
		location = 3;
		Object deletedElement = arrayList.remove(location);
		
		if (deletedElement == null) {
			System.out.println("Please Enter a valid location");
		} else {
			System.out.println("deleted Element : " + deletedElement);
		}
		
		list = arrayList.show();
		
		for (int i = 0 ; i < size; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println();
		
		//////////////////////////////////////////////
		
		element = 7;
		deletedElement = arrayList.remove(element);
		
		if (deletedElement == null) {
			System.out.println("Please Enter a valid element");
		} else {
			System.out.println("deleted Element : " + deletedElement);
		}
		
		list = arrayList.show();
		
		for (int i = 0 ; i < size; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println();
		
		//////////////////////////////////////////////////
//		arrayList.clearList();
//		
//		System.out.println("List  :");
//		list = arrayList.show();
//		
//		for (int i = 0 ; i < size; i++) {
//			System.out.print(list[i] + " ");
//		}
//		System.out.println();
		
		///////////////////////////////////////////////////
		
		arrayList.reverseList();
		list = arrayList.show();
		
		for (int i = 0 ; i < size; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println();
		
		arrayList.sort();
		
		System.out.println("Sorted Array : ");
		list = arrayList.show();
		
		for (int i = 0 ; i < size; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println();
		
		Object[] secondList = {11,12,13}; 
		arrayList.mergeLists(secondList);
		
		System.out.println("Merged Array : ");
		list = arrayList.show();
		
		for (int i = 0 ; i < size; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println();
	}
}
