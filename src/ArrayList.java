import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ArrayList<T extends Comparable<T>> implements List<T>{
	Object list[];
	int size = 0;
	int length;
//	private static ArrayList arraylist;
//	
//	public static ArrayList getInstance() {
//
//		if (arraylist == null) {
//			synchronized (ArrayList.class) {
//				if (arraylist == null) {
//					arraylist = new ArrayList(10);
//				}
//
//			}
//		}
//
//		return arraylist;
//	}
	
	public int getSize() {
		return size;
	}
	
	public ArrayList() {
		this(10);
	}
	
	public ArrayList(int n) {
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
		boolean status = false;
		for (int i = 0; i < size ; i++) {
			if (element == list[i]) {
				position = i;
				status = true;
				break;
			}
		}
		
		if (status == true) { 
			element = list[position];
			
			for (int  j = position; j < size; j++) {
				list[j] = list[j+1];
			}
			
			size--;
		}
		
		return status;
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
		return Arrays.copyOf(list, size);
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
	
	public void mergeLists(ArrayList<T> secondList) {
		int secondListLength = secondList.getSize();
		expandList(secondListLength);
		System.arraycopy(secondList.toArray(), 0, list, size, secondListLength);
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
}
