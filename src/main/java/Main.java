import commandLine.ParseCml;
import io.Write;
import mergeSort.MargeSortString;
import mergeSort.MergeSortInt;
import io.Read;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        final Path pathInt = Path.of("C:\\Users\\79130\\IdeaProjects\\testTaskCft\\storage\\int");
        final Path pathStr = Path.of("C:\\Users\\79130\\IdeaProjects\\testTaskCft\\storage\\string");
        String outFileName = "out.txt";
        String storageInt = String.valueOf(Path.of("C:\\Users\\79130\\IdeaProjects\\testTaskCft\\storage\\int"));
        String storageString = String.valueOf(Path.of("C:\\Users\\79130\\IdeaProjects\\testTaskCft\\storage\\string\\out.txt"));
        MergeSortInt mergeSortInt = new MergeSortInt();
        MargeSortString  margeSortString = new MargeSortString();
        Read read = new Read();
        Write write = new Write();
        ParseCml parseCml = new ParseCml(args);
        int[][] ar = {{2, 6, 12, 34},
                {1, 9, 20, 10020, 8888888},
                {1, 9, 1000, 1234, 233333},
                {1, 8, 20, 76, 100, 122, 123, 124},
                {1, 8, 20, 76},
                {14, 94, 10040, 12234, 2333333},
                {23, 34, 90, 99}};

        try {
            read.readFileUsingScanner("C:\\Users\\79130\\IdeaProjects\\testTaskCft\\storage\\int\\in1.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        mergeSortInt.printArray(mergeSortInt.mergeNArrays(ar));
//        System.out.println(read.readFileUsingBufferedReader(String.valueOf(pathInt.resolve(fileName))));
//        System.out.println(read.readFileUsingBufferedReader("C:\\Users\\79130\\IdeaProjects\\testTaskCft\\storage\\int\\in1.txt"));


        try {
            write.writeExample(mergeSortInt.byString(mergeSortInt.mergeNArrays(ar)), outFileName);
            write.writeExampleNl(mergeSortInt.mergeNArrays(ar), "out1.txt");
            write.writeExampleNlRevers(mergeSortInt.mergeNArrays(ar), "out2.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


//        java -jar testTaskCft.jar search input.json

        String command = args[0];
        if (args.length < 3) {
            System.out.println("ERROR: INVALID NUMBER OF ARGUMENTS.");
        } else if (!(args[0].equals("-d") ||
                args[0].equals("-a") || args[0].equals("-i") ||
                args[0].equals("-s") || args[1].equals("-d") ||
                args[1].equals("-a") || args[1].equals("-i") ||
                args[1].equals("-s"))) {
            System.out.println("!Command " + command + " is unknown");
        }
        parseCml.doMDArrayDemo(parseCml.createIntArray(parseCml.getNameInFiles(args)));
        System.out.println(parseCml.getNameInFiles(args));

        System.out.println("Это сорт инт из файла: " + mergeSortInt.mergeNArrays(parseCml.doDArrayIntFromInteger(parseCml.createIntArray(parseCml.getNameInFiles(args)))));

//        System.out.println(mergeSortInt.byString(mergeSortInt.mergeNArrays(ar)));
//        System.out.println(parseCml.convertArrayStrToInteger(read.readFileUsingBufferedReader(String.valueOf(pathInt.resolve(fileName)))));
//        write.writeFileTxt(storageString, mergeSortInt.byString(mergeSortInt.mergeNArrays(ar)));
//        write.writeFileTxtNl(storageString, mergeSortInt.mergeNArrays(ar));
//        if (args[0].equals("-a") || args[0].equals("-i")){
//            write.writeExampleNl(args[2], args[1]);
//        } else if (args[0].equals("stat")){
//            System.out.println("This is type: " + args[0]);
//            System.out.println("This is string inJSON: " + jsonParser.getInJson(args[1]));
//            handlingJson.createJsonForStatRequest(args[1], args[2]);
//            System.out.println("This is string outJSON: " + jsonParser.getOutJson(args[2]));
//        }else System.out.println("Command " + command + " is unknown");


        String[][] arrInt = {{"2", "6", "12", "34"},
                {"1", "9", "20", "10020", "8888888"},
                {"1", "9", "1000", "1234", "233333"},
                {"1", "8", "20", "76", "100", "122", "123", "124"},
                {"1", "8", "20", "76"},
                {"14", "94", "10040", "12234", "2333333"}};


        String[][] arStr = {{"2", "6", "12", "34"},
                {"1", "9", "20", "10020", "8888888"},
                {"1", "9", "1000", "1234", "233333"},
                {"1", "8", "20", "76", "100", "122", "123", "124"},
                {"1", "8", "20", "76"},
                {"14", "94", "10040", "12234", "2333333"},
                {"apple", "oranges", "bananas", "Strawberry", "Blueberry"},
                {"23", "34", "90", "99"}};


        String[][] arSt = {{"2", "gh", "12", "34"},
                {"blueberry", "strawberry", "apple", "bananas", "oranges"},
                {"1", "ghghg", "20", "10020", "8888888"},
                {"1", "9", "gh", "1234", "233333"}};

        ArrayList<String> stringArrayList = margeSortString.mergeNArrays(arrInt);

        for (String st : stringArrayList) {
            System.out.println(st);
        }

        write.writeFileTxt(storageString, stringArrayList);

    }
//        Process child = Runtime.getRuntime().exec(command);
}
