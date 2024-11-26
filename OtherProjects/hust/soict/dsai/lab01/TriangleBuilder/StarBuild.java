package hust.soict.dsai.lab01.TriangleBuilder;

import java.util.Scanner;
public class StarBuild {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input the height of the triangle (n): ");
        int height = scanner.nextInt();
        if(height < 0)
        {
            System.out.println("Invalid input. Height should bigger than 0\n");
        }
        else{
        for (int currentRow = 1; currentRow <= height; currentRow++) {
            for (int spaces = height - currentRow; spaces > 0; spaces--) {
                System.out.print(" ");
            }

            int starsCount = 2 * currentRow - 1;
            for (int stars = 1; stars <= starsCount; stars++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
    scanner.close();
    }
}