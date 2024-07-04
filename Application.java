package com.shahed.calculator;

import java.util.Scanner;

public class Application {
    
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEnter operation (add, subtract, multiply, divide, pow, sqrt, log, log10, sin, cos, tan, factorial, permutation) or 'exit' to quit:");
            String operation = scanner.next();

            if (operation.equalsIgnoreCase("exit")) {
                System.out.println("Exiting calculator...");
                break;
            }

            if (!operation.equalsIgnoreCase("sqrt") && !operation.equalsIgnoreCase("log") && 
                !operation.equalsIgnoreCase("log10") && !operation.equalsIgnoreCase("sin") && 
                !operation.equalsIgnoreCase("cos") && !operation.equalsIgnoreCase("tan") && 
                !operation.equalsIgnoreCase("factorial") && !operation.equalsIgnoreCase("permutation")) {
                System.out.print("Enter first number: ");
                double num1 = scanner.nextDouble();
                System.out.print("Enter second number: ");
                double num2 = scanner.nextDouble();

                switch (operation.toLowerCase()) {
                    case "add":
                        System.out.println("Result: " + add(num1, num2));
                        break;
                    case "subtract":
                        System.out.println("Result: " + subtract(num1, num2));
                        break;
                    case "multiply":
                        System.out.println("Result: " + multiply(num1, num2));
                        break;
                    case "divide":
                        System.out.println("Result: " + divide(num1, num2));
                        break;
                    case "pow":
                        System.out.println("Result: " + power(num1, num2));
                        break;
                    default:
                        System.out.println("Invalid operation.");
                        break;
                }
            } else if (operation.equalsIgnoreCase("permutation")) {
                System.out.print("Enter total number of elements: ");
                int totalElements = scanner.nextInt();
                System.out.print("Enter number of items to select: ");
                int selectedItems = scanner.nextInt();

                System.out.println("Recursive Permutations: " + recursivePerm(totalElements, selectedItems));
                System.out.println("Non-Recursive Permutations: " + nonRecursivePerm(totalElements, selectedItems));
            } else {
                System.out.print("Enter number: ");
                double num = scanner.nextDouble();

                switch (operation.toLowerCase()) {
                    case "sqrt":
                        System.out.println("Result: " + sqrt(num));
                        break;
                    case "log":
                        System.out.println("Result: " + log(num));
                        break;
                    case "log10":
                        System.out.println("Result: " + log10(num));
                        break;
                    case "sin":
                        System.out.println("Result: " + sin(Math.toRadians(num)));
                        break;
                    case "cos":
                        System.out.println("Result: " + cos(Math.toRadians(num)));
                        break;
                    case "tan":
                        System.out.println("Result: " + tan(Math.toRadians(num)));
                        break;
                    case "factorial":
                        System.out.println("Result: " + factorial((int) num));
                        break;
                    default:
                        System.out.println("Invalid operation.");
                        break;
                }
            }
            
            scanner.close();
        }
        }

    public static double add(double a, double b) {
        //accepts two doubles as parameters and returns the sum
        return a + b;
    }
    
    public static long factorial(int num) {
        if (num < 0) {
            System.out.println("Factorial of negative number is undefined.");
            return 0;
        }
        return factorialHelper(num, num);
    }

    private static long factorialHelper(int originalNum, int num) {
        if (num <= 1) {
            System.out.print("\rCalculating factorial: 100%");
            return 1;
        }
        // Calculate progress and update progress bar
        int progress = (int) (((originalNum - num + 1) / (double) originalNum) * 100);
        System.out.print("\rCalculating factorial: " + progress + "%");
        return num * factorialHelper(originalNum, num - 1);
    }
    
    
    public static double subtract(double a, double b) {
        //accepts two doubles as parameters and returns the difference 
        return a - b;
    }
    
    public static double multiply(double a, double b) {
        //accepts two doubles as parameters and returns the product
        return a * b;
    }
    
    public static double divide(double a, double b) {
        //accepts two doubles as parameters and returns the quotient
        if (b != 0) {
            return a / b;
        } else {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
    }

    // Exponentiation
    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    // Square root
    public static double sqrt(double number) {
        return Math.sqrt(number);
    }

    // Natural logarithm
    public static double log(double number) {
        return Math.log(number);
    }

    // Base-10 logarithm
    public static double log10(double number) {
        return Math.log10(number);
    }

    // Sine function
    public static double sin(double angleRadians) {
        return Math.sin(angleRadians);
    }

    // Cosine function
    public static double cos(double angleRadians) {
        return Math.cos(angleRadians);
    }

    // Tangent function
    public static double tan(double angleRadians) {
        return Math.tan(angleRadians);
    }

    //Recursive permitation method
     public static long recursivePerm(int totalElements, int selectedItems) {
        if (selectedItems > totalElements) {
            throw new IllegalArgumentException("Number of selected items must be less than or equal to total number of elements.");
        }
        if (totalElements < 0 || selectedItems < 0 || selectedItems > 100) {
            throw new IllegalArgumentException("Please ensure that the total number of elements and selected items are between 0 and 100.");
        }
        if (selectedItems == 0) {
            return 1;
        }
        return totalElements * recursivePerm(totalElements - 1, selectedItems - 1);
    }

    // Non-recursive method to calculate permutations
    public static long nonRecursivePerm(int totalElements, int selectedItems) {
        if (selectedItems > totalElements) {
            throw new IllegalArgumentException("Number of selected items must be less than or equal to total number of elements.");
        }
        if (totalElements < 0 || selectedItems < 0 || selectedItems > 100) {
            throw new IllegalArgumentException("Please ensure that the total number of elements and selected items are between 0 and 100.");
        }
        long result = 1;
        for (int i = 0; i < selectedItems; i++) {
            result *= (totalElements - i);
        }
        return result;
    }
}
