import javax.swing.JOptionPane;

public class EquationSolver {

    public static void main(String[] args) {
        String option;
        String strNotification = "Choose an option:\n"
                + "1. The first-degree equation (linear equation) with one variable\n"
                + "2. The first-degree equation (linear equation) with two variables\n"
                + "3. The second-degree equation with one variable";
        
        // Ask for user option
        option = JOptionPane.showInputDialog(null, strNotification, "Equation Solver", JOptionPane.INFORMATION_MESSAGE);

        // Handle user input and call the appropriate method
        if (option != null && option.equals("1")) {
            solveLinearEquation();
        } else if (option != null && option.equals("2")) {
            solveTwoVariableLinearEquation();
        } else if (option != null && option.equals("3")) {
            solveQuadraticEquation();
        } else {
            JOptionPane.showMessageDialog(null, "Invalid option, exiting.");
        }

        System.exit(0);  // Close the program
    }

    // Solves ax + b = 0 (first-degree equation)
    public static void solveLinearEquation() {
        String inputFormat = "Enter the coefficients for the following equations:\n\n"
                + "Equation: a * x + b = 0";
        JOptionPane.showMessageDialog(null, inputFormat, "Input Format", JOptionPane.INFORMATION_MESSAGE);
        String aStr = JOptionPane.showInputDialog(null, "Enter coefficient a (non-zero):", "Linear Equation", JOptionPane.INFORMATION_MESSAGE);
        String bStr = JOptionPane.showInputDialog(null, "Enter constant b:", "Linear Equation", JOptionPane.INFORMATION_MESSAGE);
        
        try {
            double a = Double.parseDouble(aStr);
            double b = Double.parseDouble(bStr);
            
            if (a != 0) {
                double solution = - b / a;
                JOptionPane.showMessageDialog(null, "The solution is x = " + solution);
            } else {
                JOptionPane.showMessageDialog(null, "Coefficient 'a' cannot be zero.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter numerical values.");
        }
    }

    // Solves a system of two linear equations with two variables
    public static void solveTwoVariableLinearEquation() {
        // Provide instructions for the input format
        String inputFormat = "Enter the coefficients for the following equation:\n\n"
                + "Equation 1: a\u2081*x + b\u2081*y = c\u2081\n"
                + "Equation 2: a\u2082*x + b\u2082*y = c\u2082\n";
        
        JOptionPane.showMessageDialog(null, inputFormat, "Input Format", JOptionPane.INFORMATION_MESSAGE);

        // Equation 1: a1*x + b1*y = c1
        String a1Str = JOptionPane.showInputDialog(null, "Enter coefficient a1:", "Two-Variable Linear Equation", JOptionPane.INFORMATION_MESSAGE);
        String b1Str = JOptionPane.showInputDialog(null, "Enter coefficient b1:", "Two-Variable Linear Equation", JOptionPane.INFORMATION_MESSAGE);
        String c1Str = JOptionPane.showInputDialog(null, "Enter constant c1:", "Two-Variable Linear Equation", JOptionPane.INFORMATION_MESSAGE);

        // Equation 2: a2*x + b2*y = c2
        String a2Str = JOptionPane.showInputDialog(null, "Enter coefficient a2:", "Two-Variable Linear Equation", JOptionPane.INFORMATION_MESSAGE);
        String b2Str = JOptionPane.showInputDialog(null, "Enter coefficient b2:", "Two-Variable Linear Equation", JOptionPane.INFORMATION_MESSAGE);
        String c2Str = JOptionPane.showInputDialog(null, "Enter constant c2:", "Two-Variable Linear Equation", JOptionPane.INFORMATION_MESSAGE);

        try {
            double a1 = Double.parseDouble(a1Str);
            double b1 = Double.parseDouble(b1Str);
            double c1 = Double.parseDouble(c1Str);
            double a2 = Double.parseDouble(a2Str);
            double b2 = Double.parseDouble(b2Str);
            double c2 = Double.parseDouble(c2Str);

            double determinant = a1 * b2 - a2 * b1;

            if (determinant == 0) {
                // Check for consistency
                if (a1 * c2 == a2 * c1 && b1 * c2 == b2 * c1) {
                    JOptionPane.showMessageDialog(null, "The system has infinitely many solutions (the equations are identical).");
                } else {

                    JOptionPane.showMessageDialog(null, "The system has no solution (the equations are parallel).");
                }
            } else {
                // Calculate x and y
                double x = (c1 * b2 - c2 * b1) / determinant;
                double y = (a1 * c2 - a2 * c1) / determinant;

                JOptionPane.showMessageDialog(null, "The solution is x = " + x + " and y = " + y);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter numerical values.");
        }
    }

    // Solves ax^2 + bx + c = 0 (second-degree equation)
    public static void solveQuadraticEquation() {
        String inputFormat = "Enter the coefficients for the following equation:\n\n"
                + "Equation: a * x^2 + b * x = c\n";
        JOptionPane.showMessageDialog(null, inputFormat, "Input Format", JOptionPane.INFORMATION_MESSAGE);
        String aStr = JOptionPane.showInputDialog(null, "Enter coefficient a (non-zero):", "Quadratic Equation", JOptionPane.INFORMATION_MESSAGE);
        String bStr = JOptionPane.showInputDialog(null, "Enter coefficient b:", "Quadratic Equation", JOptionPane.INFORMATION_MESSAGE);
        String cStr = JOptionPane.showInputDialog(null, "Enter constant c:", "Quadratic Equation", JOptionPane.INFORMATION_MESSAGE);
        
        try {
            double a = Double.parseDouble(aStr);
            double b = Double.parseDouble(bStr);
            double c = Double.parseDouble(cStr);
            
            if (a != 0) {
                // Calculate discriminant (b^2 - 4ac)
                double discriminant = b * b - 4 * a * c;
                
                if (discriminant > 0) {
                    double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                    double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                    JOptionPane.showMessageDialog(null, "Two solutions: x1 = " + root1 + ", x2 = " + root2);
                } else if (discriminant == 0) {
                    double root = -b / (2 * a);
                    JOptionPane.showMessageDialog(null, "One solution: x = " + root);
                } else {
                    JOptionPane.showMessageDialog(null, "No real solutions.");
                }
            } else {
                int ContinueOpt;
                ContinueOpt = JOptionPane.showConfirmDialog(null, "Coefficient 'a' cannot be zero.\n" 
                    + "If you wish to proceed, this program would solve the following equation\n\n" 
                    + b + " * x + " + c + " = 0", "Confirm Action", JOptionPane.YES_NO_OPTION);
                if(ContinueOpt == JOptionPane.YES_OPTION)
                {
                    if(b == 0)
                    {
                        JOptionPane.showMessageDialog(null, "No solution.");
                    }
                    else
                    {
                        double solution = - c / b;
                        JOptionPane.showMessageDialog(null, "One solution: x = " + solution);
                    }
                    
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter numerical values.");
        }
    }
}
