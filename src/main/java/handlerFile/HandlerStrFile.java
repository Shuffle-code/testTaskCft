package handlerFile;

import io.Read;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;

public class HandlerStrFile {
    final Path pathStr;
    private final Read read = new Read();
    public HandlerStrFile(Path pathStr) {
        this.pathStr = pathStr;
    }
    public String[][] createStrArray(ArrayList<String> listNameFile){
        int size = listNameFile.size();
        String[][] arrayForSort = new String[size][];
        for (int i = 0; i < size; i++) {
            ArrayList<String> arrayList = read.readFileUsingBufferedReader(listNameFile.get(i), pathStr);
            arrayList.sort(Comparator.naturalOrder());
            arrayForSort[i] = arrayList.toArray(new String[arrayList.size()]);
        }
        return arrayForSort;
    }
}
