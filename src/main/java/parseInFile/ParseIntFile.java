package parseInFile;

import java.util.ArrayList;

public class ParseIntFile {
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
}
