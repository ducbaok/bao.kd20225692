package hust.soict.dsai.lab01;
import javax.swing.JOptionPane;
public class NumberManipulation{
    public static void main(String[] args){
        String strNum1, strNum2;
        String strNotification = "You've just entered: ";
        String strSum;
        String strDiffernce;
        String strProduct;
        String strQuotient;

        strNum1 = JOptionPane.showInputDialog(null, "Please input the first number: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        strNotification += strNum1 + " and ";
        double Num1 = Double.parseDouble(strNum1);

        strNum2 = JOptionPane.showInputDialog(null, "Please input the second number: ", "Input the second number", JOptionPane.INFORMATION_MESSAGE);
        strNotification += strNum2;
        double Num2 = Double.parseDouble(strNum2);

        JOptionPane.showMessageDialog(null, strNotification, "Show two numbers", JOptionPane.INFORMATION_MESSAGE);
        //sum operation
        double Sum = Num1 + Num2; 
        strSum = Double.toString(Sum);
        JOptionPane.showMessageDialog(null, strSum, "Sum of two numbers", JOptionPane.INFORMATION_MESSAGE);
        
        //differ operation
        double Difference = Num1 - Num2;
        strDiffernce = Double.toString(Difference);
        JOptionPane.showMessageDialog(null, strDiffernce, "Difference of two numbers", JOptionPane.INFORMATION_MESSAGE);

        //product operation
        double Product = Num1 * Num2;
        strProduct = Double.toString(Product);
        JOptionPane.showMessageDialog(null, strProduct, "Product of two numbers", JOptionPane.INFORMATION_MESSAGE);

        //quotient operation
        if(Num2 != 0)
        {
            double Quotient = Num1 / Num2;
            strQuotient = Double.toString(Quotient);
        }
        else
        {
            strQuotient = "Operation can't be done due to input's invalid format or input";
        }
        JOptionPane.showMessageDialog(null, strQuotient, "Quotient of two numbers", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}