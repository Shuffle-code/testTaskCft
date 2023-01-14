package mergeSort;

public class Main {
    public static void main(String[] args) {
        MergeSortInt mergeSortInt = new MergeSortInt();
        // Driver's code

        // Change n at the top to change number of elements
        // in an array
        int arr[][] = { { 2, 6, 12, 34 },
                { 1, 9, 20, 1000 },
                { 1, 9, 20, 1000 },
                { 23, 34, 90, 2000 } };
        int n = 0;
        for (int i = 0; i < arr.length; i++) {
            n = n  + arr[i].length;
        }

        int K = arr.length;
        int[] output = new int[n];

        // Function call
        mergeSortInt.mergeKArrays(arr, 0, arr.length - 1, output);

        System.out.print("Merged array is "
                + "\n");
        mergeSortInt.printArray(output, n);
    }
}
