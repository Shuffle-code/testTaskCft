package io;
import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;

public class Read {
    final Path pathInt = Path.of("C:\\Users\\79130\\IdeaProjects\\testTaskCft\\storage\\int");
    public ArrayList<String> readFileUsingBufferedReader(String fileName)  {
        File file = new File(String.valueOf(pathInt.resolve(fileName)));
        FileReader fr = null;
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedReader br = new BufferedReader(fr);
        String line;
        ArrayList<String> arrayList = new ArrayList<>();
        while (true) {
            try {
                if (!((line = br.readLine()) != null)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            arrayList.add(line);
        }
        try {
            br.close();
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }

}
