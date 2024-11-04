package it2e.deguma.gmss;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IT2EDEGUMAGMSS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        member mem = new member();
        
        boolean running = true;  
        
        while (running) {
            displayMenu();  // Method to display the menu
            
            int op = -1;
            while (true) {  // Loop until a valid option is entered
                try {
                    System.out.print("Select an Option: ");
                    op = sc.nextInt();
                    sc.nextLine();  // Consume the newline character
                    
                    // Check if the option is valid
                    if (op < 1 || op > 3) {
                        System.out.println("Invalid selection. Please select a number between 1 and 3.");
                    } else {
                        break;  // Exit the loop if a valid option is entered
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    sc.nextLine();  // Clear the invalid input
                }
            }

            switch (op) {
                case 1:
                    mem.mTransactions();
                    break;

                case 2:
                    mem.viewMembers();
                    break;

                case 3:
                    System.out.print("Exit Selected... Type 'yes' to confirm: ");
                    String resp = sc.nextLine();
                    if (resp.equalsIgnoreCase("yes")) {
                        running = false;  
                        System.out.println("Exiting the system...");
                    }
                    break;
            }
        }

        sc.close(); 
        System.out.println("Thank you for using the Gym Membership System. Goodbye!");
    }

    // Method to display the menu
    private static void displayMenu() {
        System.out.println("\n------------------------------------------------");
        System.out.println("        WELCOME TO GYM MEMBERSHIP SYSTEM      ");
        System.out.println("------------------------------------------------");
        System.out.println("1. MEMBERS ");
        System.out.println("2. VIEW MEMBERS ");
        System.out.println("3. EXIT ");
    }
}
