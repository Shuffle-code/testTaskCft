package commandLine;
import handlerFile.HandlerIntFile;
import handlerFile.HandlerStrFile;
import io.Write;
import mergeSort.MargeSortString;
import mergeSort.MergeSortInt;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

public class ParseCml {
    public ParseCml(String[] args) {
    }
    final Path pathInt = Path.of("C:\\Users\\79130\\IdeaProjects\\testTaskCft\\storage\\int");
    final Path pathStr = Path.of("C:\\Users\\79130\\IdeaProjects\\testTaskCft\\storage\\string");
    final String outFileName = "out.txt";
    final Write write = new Write();
    final MergeSortInt mergeSortInt = new MergeSortInt();
    final MargeSortString margeSortString = new MargeSortString();
    final HandlerIntFile handlerIntFile = new HandlerIntFile(pathInt);
    final HandlerStrFile handlerStrFile = new HandlerStrFile(pathStr);
    public void parseCommandLine(String[] args) {
        if (args.length < 3) {
            System.out.println("ERROR: INVALID NUMBER OF ARGUMENTS.");
        } else if (!(args[0].equals("-d") ||
                args[0].equals("-a") || args[0].equals("-i") ||
                args[0].equals("-s") || args[1].equals("-d") ||
                args[1].equals("-a") || args[1].equals("-i") ||
                args[1].equals("-s"))) {
            System.out.println("!Command " + Arrays.toString(args) + " is unknown");
        }
        if (args[0].equals("-i") || (args[0].equals("-a") && args[1].equals("-i"))){
            try {
                write.writeExample(mergeSortInt.mergeArrays((
                                (handlerIntFile.createIntArray(handlerFile(args, pathInt))))
                        ), String.valueOf(pathInt.resolve(outFileName)), pathInt);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if ((args[0].equals("-d") && args[1].equals("-i"))){
            try {
                write.writeExampleRevers(
                        mergeSortInt.mergeArrays((
                                (handlerIntFile.createIntArray(handlerFile(args, pathInt))))),
                        String.valueOf(pathInt.resolve(outFileName)), pathInt);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else if (args[0].equals("-s") || (args[0].equals("-a") && args[1].equals("-s"))){
           write.writeFileTxt(String.valueOf(pathStr.resolve(outFileName)),
                   margeSortString.mergeArrays(( handlerStrFile.createStrArray(handlerFile(args, pathStr)))));
        }else if ((args[0].equals("-d") && args[1].equals("-s"))){
            write.writeFileTxtRevers(String.valueOf(pathStr.resolve(outFileName)),
                    margeSortString.mergeArrays(( handlerStrFile.createStrArray(handlerFile(args, pathStr)))));
        }
    }

    public ArrayList<String> handlerFile(String[] args, Path path) {
        ArrayList<String> stringArrayList = new ArrayList<>();
        for (int i = 2; i < args.length; i++) {
            if (!args[i].equals("out.txt")){
                File file = new File(String.valueOf(path.resolve(args[i])));
                if(file.exists()){
                    stringArrayList.add(args[i]);
                } else System.out.printf("Файла - %s, не  существует!", args[i]);
            }
        }
        return stringArrayList;
    }
}
