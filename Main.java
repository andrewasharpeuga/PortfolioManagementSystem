package com.portfolio;

import com.portfolio.auth.AuthenticationService;
import com.portfolio.investment.*;
import com.portfolio.report.ReportService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

        // Command-line interface logic for user interactions
        Scanner scanner = new Scanner(System.in);
        AuthenticationService authService = new AuthenticationService();

        System.out.println("Welcome to Financial Portfolio Management System");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (authService.login(username, password)) {
            System.out.println("Login successful!");
            InvestmentService investmentService = new InvestmentService();
            ReportService reportService = new ReportService(investmentService);

            while (true) {
                System.out.println("1. Add Investment");
                System.out.println("2. Remove Investment");
                System.out.println("3. View Portfolio");
                System.out.println("4. Generate Report");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter investment type (stock/bond/mutualfund): ");
                        String type = scanner.nextLine();
                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter amount invested: ");
                        double amountInvested = scanner.nextDouble();
                        scanner.nextLine(); // consume newline

                        if ("stock".equalsIgnoreCase(type)) {
                            System.out.print("Enter shares: ");
                            int shares = scanner.nextInt();
                            System.out.print("Enter current price per share: ");
                            double price = scanner.nextDouble();
                            scanner.nextLine(); // consume newline
                            Stock stock = new Stock(name, amountInvested, shares, price);
                            investmentService.addInvestment(stock);
                        } else if ("bond".equalsIgnoreCase(type)) {
                            System.out.print("Enter interest rate: ");
                            double rate = scanner.nextDouble();
                            System.out.print("Enter years: ");
                            int years = scanner.nextInt();
                            scanner.nextLine(); // consume newline
                            Bond bond = new Bond(name, amountInvested, rate, years);
                            investmentService.addInvestment(bond);
                        } else if ("mutualfund".equalsIgnoreCase(type)) {
                            System.out.print("Enter net asset value: ");
                            double nav = scanner.nextDouble();
                            scanner.nextLine(); // consume newline
                            MutualFund mutualFund = new MutualFund(name, amountInvested, nav);
                            investmentService.addInvestment(mutualFund);
                        } else {
                            System.out.println("Invalid investment type.");
                        }
                        break;
                    case 2:
                        System.out.print("Enter name of investment to remove: ");
                        String investmentName = scanner.nextLine();
                        investmentService.getInvestments().stream()
                                .filter(inv -> inv.getName().equalsIgnoreCase(investmentName))
                                .findFirst()
                                .ifPresent(investmentService::removeInvestment);
                        break;
                    case 3:
                        System.out.println("Portfolio Summary");
                        System.out.println("----------------");
                        investmentService.getInvestments().forEach(inv -> {
                            System.out.println("Name: " + inv.getName());
                            System.out.println("Amount Invested: " + inv.getAmountInvested());
                            System.out.println("Current Value: " + inv.getCurrentValue());
                            System.out.println();
                        });
                        break;
                    case 4:
                        reportService.generateReport();
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Login failed!");
        }
    }
}
