
import commandLine.ParseCml;
public class Main {
    public static void main(String[] args)  {
        ParseCml parseCml = new ParseCml(args);
        parseCml.parseCommandLine(args);
    }
}

