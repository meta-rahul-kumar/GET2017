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
	 * Adds the element at the first.
	 */
	public boolean addFirst(E element);

	/**
	 * Adds the element at the last.
	 */
	public boolean addLast(E element);

	/**
	 * Clear the linked list.
	 */
	public void clear();

	/**
	 * Contains
	 *
	 * @param element
	 *            the element
	 * @return true, if successful else false
	 */
	public boolean contains(E element);

	/**
	 * Gets the element by its index
	 */
	public E get(int index) throws IndexOutOfBoundsException;

	/**
	 * Gets the element present at first position.
	 */
	public E getFirst() throws NoSuchElementException;

	/**
	 * Gets the element from last position.
	 */
	public E getLast() throws NoSuchElementException;

	/**
	 * Get Index of Element
	 */
	public int indexOf(E element);

	/**
	 * Removes the element by its position
	 */
	public E removeByPosition(int position) throws NoSuchElementException;

	/**
	 * Removes the element
	 */
	public boolean remove(E element) throws NoSuchElementException;

	/**
	 * Removes the first element.
	 */
	public E removeFirst() throws NoSuchElementException;

	/**
	 * Removes the last element
	 */
	public E removeLast() throws NoSuchElementException;

	/**
	 * Sets the element at given index
	 */
	public E set(int index, E element) throws IndexOutOfBoundsException;

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

}
