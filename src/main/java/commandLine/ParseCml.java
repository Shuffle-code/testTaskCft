package commandLine;
import handlerFile.HandlerInFile;
import handlerFile.HandlerStrFile;
import io.Write;
import mergeSort.MargeSortString;
import mergeSort.MergeSortInt;
import java.io.IOException;
import java.nio.file.Path;

public class ParseCml {
    private String[] args;
    public ParseCml(String[] args) {
        this.args = args;
    }
    Path pathInt = Path.of("C:\\Users\\79130\\IdeaProjects\\testTaskCft\\storage\\int");;
    Path pathStr = Path.of("C:\\Users\\79130\\IdeaProjects\\testTaskCft\\storage\\string");
    String outFileName = "out.txt";
    Write write = new Write();
    MergeSortInt mergeSortInt = new MergeSortInt();
    MargeSortString margeSortString = new MargeSortString();
    HandlerInFile handlerInFile = new HandlerInFile(pathInt);
    HandlerStrFile handlerStrFile = new HandlerStrFile(pathStr);
    public void parseCommandLine(String[] args) {
        if (args.length < 3) {
            System.out.println("ERROR: INVALID NUMBER OF ARGUMENTS.");
        } else if (!(args[0].equals("-d") ||
                args[0].equals("-a") || args[0].equals("-i") ||
                args[0].equals("-s") || args[1].equals("-d") ||
                args[1].equals("-a") || args[1].equals("-i") ||
                args[1].equals("-s"))) {
            System.out.println("!Command " + args + " is unknown");
        }
        if (args[0].equals("-i") || (args[0].equals("-a") && args[1].equals("-i"))){
            try {
                write.writeExampleNl(mergeSortInt.mergeNArrays((
                                (handlerInFile.createIntArray(handlerInFile.handlerFile(args))))
                        ), String.valueOf(pathInt.resolve(outFileName)));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if ((args[0].equals("-d") && args[1].equals("-i"))){
            try {
                write.writeExampleNlRevers(
                        mergeSortInt.mergeNArrays((
                                (handlerInFile.createIntArray(handlerInFile.handlerFile(args))))),
                        String.valueOf(pathInt.resolve(outFileName)));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else if (args[0].equals("-s") || (args[0].equals("-a") && args[1].equals("-s"))){
           write.writeFileTxtNL(String.valueOf(pathStr.resolve(outFileName)),
                   margeSortString.mergeNArrays(( handlerStrFile.createStrArray(handlerStrFile.handlerFile(args)))));
        }else if ((args[0].equals("-d") && args[1].equals("-s"))){
            write.writeFileTxtNLRevers(String.valueOf(pathStr.resolve(outFileName)),
                    margeSortString.mergeNArrays(( handlerStrFile.createStrArray(handlerStrFile.handlerFile(args)))));
        }
    }
}
