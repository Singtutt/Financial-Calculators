package com.pluralsight;

import java.util.Scanner;

public class FinancialCalculators {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
//  Merging Stage
        while (true) {
            System.out.println("Financial Calculator Menu:");
            System.out.println("1. Mortgage Calculator");
            System.out.println("2. Future Value Calculator");
            System.out.println("3. Present Value of Annuity Calculator");
            System.out.println("0. Exit Menu");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    calculateMortgage(input);
                    break;
                case 2:
                    calculateFutureValue(input);
                    break;
                case 3:
                    calculatePresentValue(input);
                    break;
                case 0:
                    System.out.println("Exiting the program. Goodbye!");
                    input.close(); // Close the Scanner before exiting
                    return; // Exit the program
                default:
                    System.out.println("Invalid Choice. Please select a valid option (0 Exit, 1 Mortgage, 2 Future Value, 3 Present Value): ");
                    break;
            }

            // After performing a calculation, ask the user if they want to go back to the menu (Calculator-Menu Loop)
            System.out.print("Would you like to go back to the main menu? (yes/no): ");
            String goBack = input.next().toLowerCase();

            if (!goBack.equals("yes")) {
                System.out.println("Exiting the program. Goodbye!");
                input.close(); // Close the Scanner before exiting
                return; // Exit the program
            }
        }
    }
//  1. Mortgage Calculator Block (Calculator 1)
    private static void calculateMortgage(Scanner input) {
        System.out.println("Welcome to the Mortgage Calculator");
//  a.
        System.out.print("Enter principal amount: ");
        double principal = input.nextDouble();

        System.out.print("Enter annual interest rate (in decimal form): ");
        double annualInterestRate = input.nextDouble();

        System.out.print("Enter loan length (in years): ");
        int loanLengthYears = input.nextInt();

        double monthlyInterestRate = annualInterestRate / 12;
        int numberOfPayments = loanLengthYears * 12;

        double monthlyPayment = principal * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments)) / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);
        double totalInterestPaid = (monthlyPayment * numberOfPayments) - principal;
//  b.
        System.out.println("Expected Monthly Payment: $" + monthlyPayment);
        System.out.println("Total Interest Paid: $" + totalInterestPaid);
    }
//  2. Future Value Calculator Block (Calculator 2)
    private static void calculateFutureValue(Scanner input) {
        System.out.println("Welcome to the Future Value Calculator");
//  a.
        System.out.print("Enter initial deposit: ");
        double deposit = input.nextDouble();

        System.out.print("Enter annual interest rate (in decimal form): ");
        double annualInterestRate = input.nextDouble();

        System.out.print("Enter number of years: ");
        int numberOfYears = input.nextInt();

        double dailyInterestRate = annualInterestRate / 365;
        int numberOfDays = numberOfYears * 365;

        double futureValue = deposit * Math.pow(1 + dailyInterestRate, numberOfDays);
        double totalInterestEarned = futureValue - deposit;
//  b.
        System.out.println("Future Value: $" + futureValue);
        System.out.println("Total Interest Earned: $" + totalInterestEarned);
    }
//  3. Present Value Calculator Block (Calculator 3)
    private static void calculatePresentValue(Scanner input) {
        System.out.println("Welcome to the Present Value Calculator");
//  a.
        System.out.print("Enter monthly payout: ");
        double monthlyPayout = input.nextDouble();

        System.out.print("Enter annual interest rate (in decimal form): ");
        double annualInterestRate = input.nextDouble();

        System.out.print("Enter number of years to payout: ");
        int numberOfYears = input.nextInt();

        double monthlyInterestRate = annualInterestRate / 12;
        int numberOfMonths = numberOfYears * 12;

        double presentValue = monthlyPayout * (1 - Math.pow(1 + monthlyInterestRate, -numberOfMonths)) / monthlyInterestRate;
//  b.
        System.out.println("Present Value: $" + presentValue);
    }
}