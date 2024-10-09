package it2e.deguma.gmss;


import java.util.Scanner; 

public class IT2EDEGUMAGMSS {
    static config conf = new config();
    
    public static void addMembers(){
        Scanner sc = new Scanner(System.in);
        
        
        System.out.print("Id : ");
        int id = sc.nextInt();
        System.out.print("Name: ");
        String name = sc.next();
        System.out.print("Payment: ");
        String pay = sc.next();
        System.out.print("Selected Plan: ");
        String sp = sc.next();
        System.out.print("Date and Time: ");
        String date = sc.next();

        String sql = "INSERT INTO members (m_id, m_name, m_payment, m_date_and_time, m_selectedplan) VALUES (?, ?, ?, ?, ?)";


        conf.addRecord(sql, id, name, pay, sp, date);


    }
    
    private void viewMembers(){
        config conf = new config();
        
        String qry = "SELECT * FROM members";
        String[] headers = {"ID", "Name", "Payment", "Date and Time", "Selected Plan"};
        String[] column = {"m_id", "m_name", "m_payment", "m_date_and_time", "m_selectedplan"};

        conf.viewRecords(qry, headers, column);
        
        
        
    }
    
    
    public void updateMembers() {
                 Scanner sc = new Scanner(System.in);
                 config conf = new config();
                 
                 System.out.println("Id : ");
                 String id = sc.next();               
                 System.out.println("Name: ");
                 String name = sc.next();
                 System.out.println("Payment: ");
                 String pay = sc.next();
                 System.out.println("Date & Time: ");
                 String dt = sc.next();
                 System.out.println("Selected plan: ");
                 String sp = sc.next();
                
                 
                 String qry = "UPDATE members SET m_name = ?, m_payment = ?, m_date_and_time = ?, m_selectedplan = ? WHERE m_id = ?";
                 
                
                 conf.updateRecord(qry, id, name, pay, dt, sp);
             }
             
  
    
    public void deleteMembers(){
                 Scanner sc = new Scanner(System.in);
                 System.out.println("Enter ID to delete");
                 int id = sc.nextInt();
                 
                 String qry = "DELETE FROM members WHERE m_id = ? ";
                 config conf = new config();
                 conf.deleteRecord(qry, id);
                 
             }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String response;

        
        do{
                
        System.out.println("1. ADD");
        System.out.println("2. VIEW");
        System.out.println("3. UPDATE");
        System.out.println("4. DELETE");
        System.out.println("5. EXIT");
        
        System.out.println("Enter action: ");
        int action = sc.nextInt();
        
        
        IT2EDEGUMAGMSS member = new IT2EDEGUMAGMSS();
        
        switch(action){
            case 1:
                member.addMembers();
                break;
                
            case 2:
                member.viewMembers();  
                break;
            case 3:
                member.viewMembers();
                member.updateMembers();
              
                break;
            case 4:
                member.viewMembers();
                member.deleteMembers();
                member.viewMembers();
                
                break;
            case 5:
                System.out.println("Existing.....");
                break;
            default:
                System.out.println("Invalid action.Please try again.");
                
        }
        System.out.println("Do you want to continue? (yes/no): ");
        response = sc.next();
    }while(response.equalsIgnoreCase("yes"));
         System.out.println("Thank You, See you soones!");
         
         sc.close();
    
        }
             
                 
                         
                 


    
    
    
    
          
     
                   
           
           
        }
        
        
        
    


        
        

    
      
    
    
    

