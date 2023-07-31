package handlerFile;
import io.Read;
import java.nio.file.Path;
import java.util.*;

public class HandlerIntFile{
    final Path pathInt;
    public HandlerIntFile(Path pathInt) {
        this.pathInt = pathInt;
    }
    private final Read read = new Read();
    public int[][] createIntArray(ArrayList<String> listNameFile){
        int size = listNameFile.size();
        Integer[][] arrayForSort = new Integer[size][];
        for (int i = 0; i < size; i++) {
            ArrayList<Integer> arrayList = convertArrayStrToInteger(read.readFileUsingBufferedReader(listNameFile.get(i), pathInt));
            arrayList.sort(Comparator.naturalOrder());
            arrayForSort[i] = arrayList.toArray(new Integer[arrayList.size()]);
        }
        return doDArrayIntFromInteger(arrayForSort);
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
        int[][] arrInt = new int[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            arrInt[i] = Arrays.stream(arr[i]).mapToInt(Integer::intValue).toArray();
        }
        return arrInt;
    }
}



