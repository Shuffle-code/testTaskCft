package mergeSort;

import java.util.ArrayList;
import java.util.Arrays;

public class MargeSortString{
    public ArrayList<String> mergeArrays(String[][] arr)  {
        ArrayList<String> list = new ArrayList<>();
        String[] ints = new String[0];
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
        list.addAll(Arrays.asList(ints));
        return list;
    }
    public String[] mergeTwoArrays(String[] array1, String[] array2) {
        ArrayList<String> arr = new ArrayList<>();
        ArrayList<String> arr1 = new ArrayList<>();
        arr1.addAll(Arrays.asList(array1));
        ArrayList<String> arr2 = new ArrayList<>();
        arr2.addAll(Arrays.asList(array2));
        int i = 0, j = 0;
        while (i + j < arr1.size() + arr2.size()) {
            if (i != arr1.size() && (j == arr2.size() || compareStrings(arr1.get(i), arr2.get(j)) < 0  )) {
                arr.add(arr1.get(i));
                    i++;
                } else {
                    arr.add(arr2.get(j));
                    j++;
                }
        }
        String[] array = new String[arr.size()];
        for (int k = 0; k < array.length; k++) {
            array[k] = arr.get(k);
        }
        return array;
    }


    public int compareStrings(String word1, String word2)
    {
        for(int i = 0; i < Math.min(word1.length(), word2.length()); i++)
        {
            if((int)word1.charAt(i) != (int)word2.charAt(i))
                return (int)word1.charAt(i) - (int)word2.charAt(i);
        }
        if(word1.length() != word2.length())
            return word1.length() - word2.length();
        else
            return 0;
    }


}
