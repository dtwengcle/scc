package it2e.deguma.gmss;


import java.util.InputMismatchException;
import java.util.Scanner; 

public class IT2EDEGUMAGMSS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
     
        member mem = new member();
        
        int op = -1; 
        
        do {
            try {
                System.out.println("\n------------------------------------------------");
                System.out.println("        WELCOME TO GYM MEMBERSHIP SYSTEM      ");
                System.out.println("------------------------------------------------");
   

                System.out.println("1. MEMBERS ");
                System.out.println("2. EXIT ");

                System.out.print("\nSelect an Option: ");
                op = sc.nextInt();
                sc.nextLine(); 

                switch (op) {
                    case 1:
                        mem.mTransactions();
                        break;

                    case 2:
                        System.out.println("Exiting....");
                        break;

                    default:
                        System.out.println("Invalid Option.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.nextLine();  
                op = -1;  
            }
        } while (op != 2);

        sc.close(); 
    }

}


    

