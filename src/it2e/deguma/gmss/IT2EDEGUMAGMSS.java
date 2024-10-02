package it2e.deguma.gmss;


import java.util.Scanner; 

public class IT2EDEGUMAGMSS {

    public static void addMembers(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        
        System.out.print("Name: ");
        String name = sc.next();
        System.out.print("Payment: ");
        String pay = sc.next();
        System.out.print("Selected Plan: ");
        String sp = sc.next();
         System.out.print("Date and Time: ");
        String date = sc.next();

        String sql = "INSERT INTO members (m_name, m_payment, m_date_and_time, m_selectedplan) VALUES (?, ?, ?, ?)";


        conf.addRecord(sql, name, pay, sp, date);


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("1. ADD");
        System.out.println("2. VIEW");
        System.out.println("3. UPDATE");
        System.out.println("4. DELETE");
        System.out.println("5. EXIT");
        
        System.out.println("Enter action: ");
        int action = sc.nextInt();
        
        switch(action){
            case 1:
                IT2EDEGUMAGMSS test = new IT2EDEGUMAGMSS();
                test.addMembers();
                break;
           
        }
        
        
        
    }
}

        
        

    
      
    
    
    

