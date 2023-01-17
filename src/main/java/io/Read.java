package io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Read {

    final Path pathInt = Path.of("C:\\Users\\79130\\IdeaProjects\\testTaskCft\\storage\\int");

    public void readUsingFileReader(String fileName) {
        File file = new File(fileName);
        FileReader fr = null;
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedReader br = new BufferedReader(fr);
        String line;
        System.out.println(
                "Reading text file using FileReader");
        while (true) {
            try {
                if (!((line = br.readLine()) != null)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            // process the line
            System.out.println(line);
        }
        try {
            br.close();
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    // Method 2
    // To read the file using Buffered Reader
    public ArrayList<String> readFileUsingBufferedReader(String fileName)  {
        File file = new File(String.valueOf(pathInt.resolve(fileName)));
        FileReader fr = null;
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        // read file line by line
        BufferedReader br = new BufferedReader(fr);
        String line;
        ArrayList<String> arrayList = new ArrayList<>();
        while (true) {
            try {
                if (!((line = br.readLine()) != null)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            // process the line
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

    // Method 3
    // To read the file using Scanner
    public void readFileUsingScanner(String fileName)
            throws IOException
    {
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);
        System.out.println("Read text file using Scanner");
        // read line by line
        while (scanner.hasNextLine()) {
            // process each line
            String line = scanner.nextLine();
            System.out.println(line);
        }
        scanner.close();
    }

    // Чтение файла целиком
    // To read the file using class
    public void readFileUsingClass(String fileName)
            throws IOException
    {
        Path path = Paths.get(fileName);
        // read file to byte array
        byte[] bytes = Files.readAllBytes(path);
        System.out.println(
                "Read text file using Files class");
        // read file to String list
        @SuppressWarnings("unused")
        List<String> allLines = Files.readAllLines(
                path, StandardCharsets.UTF_8);
        System.out.println(new String(bytes));
    }

    public void readWithFileReader(){
        String text = "";
        // Declaring a variable to lookup for
        // number of lines in afile
        int lineNumber;

        // Try block to check for exceptions
        try {

            // Creating a FileReader object so as to
            // get the directory of file to be read
            FileReader readfile = new FileReader(
                    "C:\\Users\\79130\\IdeaProjects\\array\\src\\storage\\in2.txt");

            // Creating a BufferReader class object to
            // read file as passed above
            BufferedReader readbuffer
                    = new BufferedReader(readfile);

            // Buffer reader declaration

            // Conditionality for specific line/s

            // Loop for the traversing line by line
            // into the text file
            for (lineNumber = 1; lineNumber < 10;
                 lineNumber++) {
                // If specific line/s is found
                if (lineNumber == 7) {
                    // Store the content of this specific
                    // line
                    text = readbuffer.readLine();
                }

                else {
                    // Just keep on reading
                    readbuffer.readLine();
                }
            }
        }

        // Catching IOException exception
        catch (IOException e) {

            // Print the line number where exception occurred
            e.printStackTrace();
        }

        // Print the specific line from the file read
        System.out.println(" The specific Line is: "
                + text);
    }

    // max эффективность, но блокирующая

    public int getMaxLineLengthBuffered(File file) {
        try (
                var fr = new FileReader(file);
                var br = new BufferedReader(fr)
        ) {
            var line = br.readLine();
            var maxLineLength = 0;

            while (line != null) {
                if (maxLineLength < line.length()) {
                    maxLineLength = line.length();
                }
                line = br.readLine();
            }
            return maxLineLength;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Чтение файла через стрим

    public int getMaxLineLengthStream(File file) {
        try (var lines = Files.lines(Paths.get(file.toURI()), StandardCharsets.UTF_8)) {
            return lines.mapToInt(String::length)
                    .max()
                    .orElse(0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
