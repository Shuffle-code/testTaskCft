package handlerFile;

import io.Read;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
public class HandlerInFile  {
    Path pathInt;
    public HandlerInFile(Path pathInt) {
        this.pathInt = pathInt;
    }
    private final Read read = new Read();
    public ArrayList<String> handlerFile(String[] args) {
            ArrayList<String> stringArrayList = new ArrayList<>();
            for (int i = 2; i < args.length; i++) {
                if (!args[i].equals("out.txt")){
                    File file = new File(String.valueOf(pathInt.resolve(args[i])));
                    if(file.exists()){
                        stringArrayList.add(args[i]);
                    } else System.out.printf("Файла - %s, не  существует!", args[i]);
                }
            }
            return stringArrayList;
        }
    public int[][] createIntArray(ArrayList<String> listNameFile){
//        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        int size = listNameFile.size();
        Integer[][] arrayForSort = new Integer[size][];
        for (int i = 0; i < size; i++) {
//            System.out.println("Должно быть назввние файла из cml: " + listNameFile.get(i) + ", Это длина элементов в этом файде: " );
            ArrayList<Integer> arrayList = convertArrayStrToInteger(read.readFileUsingBufferedReader(listNameFile.get(i)));
            arrayForSort[i] = arrayList.toArray(new Integer[arrayList.size()]);
        }
        int[][] ints = doDArrayIntFromInteger(arrayForSort);
        return ints;
    }
    public ArrayList<Integer> convertArrayStrToInteger(ArrayList<String> stringArray) {
        ArrayList<Integer> result = new ArrayList<>();
        for(String stringValue : stringArray) {
            try {
                result.add(Integer.parseInt(stringValue));
            } catch(NumberFormatException nfe) {
                System.out.println("Could not parse " + nfe);
            }
        }
        return result;
    }
    public int[][] doDArrayIntFromInteger(Integer[][] arr) {
        Integer[][] matrix = arr;
        int[][] arrInt = new int[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            arrInt[i] = Arrays.stream(arr[i]).mapToInt(Integer::intValue).toArray();
        }
        return arrInt;
    }
}



