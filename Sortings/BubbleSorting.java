
public class BubbleSorting {

	public static void main(String[] args) {
		/* Bubble sort = in Bubble sorting  pairs of adjacent elements are compared , and the elements 
		              swapped if they are not in order its Quadrati time is o(n^2) it is okay for the 
		               smalls datasets but bad on sorting large data sets 
		 */
		
		
		
		
		//declared an array with unordered numbers 
		int[] array = {9,6,8,3,7,2,10,1};
		
		BubbleSort(array);
		
		
		//printing to check sorted elements 
		for (int i : array) {
			
			System.out.println(i);
		}

	}

	private static void BubbleSort(int[] array) {

       //loop for traversing all n elements of an array 
		for (int i=0; i<array.length; i++) {
			
			//intiated a nested loop with conditon (n - i -1) and this will swap the largest element to right
			for ( int j = 0; j<array.length-i-1; j++) {
				
				//conditon for comparing adjacent elements
				if(array[j] > array[j+1]) {
					
					int temp = array[j];  //if element with least index is larger will move to temp variable    
					array[j] = array[j+1];//then shortest element will be stored in least index 
					array[j+1] = temp;//and at the end swapping largest value in higher index
					
				}
			}
		}
		
	}

}
