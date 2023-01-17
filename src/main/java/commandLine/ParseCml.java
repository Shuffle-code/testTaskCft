package commandLine;
import io.Read;
import parseInFile.ParseIntFile;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

public class ParseCml {
    private String[] args;
    public ParseCml(String[] args) {
        this.args = args;
    }
    private final Path pathInt = Path.of("C:\\Users\\79130\\IdeaProjects\\testTaskCft\\storage\\int");
    private final Path pathStr = Path.of("C:\\Users\\79130\\IdeaProjects\\testTaskCft\\storage\\string");
    private final Read read = new Read();
    private final ParseIntFile parseIntFile = new ParseIntFile();
    public ArrayList<String> getNameInFiles(String[] args){
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
    public Integer[][] createIntArray(ArrayList<String> listNameFile){
//        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        int size = listNameFile.size();
        Integer[][] arrayForSort = new Integer[size][];
        for (int i = 0; i < size; i++) {
//            System.out.println("Должно быть назввние файла из cml: " + listNameFile.get(i) + ", Это длина элементов в этом файде: " );
            ArrayList<Integer> arrayList = parseIntFile.convertArrayStrToInteger(read.readFileUsingBufferedReader(listNameFile.get(i)));
            arrayForSort[i] = arrayList.toArray(new Integer[arrayList.size()]);

        }
        return arrayForSort;
    }
    public void doMDArrayDemo(Integer[][] arr) {
        Integer[][] matrix = arr;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                System.out.println("[" + i + "][" + j + "] =>" + matrix[i][j]);
            }
            System.out.println(" ");
        }
    }
    public int[][] doDArrayIntFromInteger(Integer[][] arr) {
        Integer[][] matrix = arr;
        int[][] arrInt = new int[arr.length][];
        for(int i = 0; i < arr.length; i++){
            arrInt[i] = Arrays.stream(arr[i]).mapToInt(Integer::intValue).toArray();
        }
        return arrInt;
    }




//    public void parseCommandLine(){
//        if (args.length < 3) {
//        System.out.println("ERROR: INVALID NUMBER OF ARGUMENTS.");
//    } else if (!(args[0].equals("-d") ||
//                args[0].equals("-a") || args[0].equals("-i") ||
//                args[0].equals("-s") || args[1].equals("-d") ||
//                args[1].equals("-a") || args[1].equals("-i") ||
//                args[1].equals("-s"))) {
//        System.out.println("!Command " + args + " is unknown");
//    }
//        if (args[0].equals("-a") || args[0].equals("-i")){
//        buyerService.createResponseSearch(args[1], args[2]);
//    } else if (args[0].equals("stat")){
//        System.out.println("This is type: " + args[0]);
//        System.out.println("This is string inJSON: " + jsonParser.getInJson(args[1]));
//        handlingJson.createJsonForStatRequest(args[1], args[2]);
//        System.out.println("This is string outJSON: " + jsonParser.getOutJson(args[2]));
//    }else System.out.println("Command " + args + " is unknown");
//    }
}
