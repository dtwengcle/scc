package it2e.deguma.gmss;

import java.util.InputMismatchException;
import java.util.Scanner;

public class member {
    
    private Scanner sc = new Scanner(System.in);
    private config conf = new config();  // Single instance of config
    
    public void mTransactions() {
        int act;

        do {
            try {
                System.out.println("\n-----------------------------------------------");
                System.out.println("                 == Membership Panel ==            "); 
                System.out.println("-----------------------------------------------");
                
                System.out.println("1. Add Member");
                System.out.println("2. View Members");
                System.out.println("3. Update Member");
                System.out.println("4. Delete Member");
                System.out.println("5. Back to Main Menu");

                System.out.print("\nSelect an option: ");
                act = sc.nextInt();
                sc.nextLine();  // Consume the newline character

                switch (act) {
                    case 1:
                        addMembers();
                        viewMembers();
                        break;
                
                    case 2:
                        viewMembers();  
                        break;
                
                    case 3:
                        viewMembers();
                        updateMembers();
                        viewMembers();
                        break;
            
                    case 4:
                        viewMembers();
                        deleteMembers();
                        viewMembers();
                        break;
                
                    case 5:
                        System.out.println("Returning to the main menu...");
                        break;
        
                    default:
                        System.out.println("Invalid Option. Please try again.");
                }
        
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.nextLine();  // Clear invalid input
                act = -1;  // Reset act to force a repeat
            }
        } while (act != 5);
    }
    
    private void addMembers() {
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Payment: ");
        String pay = sc.nextLine();
        System.out.print("Selected Plan: ");
        String sp = sc.nextLine();
        System.out.print("Date and Time: ");
        String date = sc.nextLine();
        System.out.print("Instructor: ");
        String instructor = sc.nextLine();
        System.out.print("Location: ");
        String ln = sc.nextLine();

        String sql = "INSERT INTO tbl_membership (m_name, m_payment, m_dt, m_selectedplan, m_instructor, m_ln) VALUES (?, ?, ?, ?, ?, ?)";
        conf.addRecord(sql, name, pay, date, sp, instructor, ln);
        System.out.println("Member added successfully!");
    }
    
    public void viewMembers() {
        String qry = "SELECT * FROM tbl_membership";
        String[] columnHeaders = {"ID", "Name", "Payment", "Date and Time", "Selected Plan", "Instructor", "Location"};
        String[] columnNames = {"m_id", "m_name", "m_payment", "m_dt", "m_selectedplan", "m_instructor", "m_ln"};
        
        conf.viewRecords(qry, columnHeaders, columnNames);
    }
    
    private void updateMembers() {
        System.out.print("Enter ID to Update: ");
        int id = sc.nextInt();
        sc.nextLine();  // Consume the newline character
        
        while(conf.getSingleValue("SELECT m_id FROM tbl_membership WHERE m_id = ?", id) == 0) {
            System.out.println("Selected ID doesn't exist! ");
            System.out.print("Select member ID Again: ");
            id = sc.nextInt();
            sc.nextLine(); 
        }

        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Payment: ");
        String pay = sc.nextLine();
        System.out.print("Date & Time: ");
        String dt = sc.nextLine();
        System.out.print("Selected Plan: ");
        String sp = sc.nextLine();
        System.out.print("Instructor: ");
        String instructor = sc.nextLine();
        System.out.print("Location: ");
        String ln = sc.nextLine();
        
        String qry = "UPDATE tbl_membership SET m_name = ?, m_payment = ?, m_dt = ?, m_selectedplan = ?, m_instructor = ?, m_location = ? WHERE m_id = ?";
        conf.updateRecord(qry, name, pay, dt, sp, instructor, ln, id);
        System.out.println("Member updated successfully!");
    }
    
    private void deleteMembers() {
        System.out.print("Enter ID to Delete: ");
        int id = sc.nextInt();
        sc.nextLine();  // Consume the newline character
        
        while (conf.getSingleValue("SELECT m_id FROM tbl_membership WHERE m_id = ?", id) == 0) {
            System.out.println("Selected ID doesn't exist! ");
            System.out.print("Select member ID Again: ");
            id = sc.nextInt();
            sc.nextLine(); 
        }
        
        String qry = "DELETE FROM tbl_membership WHERE m_id = ?";
        conf.deleteRecord(qry, id);
        System.out.println("Member deleted successfully!");
    }
}
