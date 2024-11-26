package hust.soict.dsai.lab01.JavaBasics;
import java.util.Scanner;
public class InputFromKeyboard {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);

        System.out.println("What is your name? ");
        String name = keyboard.nextLine();
        System.out.println("How old are you? ");
        int iage = keyboard.nextInt();
        keyboard.nextLine(); 
        System.out.println("How tall are you(m)? ");
        double dheight = keyboard.nextDouble();

        System.out.println("Mr/Mrs " + name + iage + " years old. Your height is: " + dheight + " m");
        keyboard.close();
    }
}
