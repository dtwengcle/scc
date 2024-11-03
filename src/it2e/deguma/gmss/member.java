
package it2e.deguma.gmss;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class member {
   
    Scanner sc = new Scanner(System.in);
    config conf = new config();
    
    public void mTransactions() {
        int act;

        do {
            try {
                System.out.println("\n-----------------------------------------------");
                System.out.println("       == Membership ==");
                System.out.println("-----------------------------------------------");
                
                System.out.println("1. Add Member");
                System.out.println("2. View Member");
                System.out.println("3. Update Member");
                System.out.println("4. Delete Member");
                System.out.println("5. Back to Main Menu");

                System.out.print("\nSelect an option: ");
                act = sc.nextInt();
                sc.nextLine();

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
                        System.out.println("Invalid Option.");
                }
        
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.nextLine();
                act = -1;
            }
        } while (act != 5);
    }
    

    private void addMembers() {
      
        Scanner sc = new Scanner(System.in);
      
        System.out.print("Name: ");
        String name = sc.next();
        System.out.print("Payment: ");
        String pay = sc.next();
        System.out.print("Selected Plan: ");
        String sp = sc.next();
        System.out.print("Date and Time: ");
        String date = sc.next();
        System.out.print("Instructor: ");
        String instructor = sc.next();
        System.out.print("Location: ");
        String ln = sc.next();

        String sql = "INSERT INTO members (m_name, m_payment, m_dt, m_selectedplan) VALUES (?, ?, ?, ?)";


        conf.addRecord(sql, name, pay, sp, date);
          }
          
    
    public void viewMembers(){
        System.out.println("\n---------------------------------------------------------------------------------------------");
        System.out.println("                                   == MEMBER DETAILS ==             ");
        
       config conf = new config();
        
        String qry = "SELECT * FROM members";
        String[] headers = {"ID", "Name", "Payment", "Date and Time", "Selected Plan"};
        String[] column = {"m_id", "m_name", "m_payment", "m_dt", "m_selectedplan"};

        conf.viewRecords(qry, headers, column);
          }
    
    private void updateMembers(){
        System.out.print("Enter ID to Update: ");
        int id = sc.nextInt();
        
        while(conf.getSingleValue("SELECT m_id FROM member WHERE m_id = ?",id)==0){
            System.out.println("Selected ID doesn't exist! ");
            System.out.print("Select member Id Again: ");
            id = sc.nextInt();
            sc.nextLine();
        }
                               
                 System.out.println("Name: ");
                 String name = sc.next();
                 System.out.println("Payment: ");
                 String pay = sc.next();
                 System.out.println("Date & Time: ");
                 String dt = sc.next();
                 System.out.println("Selected plan: ");
                 String sp = sc.next();
                 System.out.println("Instructor: ");
                 String instructor = sc.next();
                 System.out.println("Location: ");
                 String ln = sc.next();
                
                 
                 String qry = "UPDATE members SET m_name = ?, m_payment = ?, m_dt = ?, m_selectedplan = ?, _instructor = ?, m_loactionWHERE m_id = ?";
                   
                
                 conf.updateRecord(qry, id, name, pay, dt, sp);
             }
    
    private void deleteMembers(){
        System.out.print("Enter ID to Delete: ");
        int id = sc.nextInt();
        
        while(conf.getSingleValue("SELECT m_id FROM members WHERE m_id = ?",id)==0){
            System.out.println("Selected ID doesn't exist! ");
            System.out.print("Select member Id Again: ");
            id = sc.nextInt();
            sc.nextLine();
        }
        
        String qry = "DELETE FROM members WHERE c_id = ?";
        conf.deleteRecord(qry, id);
        
        
        
        
}
    }

        


   
