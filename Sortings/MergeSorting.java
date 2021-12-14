

public class MergeSorting {

    public static void main(String[] args) {

          //mergesort = recursively divide array in 2 , then it sorts the elements according to conditon  , re-combine
          //run-time complexity = O(n log n)
           //space complexity = O(n)

        int[] array = {8,7,5,4,3,2,1,6,9,10};


        //calling merge sorting method  with argument of an above array
        mergeSorting(array);


        //displaying each elements
        for (int i : array){

            System.out.println(i);
        }
    }


    private static void mergeSorting(int[] array) {

        int length = array.length;          //length holds the length of array
        int middle = array.length / 2;     //it holds length till mid value of array
        int[] leftarray = new int[middle]; //declared an array for holding left portion of array with size of middle
        int[] rightarray = new int[length-middle];    //declared an array for holding right portion of an array
        int i=0;                          //for traversing left array
        int j=0;                         //for right array



        //if lenght of array reaches 1 the recursion will be stopped by returning one at the end
        if (array.length <= 1)  return;

        //intiated a loop for dividing array into two portions
        for (; i<length; i++){

            if (i<middle){                //set a conditon for elements till middle length
                                          //element till middle length  will be stored in left array
                leftarray[i] = array[i];
            } else {

                //elements which lies after middle length will be transfered to right array
                rightarray[j] = array[i];
                j++; // necessary increament as J is not part of the loop
            }
        }


        //called a recursive methods for further divison of left and right arrays
        mergeSorting(leftarray);
        mergeSorting(rightarray);
        //at the end called mergeit mehtod for sorting and recombining
        mergeit(leftarray, rightarray, array);
    }


    //this method contains three arguments ,two divided arrays and , one is main array with full lenght

    private static void mergeit(int[] leftarray, int[] rightarray, int[] array) {

        int l=0 ; //will traverse left array
        int r=0;   //will traverse right array
        int i=0;   //for combined main array


        //initiated a while loop
        while ( l < leftarray.length && r<rightarray.length){

            //will check for the least value in left
            if(leftarray[l] < rightarray[r]){

                //then least value of left array will be stored in start of the main array
                array[i] = leftarray[l];
                l++;
            }
            else {

                array[i] = rightarray[r]; //else the least values of right array will be stored in main array 
                r++;
            }
            i++;
        }

        while (l<leftarray.length){

            array[i] = leftarray[l];   //recombining leftarray into main array 
            l++;
            i++;
        }

        while (r < rightarray.length){
            array[i] = rightarray[r];  //recombining right array into main array 
            r++;
            i++;
        }

    }
}
