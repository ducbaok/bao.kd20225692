package hust.soict.dsai.garbage;

import java.io.IOException;

import java.nio.file.*;
public class GarbageCreator {
    public static void main(String[] args) {
        String filename = "test.exe";
        
        /*System.out.println("Current working directory: " + System.getProperty("user.dir"));

        if (Files.exists(Paths.get(filename))) {
            System.out.println("File exists!");
        } else {
            System.out.println("File not found!");
        }*/

        long startTime, endTime;

        try {
            byte[] inputBytes = Files.readAllBytes(Paths.get(filename));

            // Measure time for inefficient string concatenation
            startTime = System.currentTimeMillis();
            String outputString = "";
            for (byte b : inputBytes) {
                outputString += (char) b;
            }
            endTime = System.currentTimeMillis();
            System.out.println("Time with + operator: " + (endTime - startTime) + " ms");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
