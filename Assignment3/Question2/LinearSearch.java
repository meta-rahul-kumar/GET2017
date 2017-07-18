/**
 * Class performs linear search on an input array.
 * 
 * @version 1.0 17 July 2017
 * @author Rahul Kumar
 */
package Question2;

public class LinearSearch {
	/*
	 * Method - linearSearch
	 * input - integer input array,integer search element,integer lower index, integer upper index
	 * output - return result of search in integer
	 */
	int linearSearch(int input[],int search,int indexOfLower, int indexOfUpper) {
		if(indexOfLower > indexOfUpper) {
			return -1;
		}
		
		if(input[indexOfLower]==search) {
			return indexOfLower;
		}
		return linearSearch(input, search, indexOfLower+1, indexOfUpper);
	}
	
	public static void main(String args[]) {
		LinearSearch ls=new LinearSearch();
		int input[]= {1,2,2,3,4,5};
		int indexOfLower=0;
		int indexOfUpper=input.length-1;
		int search=3;
		System.out.println(ls.linearSearch(input, search, indexOfLower, indexOfUpper));
	}
}
