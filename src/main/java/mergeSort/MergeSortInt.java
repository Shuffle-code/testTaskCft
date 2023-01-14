package mergeSort;

// Java program to merge K sorted arrays of size n each.

class MergeSortInt {
//    static final int N = 4;

    // Merge arr1[0..n1-1] and arr2[0..n2-1] into
    // arr3[0..n1+n2-1]
    public void mergeArrays(int arr1[], int arr2[], int N1,
                            int N2, int arr3[])
    {
        int i = 0, j = 0, k = 0;

        // Traverse both array - Пройтись по обоим массивам
        while (i < N1 && j < N2) {
            // Check if current element of first
            // array is smaller than current element
            // of second array. If yes, store first
            // array element and increment first array
            // index. Otherwise do same with second array
            // Проверяем, является ли текущий элемент первым
            // массив меньше текущего элемента
            // второго массива. Если да, сначала сохраните
            // элемент массива и увеличиваем первый массив
            // индекс. В противном случае сделайте то же самое со вторым массивом
            if (arr1[i] < arr2[j])
                arr3[k++] = arr1[i++];
            else
                arr3[k++] = arr2[j++];
        }

        // Store remaining elements of first array -Сохранить оставшиеся элементы первого массива
        while (i < N1)
            arr3[k++] = arr1[i++];

        // Store remaining elements of second array
        while (j < N2)
            arr3[k++] = arr2[j++];
    }

    // A utility function to print array elements
    public void printArray(int arr[], int size)
    {
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
    }

    // This function takes an array of arrays as an argument
    // and All arrays are assumed to be sorted. It merges
    // them together and prints the final sorted output.
    //Эта функция принимает массив массивов в качестве аргумента
    // и Предполагается, что все массивы отсортированы. Он сливается
    // их вместе и выводит окончательный отсортированный вывод.
    public void mergeKArrays(int arr[][], int i, int j,
                             int output[])
    {
        // if one array is in range
        if (i == j) {
            for (int p = 0; p < arr[i].length; p++)
                output[p] = arr[i][p];
            return;
        }

        // if only two arrays are left them merge them - если осталось только два массива, они объединяют их
        if (j - i == 1) {
            mergeArrays(arr[i], arr[j], arr[i].length, arr[j].length, output);
            return;
        }

        // output arrays
        int[] out1 = new int[arr[i].length * (((i + j) / 2) - i + 1)];
        int[] out2 = new int[arr[j].length * (j - ((i + j) / 2))];

        // divide the array into halves
        mergeKArrays(arr, i, (i + j) / 2, out1);
        mergeKArrays(arr, (i + j) / 2 + 1, j, out2);

        // merge the output array
        mergeArrays(out1, out2, arr[i].length * (((i + j) / 2) - i + 1),
                arr[j].length * (j - ((i + j) / 2)), output);
    }



}

