package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) {
        String filename = "test.exe";
        long startTime, endTime;

        try {
            byte[] inputBytes = Files.readAllBytes(Paths.get(filename));

            // Measure time with StringBuilder
            startTime = System.currentTimeMillis();
            StringBuilder outputStringBuilder = new StringBuilder();
            for (byte b : inputBytes) {
                outputStringBuilder.append((char) b);
            }
            endTime = System.currentTimeMillis();
            System.out.println("Time with StringBuilder: " + (endTime - startTime) + " ms");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}