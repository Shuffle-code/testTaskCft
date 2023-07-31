package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;

public class Write {
    public void writeExample(ArrayList<Integer> integerArrayList, String outputFileName, Path path) throws IOException {
        File file = new File(outputFileName);
        if (!file.exists()) file.createNewFile();
        FileWriter fileWriter = new FileWriter(String.valueOf(path.resolve(outputFileName)));
        for (int s : integerArrayList) {
            fileWriter.write(s + System.getProperty("line.separator"));
        }
        fileWriter.close();
    }
    public ArrayList<Integer> reverse(ArrayList<Integer> list) {
        if(list.size() > 1) {
            Integer value = list.remove(0);
            reverse(list);
            list.add(value);
        }
        return list;
    }
    public void writeExampleRevers(ArrayList<Integer> integerArrayList, String outputFileName, Path path) throws IOException {
        File file = new File(outputFileName);
        reverse(integerArrayList);
        if (!file.exists()) file.createNewFile();
        FileWriter fileWrite = new FileWriter(String.valueOf(path.resolve(outputFileName)));
        for (int s : integerArrayList) {
            fileWrite.write(s + System.getProperty("line.separator"));
        }
        fileWrite.close();
    }

    public void writeFileTxt(String filePath, ArrayList<String> fileArrContent) {
        File file = new File(String.valueOf(filePath));
        FileWriter fileWriter = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fileWriter = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fileWriter);
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
                assert fileWriter != null;
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void writeFileTxtRevers(String filePath, ArrayList<String> fileArrContent) {
        File file = new File(String.valueOf(filePath));
        FileWriter fileWriter = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fileWriter = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fileWriter);
            Collections.reverse(fileArrContent);
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
                assert fileWriter != null;
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
