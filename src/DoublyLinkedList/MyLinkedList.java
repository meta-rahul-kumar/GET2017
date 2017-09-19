package DoublyLinkedList;
import java.util.NoSuchElementException;
import javax.swing.SortOrder;

/**
 * The Interface LinkedList.
 *
 */
public interface MyLinkedList<E extends Comparable<E>> extends Iterable<E> {

	/**
	 * Adds the element at the index in linked List
	 */
	public boolean add(int index, E element) throws IndexOutOfBoundsException;

	/**
	 * Adds the element to the linked list
	 */
	public boolean add(E element);

	/**
	 * Contains
	 */
	public boolean contains(E element);

	/**
	 * Gets the element by its index
	 */
	public E get(int index) throws IndexOutOfBoundsException;

	/**
	 * Removes the element by its position
	 */
	public E removeByPosition(int position) throws NoSuchElementException;

	/**
	 * Removes the element
	 */
	public boolean remove(E element) throws NoSuchElementException;

	/**
	 *
	 * @return the size of linked list
	 */
	public int size();

	/**
	 * Reverse the linked list
	 */
	public void reverse() throws NullPointerException;

	/**
	 * Sort the linked list.
	 */
	public void sort() throws NullPointerException;

	/**
	 * Sort the linked list according to sorting order.
	 */
	public void sort(SortOrder sortOrder);

	boolean addFirst(E element);

	boolean addLast(E element);

	E getFirst() throws NoSuchElementException;

	E getLast() throws NoSuchElementException;

	E removeFirst() throws NoSuchElementException;

	E removeLast() throws NoSuchElementException;

}
