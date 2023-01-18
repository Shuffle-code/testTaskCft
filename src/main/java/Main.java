
import commandLine.ParseCml;
public class Main {
    public static void main(String[] args)  {
        ParseCml parseCml = new ParseCml(args);
        parseCml.parseCommandLine(args);
    }
}

// java -jar testTaskCft.jar -a -s out.txt in1.txt in2.txt in3.txt

