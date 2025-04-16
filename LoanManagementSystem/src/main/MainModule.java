package main;
import dao.ILoanRepository;
import dao.ILoanRepositoryimpl;

import java.util.Scanner;

import Entity.Customer;
import Entity.HomeLoan;
import Entity.Loan;
import Entity.CarLoan;
import Util.DBPropertutil;
import dao.*;
import exception.InvalidLoanException;

public class MainModule {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ILoanRepository repo = new ILoanRepositoryimpl(); 
        while (true) {
        	System.out.println("\n=== Loan Management System ===");
            System.out.println("1. Apply for Loan");
            System.out.println("2. View All Loans");
            System.out.println("3. Get Loan by ID");
            System.out.println("4. Calculate EMI");
            System.out.println("5. Loan Repayment");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
            case 1:
                applyLoan(scanner, repo);
                break;
            case 2:
                viewAllLoans(repo);
                break;
            case 3:
                getLoanById(scanner, repo);
                break;
            case 4:
                calculateEmi(scanner, repo);
                break;
            case 5:
                repayLoan(scanner, repo);
                break;
            case 6:
                System.out.println("✅ Exiting application. Goodbye!");
                return;
            default:
                System.out.println("❌ Invalid choice. Try again.");

            }
            
            }
        }
	private static void viewAllLoans(ILoanRepository repo) {
		// TODO Auto-generated method stub
		
	}
	private static void applyLoan(Scanner scanner, ILoanRepository repo) {
		try {
			System.out.println("Enter customer ID:");
            int CustomerID = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter loan type (HomeLoan/CarLoan):");
            String loanType = scanner.nextLine();

            System.out.println("Enter principal amount:");
            double amount = scanner.nextDouble();

            System.out.println("Enter interest rate:");
            double rate = scanner.nextDouble();
            System.out.println("Enter loan term in months:");
            int term = scanner.nextInt();

            Loan loan = null;
            if (loanType.equalsIgnoreCase("HomeLoan")) {
                scanner.nextLine();
                System.out.println("Enter property address:");
                String address = scanner.nextLine();

                System.out.println("Enter property value:");
                int value = scanner.nextInt();

                loan = new HomeLoan(0, new Customer(CustomerID) , amount, rate, term, "HomeLoan", "Pending", address, value);
            } else if (loanType.equalsIgnoreCase("CarLoan")) {
                scanner.nextLine();
                System.out.println("Enter car model:");
                String model = scanner.nextLine();

                System.out.println("Enter car value:");
                int carValue = scanner.nextInt();

                loan = new CarLoan(0, new Customer(CustomerID) , amount, rate, term, "CarLoan", "Pending", model, carValue);
            }
            System.out.println("Confirm loan application? (Yes/No):");
            String confirm = scanner.next();
            if (confirm.equalsIgnoreCase("Yes")) {
                repo.applyLoan(loan);
            } else {
                System.out.println("Loan application canceled.");
            }
            
		}catch (Exception e) {
            System.out.println("❌ Error applying for loan: " + e.getMessage());
        }
	}
	private static void getLoanById(Scanner scanner, ILoanRepository repo) {
		System.out.println("Enter Loan ID:");
        int id = scanner.nextInt();
        try {
            Loan loan = repo.getLoanByID(id);
            System.out.println(loan);
        } catch (InvalidLoanException e) {
            System.out.println("❌ " + e.getMessage());
        }
	}
	private static void calculateEmi(Scanner scanner, ILoanRepository repo) {
        System.out.println("Enter Loan ID to calculate EMI:");
        int loanId = scanner.nextInt();
        try {
            double emi = repo.calculateemi(loanId);
            System.out.println("📌 Monthly EMI: " + emi);
        } catch (InvalidLoanException e) {
            System.out.println("❌ " + e.getMessage());
        }
    }
	private static void repayLoan(Scanner scanner, ILoanRepository repo) {
        System.out.println("Enter Loan ID:");
        int loanId = scanner.nextInt();

        System.out.println("Enter amount to repay:");
        double amount = scanner.nextDouble();

        try {
            repo.loanRepayment(loanId, amount);
        } catch (InvalidLoanException e) {
            System.out.println("❌ " + e.getMessage());
        }
    }
	
	

}
