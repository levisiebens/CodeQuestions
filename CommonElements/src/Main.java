import java.util.HashMap;
import java.util.Scanner;

// http://practice.geeksforgeeks.org/problems/common-elements/0
// Given three arrays sorted in non-decreasing order, print all common elements in these arrays.
//
//        Input:
//        First line consists of T test cases. First line of every test case consists of 3 integers N1, N2 and N3, denoting the number of elements of 3 arrays. Second, Third and Forth line of every test case conisists of elements of array1, array2 and array3 respectively.
//
//        Output:
//        Single line output, Print the common elements of array. If not possible then print -1.
//
//        Constraints:
//        1<=T<=100
//        1<=N1,N2,N3<=1000
//        1<=Ai,Bi,Ci<=1000
//
//        Example:
//        Input:
//        1
//        6 5 8
//        1 5 10 20 40 80
//        6 7 20 80 100
//        3 4 15 20 30 70 80 120
//        Output:
//        20 80

public class Main {
    public static void main(String[] args) {
        // Note that size of arr[] is considered 100 according to
        // the constraints mentioned in problem statement.
        int[] arr = new int[100];

        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        // One by one run for all input test cases
        while (t > 0)
        {
            int array1Size = sc.nextInt();
            int array2Size = sc.nextInt();
            int array3Size = sc.nextInt();

            //Populate Arrays
            int[] array1 = populateArray(array1Size, sc);
            int[] array2 = populateArray(array2Size, sc);
            int[] array3 = populateArray(array3Size, sc);

            // Compute and print result
            System.out.println(findMatches(new int [][] {array1, array2, array3} ));

            t--;
        }
    }

    private static String findMatches(int arrays[][]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int arrayCount = arrays.length;

        for(int array[] : arrays) {
            int previousValue = 0;
            for(int i = 0; i < array.length; i++ ) {
                int arrayElement = array[i];

                if(arrayElement != previousValue) {
                    Integer value = map.get(arrayElement);

                    if(value == null)
                        value = 1;
                    else
                        value++;

                    if(value == arrayCount) {
                        sb.append(String.format("%d ", arrayElement));
                    }
                    map.put(arrayElement, value);
                }

                previousValue = arrayElement;
            }
        }

        //If we have no matches, then return -1.
        if(sb.toString().equals(""))
            sb.append("-1");

        return sb.toString().trim();
    }

    private static int[] populateArray(int arraySize, Scanner sc) {
        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = sc.nextInt();
        }

        return array;
    }
}

