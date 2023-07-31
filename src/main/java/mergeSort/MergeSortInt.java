package mergeSort;
import java.util.ArrayList;
public class MergeSortInt{
    public ArrayList<Integer> mergeArrays(int[][] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] ints = new int[0];
        int j = arr.length;
        while (j != 1) {
            j-= 1;
            for (int i = 0; i < arr.length; i += 1){
                if (i == arr.length - 1) {
                } else if (i == 0)  {
                    ints = mergeTwoArrays(arr[i], arr[i + 1]);
                } else ints = mergeTwoArrays(ints, arr[i + 1]);
            }
        }
        for (Integer k : ints) {
            list.add(k);
        }
        return list;
    }
    public int[] mergeTwoArrays(int[] array1, int[] array2) {
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> arr1 = new ArrayList<>();
        for (int i : array1) {
            arr1.add(i);
        }
        ArrayList<Integer> arr2 = new ArrayList<>();
        for (int i : array2) {
            arr2.add(i);
        }
        int i = 0, j = 0;
        while (i + j < arr1.size() + arr2.size()) {
            if (i != arr1.size() && (j == arr2.size() || arr1.get(i) < arr2.get(j))) {
                arr.add(arr1.get(i));
                i++;
            } else {
                arr.add(arr2.get(j));
                j++;
            }
        }
        int[] array = new int[arr.size()];
        for (int k = 0; k < array.length; k++) {
            array[k] = arr.get(k);
        }
        return array;
    }
}

