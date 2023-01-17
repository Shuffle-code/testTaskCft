package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;

public class Write {
    private static Path storageString = Path.of("C:\\Users\\79130\\IdeaProjects\\testTaskCft\\storage\\int");
    public void writeExample(String str, String outputFileName) throws IOException {
        FileWriter file = new FileWriter(String.valueOf(storageString.resolve(outputFileName)));
        file.write(String.valueOf(str));
        file.close();
    }

    public void writeExampleNl(ArrayList<Integer> integerArrayList, String outputFileName) throws IOException {
        FileWriter file = new FileWriter(String.valueOf(storageString.resolve(outputFileName)));
        Collections.reverse(integerArrayList);
        for (int s : integerArrayList) {
            file.write(s + System.getProperty("line.separator"));
        }
        file.close();
    }

    public ArrayList<Integer> reverse(ArrayList<Integer> list) {
        if(list.size() > 1) {
            Integer value = list.remove(0);
            reverse(list);
            list.add(value);
        }
        return list;
    }

    public void writeExampleNlRevers(ArrayList<Integer> integerArrayList, String outputFileName) throws IOException {
        FileWriter file = new FileWriter(String.valueOf(storageString.resolve(outputFileName)));
        reverse(integerArrayList);
        for (int s : integerArrayList) {
            file.write(s + System.getProperty("line.separator"));
        }
//        file.write(String.valueOf(str));
        file.close();
    }


    public void writeFileTxtNl(String filePath, ArrayList<Integer> integerArrayList) {
        File file = new File(String.valueOf(filePath));
        // if file doesnt exists, then create it
        FileWriter fw = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            for (int s : integerArrayList) {
                bw.write(s + System.getProperty("line.separator"));
            }
            try {
                bw.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void writeFileTxt(String filePath, ArrayList<String> fileArrContent) {
        File file = new File(String.valueOf(filePath));
        // if file doesnt exists, then create it
        FileWriter fw = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            for (String s : fileArrContent) {
                bw.write(s + System.getProperty("line.separator"));
            }

            try {
                bw.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
