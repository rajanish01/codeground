package generalproblem;

/**
 * Given an array arr with elements from 1-N where N is size of the array, find duplicate and missing elements.
 * N = 8
 * arr[] = {3,1,2,4,2,4,7,5,5}
 * output :
 * duplicates : 2,4
 * missing : 6,8
 */
public class SwapSort {

    private static void findMissingAndDuplicate(int[] arr, int N) {
        String duplicates = "";
        String missing = "";

        for (int i = 0; i < N; i++) {
            if (arr[i] != i + 1) {
                int temp = arr[i];
                arr[i] = arr[arr[i]-1];
                arr[temp-1] = temp;
            }
        }

        for (int i = 0; i < N; i++) {
            if (arr[i] != i + 1) {
                missing = missing.concat(i + 1 + " ");
                duplicates = duplicates.concat(arr[i] + " ");
            }
        }

        System.out.println(duplicates);
        System.out.println(missing);

    }

    public static void main(String[] args) {

        int[] arr = {3, 1, 2, 4, 2, 4, 7, 5,5};
        int N = 9;
        findMissingAndDuplicate(arr, N);
    }

}
