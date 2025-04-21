package com.hexaware.ims1.main;

	import java.sql.*;
	import java.util.List;
	import java.util.Scanner;

import com.hexaware.ims1.dao.LoanRepository;
import com.hexaware.ims1.entity.Loan;

	public class LoanManagement{
	    private static final Scanner scanner = new Scanner(System.in);
	    private static final LoanRepository loanRepository = new LoanRepository();

	    public static void main(String[] args) {
	        while (true) {
	            displayMenu();
	            int choice = getUserChoice();
	            switch (choice) {
	                case 1:
	                    applyForLoan();
	                    break;
	                case 2:
	                    viewAllLoans();
	                    break;
	                case 3:
	                    viewLoanDetails();
	                    break;
	                case 4:
	                    makeRepayment();
	                    break;
	                case 5:
	                    System.out.println("Exiting the system.");
	                    return;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
	    }

	    private static void displayMenu() {
	        System.out.println("\n--- Loan Management System ---");
	        System.out.println("1. Apply for a Loan");
	        System.out.println("2. View All Loans");
	        System.out.println("3. View Loan Details");
	        System.out.println("4. Make a Repayment");
	        System.out.println("5. Exit");
	        System.out.print("Enter your choice: ");
	    }

	    private static int getUserChoice() {
	        while (!scanner.hasNextInt()) {
	            System.out.println("Invalid input. Please enter a number.");
	            scanner.next(); // Clear the invalid input
	        }
	        return scanner.nextInt();
	    }

	    private static void applyForLoan() {
	        System.out.print("Enter Customer ID: ");
	        int customerId = scanner.nextInt();
	        System.out.print("Enter Principal Amount: ");
	        double principalAmount = scanner.nextDouble();
	        System.out.print("Enter Interest Rate: ");
	        double interestRate = scanner.nextDouble();
	        System.out.print("Enter Loan Term (in months): ");
	        int loanTerm = scanner.nextInt();
	        scanner.nextLine(); // Consume newline
	        System.out.print("Enter Loan Type (HomeLoan/CarLoan): ");
	        String loanType = scanner.nextLine();

	        Loan loan = new Loan(customerId, principalAmount, interestRate, loanTerm, loanType, "Pending");
	        try {
	            loanRepository.applyLoan(loan);
	            System.out.println("Loan application submitted successfully.");
	        } catch (SQLException e) {
	            System.out.println("Error applying for loan: " + e.getMessage());
	        }
	    }

	    private static void viewAllLoans() {
	        try {
	            List<Loan> loans = loanRepository.getAllLoans();
	            if (loans.isEmpty()) {
	                System.out.println("No loans found.");
	            } else {
	                loans.forEach(System.out::println);
	            }
	        } catch (SQLException e) {
	            System.out.println("Error retrieving loans: " + e.getMessage());
	        }
	    }

	    private static void viewLoanDetails() {
	        System.out.print("Enter Loan ID: ");
	        int loanId = scanner.nextInt();
	        try {
	            Loan loan = loanRepository.getLoanById(loanId);
	            if (loan != null) {
	                System.out.println(loan);
	            } else {
	                System.out.println("Loan not found.");
	            }
	        } catch (SQLException e) {
	            System.out.println("Error retrieving loan details: " + e.getMessage());
	        }
	    }

	    private static void makeRepayment() {
	        System.out.print("Enter Loan ID: ");
	        int loanId = scanner.nextInt();
	        System.out.print("Enter Repayment Amount: ");
	        double amount = scanner.nextDouble();
	        try {
	            loanRepository.loanRepayment(loanId, amount);
	            System.out.println("Repayment processed successfully.");
	        } catch (SQLException e) {
	            System.out.println("Error processing repayment: " + e.getMessage());
	        }
	    }
	}



