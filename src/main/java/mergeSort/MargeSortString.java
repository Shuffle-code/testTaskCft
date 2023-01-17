package mergeSort;

import java.util.ArrayList;

public class MargeSortString {

    public ArrayList<String> mergeNArrays(String[][] arr) {
        ArrayList<String> list = new ArrayList<>();
        String[] ints = new String[0];
        int j = arr.length;
        while (j != 1) {
            j-= 1;
            for (int i = 0; i < arr.length; i += 2){ //or i += 2
                if (i == arr.length - 1) {
                } else if (i == 0)  {
                    ints = mergeTwoArrays(arr[i], arr[i + 1]);
                } else ints = mergeTwoArrays(ints, arr[i + 1]);
            }
        }
        for (String k : ints) {
            list.add(k);
        }
        return list;
    }

    public String[] mergeTwoArrays(String[] array1, String[] array2) {
        ArrayList<String> arr = new ArrayList<>();
        ArrayList<String> arr1 = new ArrayList<>();
        for (String i : array1) {
            arr1.add(i);
        }
        ArrayList<String> arr2 = new ArrayList<>();
        for (String i : array2) {
            arr2.add(i);
        }
        int i = 0, j = 0;
        while (i + j < arr1.size() + arr2.size()) {
            if (i != arr1.size() && (j == arr2.size() || compareStrings(arr1.get(i), arr2.get(j)) < 0  )) {
//                if (i != arr1.size() && (j == arr2.size() || arr1.get(i) < arr2.get(j))) {

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
    public String[] stringArraySort(String[] words)
    {
        for(int i = 0; i < words.length - 1; i++)
        {
            for(int j = i+1; j < words.length; j++)
            {
                if(compareStrings(words[i], words[j]) > 0)//words[i] is greater than words[j]
                {
                    String temp = words[i];
                    words[i] = words[j];
                    words[j] = temp;
                }
            }
        }
        return words;
    }

//    public static void main(String[] args) throws Exception
//    {
//        // Custom string input
//        String str = "geeksforgeeks";
//        // Converting string into an array for computation
//        char arr[] = str.toCharArray();
//        // Nested loops for comparison of characters
//        // in above character array
//        char temp;
//        int i = 0;
//        while (i < arr.length) {
//            int j = i + 1;
//            while (j < arr.length) {
//                if (arr[j] < arr[i]) {
//
//                    // Comparing the characters one by one
//                    temp = arr[i];
//                    arr[i] = arr[j];
//                    arr[j] = temp;
//                }
//                j += 1;
//            }
//            i += 1;
//        }
//        // By now loop is done means we have
//        // iterated the whole array
//        System.out.println(arr);
//    }
}
