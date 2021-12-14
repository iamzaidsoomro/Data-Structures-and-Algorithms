 
public class SelectionSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Selection sort = search through an array and keep track of the minimum value during 
		//                 each iteration . At the end of each iteration , we swap variables.
		
		
		//                 Quadratic time O(n^2)
		//                 small data set = okay for that 
		//                 large data set = bad
		
		
       int[] array = {9,6,8,3,7,2,10,1};
		
       
       //calling method with argument of above array 
		SelectionSort(array);
		
		
	 //print elements of array to check the elements after Selection sorting 
		for (int i : array) {
			
			System.out.println(i);
		}
      
       
	}

	private static void SelectionSort(int[] array) {
		
 //intiated a loop with conditon length -1 for ease in comparing last and second last element 
		for (int i=0 ; i<array.length-1; i++)
		{
			int min = i;//assigned i index to min variable
			
			//intiated a nested loop for comparing array elements with each other 
			for (int j=i+1; j<array.length; j++) {
				
				
				//conditon to find index of least element 
				if(array[min] > array[j]) {
					
					min = j; //stored index of small element in min 
				}
			}
			
			int temp = array[i]; //on each iteration first value of array will be stored in temp
			array[i] = array[min];// then the first element will be replaced with minimum value found in nested loop
			array[min] = temp;  //and first element of array will be replaced with the index of minimum value
			
		}
		
	}

}
