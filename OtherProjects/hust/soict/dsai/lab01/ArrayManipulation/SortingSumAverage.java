package hust.soict.dsai.lab01.ArrayManipulation;
import java.util.Arrays;
import java.util.Scanner;

public class SortingSumAverage{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] numbers = new int[size];
        int sum = 0;

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
            sum += numbers[i];
        }
        Arrays.sort(numbers);
        System.out.println("Sorted array: " + Arrays.toString(numbers));


        System.out.println("Sum of array elements: " + sum);

        double average = (double) sum / size;
        System.out.println("Average value of array elements: " + average);

        scanner.close();
    }
}
