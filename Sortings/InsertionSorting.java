package Sortings;

public class InsertionSorting {

    public static void main(String[] args) {

        // insertion sort = after comparing elements to the left shift elements to the
        // right
        // to make room to insert a value

        // Quadratic time o(n^2)
        // small data set = Decent
        // large data set = bad
        // less steps than bubble sort
        // best case is o(n) compared to selection sort 0(n^2)

        int array[] = { 9, 4, 3, 2, 7, 5, 8, 1, 6 };

        Insert(array);

        for (int i : array) {

            System.out.println(i + " ");
        }
    }

    private static void Insert(int[] array) {

        for (int i = 1; i < array.length; i++) {

            int temp = array[i]; // since loops starts with one 2nd value of 1st iteration will be passed in temp
                                 // variable

            int j = i - 1; // then we minus i so that we shift previos indexes to right if they are greater

            while (j >= 0 && array[j] > temp) { // set the conditon that if the previous[index] are greater

                array[j + 1] = array[j];// then shift them to next[index+1]
                j--;
            }

            array[j + 1] = temp;// decreamented in while loop thats why j+1 here and we passed least from temp
                                // to again to left

        }
    }

}
