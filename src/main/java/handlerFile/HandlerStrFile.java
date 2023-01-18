package handlerFile;
import io.Read;
import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
public class HandlerStrFile {
    final Path pathStr;
    private final Read read = new Read();
    public HandlerStrFile(Path pathStr) {
        this.pathStr = pathStr;
    }

    public ArrayList<String> getNameFiles(String[] args) {
        ArrayList<String> stringArrayList = new ArrayList<>();
        for (int i = 2; i < args.length; i++) {
            if (!args[i].equals("out.txt")) {
                File file = new File(String.valueOf(pathStr.resolve(args[i])));
                if (file.exists()) {
                    stringArrayList.add(args[i]);
                } else System.out.printf("Файла - %s, не  существует!", args[i]);
            }
        }
        return stringArrayList;
    }

    public ArrayList<String> handlerFile(String[] args) {
        ArrayList<String> stringArrayList = new ArrayList<>();
        for (int i = 2; i < args.length; i++) {
            if (!args[i].equals("out.txt")) {
                File file = new File(String.valueOf(pathStr.resolve(args[i])));
                if (file.exists()) {
                    stringArrayList.add(args[i]);
                } else System.out.printf("Файла - %s, не  существует!", args[i]);
            }
        }
        System.out.println(stringArrayList);
        return stringArrayList;
    }

    public String[][] createStrArray(ArrayList<String> listNameFile){
        int size = listNameFile.size();
        String[][] arrayForSort = new String[size][];
        for (int i = 0; i < size; i++) {
            ArrayList<String> arrayList = read.readFileUsingBufferedReader(listNameFile.get(i));
            arrayForSort[i] = arrayList.toArray(new String[arrayList.size()]);
        }
        return arrayForSort;
    }
}
