package com.shahed.calculator;

import java.util.Scanner;

public class Application {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create scanner instance
        
        if (args.length > 0) {
            // Process CLI arguments
        } else {
            // No CLI arguments, ask for user input
            System.out.println("Enter operation (e.g., add, factorial, subtract, multiply, divide):");
            String operation = scanner.next().toLowerCase(); // Read operation
            
            switch (operation) {
                case "add":
                	// if user enters add, take arguments and pass them into the add method
                    System.out.println("Enter the first operand:");
                    double num1Add = scanner.nextDouble();
                    System.out.println("Enter the second operand:");
                    double num2Add = scanner.nextDouble();
                    System.out.println("Result: " + add(num1Add, num2Add));
                    break;
                
                case "factorial":
                    // if user enters factorial, take argument and pass it into the factorial method
                    System.out.println("Enter a number:");
                    double number = scanner.nextDouble();
                    System.out.println("Result: " + factorial(number));
                    break;
                
                case "subtract":
                    // if user enters subtrct, take arguments and pass them into the subtract method
                    System.out.println("Enter the first operand:");
                    double num1Subtract = scanner.nextDouble();
                    System.out.println("Enter the second operand:");
                    double num2Subtract = scanner.nextDouble();
                    System.out.println("Result: " + subtract(num1Subtract, num2Subtract));
                    break;
                
                case "multiply":
                    // if user enters multiply, take arguments and pass them into the multiply method
                    System.out.println("Enter the first operand:");
                    double num1Multiply = scanner.nextDouble();
                    System.out.println("Enter the second operand:");
                    double num2Multiply = scanner.nextDouble();
                    System.out.println("Result: " + multiply(num1Multiply, num2Multiply));
                    break;
                
                case "divide":
                    // if user enters divide, take arguments and pass them into the divide method
                    System.out.println("Enter the first operand:");
                    double num1Divide = scanner.nextDouble();
                    System.out.println("Enter the second operand:");
                    double num2Divide = scanner.nextDouble();
                    System.out.println("Result: " + divide(num1Divide, num2Divide));
                    break;
                
                default:
                    System.out.println("Unsupported operation.");
                    break;
            }
        }
    }

    public static double add(double a, double b) {
        //accepts two doubles as parameters and returns the sum
        return a + b;
    }

    public static double factorial(double n) {
        //accepts a double as parameters and returns its factorial
        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
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
}
