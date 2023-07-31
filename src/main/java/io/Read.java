package io;
import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;

public class Read{
    public ArrayList<String> readFileUsingBufferedReader(String fileName, Path path)  {
        File file = new File(String.valueOf(path.resolve(fileName)));
        FileReader fr;
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
                if ((line = br.readLine()) == null) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (line.isEmpty()) System.out.println("Ошибка: пустая строка в файле: " + fileName );
            else if (checkWhite(line)) System.out.println("Ошибка: содержит пробельные символы в файле: " + fileName);
            else arrayList.add(line);
        }
        try {
            br.close();
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }

    public boolean checkWhite(String line) {
        for (char c : line.toCharArray()) {
            if (Character.isWhitespace(c)) {
                return true;
            }
        }return false;
    }

}
