package Question6;
/**
 * Objective : Merges two Sorted Array
 * 
 * @version 1.0 13 July 2017
 * @author Rahul Kumar
 */

public class MergeArray {
	/**
	 * Method : join
	 * 
	 * Input : two arrays a,b and two integer asize,bsize tells 
	 * element in array a and b and Integer Array c
	 * 
	 * Output : return merged integer array c
	 */
	int[] join(int[] a, int asize, int[] b, int bsize, int[] c){
		int i = 0;
		int j = 0;
		int k = 0;
		int sortedFirstArray = checkSortedOrder(a);
		int sortedSecondArray = checkSortedOrder(b);
		
		if ((sortedFirstArray == 1) && (sortedSecondArray == 1)) {
			/* if both arrays are ascending sorted */
			while ((i < asize) && (j < bsize)){
				if (a[i] < b[j]){
					c[k] = a[i];
					k++;
					i++;
					
				} else {
					c[k] = b[j];
					j++;
					k++;
				}
			}
			
			while (i < asize){
				c[k] = a[i];
				k++;
				i++;
			}
			
			while (j < bsize){
				c[k] = b[j];
				k++;
				j++;
			}
		} else if ((sortedFirstArray == 2) && (sortedSecondArray == 2)) {
			/* if both arrays are descending sorted */
			while ((i < asize) && (j < bsize)){
				if (a[i] > b[j]){
					c[k] = a[i];
					k++;
					i++;
					
				} else {
					c[k] = b[j];
					j++;
					k++;
				}
			}
			
			while (i < asize){
				c[k] = a[i];
				k++;
				i++;
			}
			
			while (j < bsize){
				c[k] = b[j];
				k++;
				j++;
			}
			
			reverseArray(c);
		} else if (((sortedFirstArray == 1) && (sortedSecondArray == 2)) 
						|| ((sortedFirstArray == 2) && (sortedSecondArray == 1))) {
			/* if both arrays are sorted in different order*/
			if (sortedFirstArray == 1) {
				/* if first array is in ascending order than reverse second array */
				reverseArray(b);
			} else {
				/* if second array is in ascending order than reverse first array */
				reverseArray(a);
			}
			
			while ((i < asize) && (j < bsize)) {
				if (a[i] < b[j]){
					c[k] = a[i];
					k++;
					i++;
					
				} else {
					c[k] = b[j];
					j++;
					k++;
				}
			}
			
			while (i < asize){
				c[k] = a[i];
				k++;
				i++;
			}
			
			while (j < bsize){
				c[k] = b[j];
				k++;
				j++;
			}
		} else {
			/* if array are not sorted */
			System.out.println("Array are Not Sorted.");
		}
		
		return c;
	}
	
	/**
	 * Method : reverseArray
	 * 
	 * Input : integer array a
	 * Output : return reversed integer array
	 */
	int[] reverseArray(int[] a) {
		for (int i = 0; i < a.length / 2; i++) {
			a[i] = a[a.length - i - 1] + a[i];
			a[a.length - i - 1] = a[i] - a[a.length - i - 1];
			a[i] = a[i] - a[a.length - i - 1];	
		}
		
		return a;
	}
	
	/**
	 * Method : checkSortedOrder
	 * 
	 * Input : an Integer Array of Inputs
	 * Output : type of sorting 1 => Ascending , 2 => Descending , None => 0
	 */
	int checkSortedOrder(int[] a) {
		int flagAsc = 0;
		int flagDesc = 0;
		int result=0;
		
		for (int i = 1; i < a.length; i++){
			if (a[i] > a[i - 1]){
				flagAsc++;
			} else if (a[i] < a[i - 1]){
				flagDesc++;
			}
		}
		
		if (flagAsc == a.length - 1){
			result = 1;
		} else if (flagDesc == a.length - 1){
			result = 2;
		}
		
		return result;
	}
}
