import java.util.*;

class Calculator {

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }
}

public class BasicCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator();

        while (true) {

            System.out.println("\n===== BASIC CALCULATOR =====");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            if (choice == 5) {
                System.out.println("Thank you for using the calculator.");
                break;
            }

            if (choice < 1 || choice > 5) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            System.out.print("Enter first number: ");
            double num1 = sc.nextDouble();

            System.out.print("Enter second number: ");
            double num2 = sc.nextDouble();

            try {
                switch (choice) {

                    case 1:
                        System.out.println("Addition of " + num1 + " and " + num2 + " = " + calc.add(num1, num2));
                        break;

                    case 2:
                        System.out.println("Subtraction of " + num1 + " and " + num2 + " = " + calc.subtract(num1, num2));
                        break;

                    case 3:
                        System.out.println("Multiplication of " + num1 + " and " + num2 + " = " + calc.multiply(num1, num2));
                        break;

                    case 4:
                        System.out.println("Division of " + num1 + " and " + num2 + " = " + calc.divide(num1, num2));
                        break;
                }

            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}