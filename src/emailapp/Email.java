package emailapp;
import java.util.*;
import java.io.*;
public class Email {
    public Scanner s = new Scanner(System.in);

    String fname;
    String lname;
    String dept;
    String email;
    String password;
    int mailCapacity = 500;
    String alter_email;

    public Email(String fname, String lname){
        this.fname = fname;
        this.lname = lname;
        System.out.println("New Employee: " + fname + " " + lname);
        // Calling methods;
        this.dept = this.setDept();
        this.password = this.generate_password(8);
        this.email = this.generate_email();
    }

    private String generate_email(){
        return this.fname.toLowerCase()+this.lname.toLowerCase()+"@"+this.dept.toLowerCase()+".company.com";
    }

    private String setDept(){
        System.out.println("Department codes \n 1 for Sales \n 2 for Development \n 3 for Accounts");
        boolean flag = false;
        do{
            System.out.println("Enter Department Code");
            int choice = s.nextInt();
            switch (choice){
                case 1:
                    return "Sales";
                case 2:
                    return "Development";
                case 3:
                    return "Accounts";
                case 0:
                    return "None";
                default:

                    System.out.println("Invalid choice please choose again");
            }
        }while(!flag);
        return null;
    }
    // Generate random password method
    private String generate_password(int length){
        Random r = new Random();
        String cap_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%^&?";
        String values = cap_chars+small_chars+numbers+symbols;
        String password = "";
        for(int i = 0; i < length; i++){
            password = password+values.charAt(r.nextInt(values.length()));
        }
        return password;
    }

    public void set_password(){
        boolean flag = false;
        do{
            System.out.println("Do you want to change your password! (Y/N)");
            char choice = s.next().charAt(0);
            if(choice=='Y'||choice=='y'){
                flag = true;
                System.out.println("Enter Current password");
                String temp = s.next();
                if(temp.equals(this.password)){
                    System.out.println("Enter new password: ");
                    this.password = s.next();
                    System.out.println("Password Changed Successfully");
                }else
                    System.out.println("Incorrect Password");
            }else if(choice == 'N' || choice == 'n'){
                flag = true;
                System.out.println("Password changed option cancelled!");
            }else{
                System.out.println("Invalid Input");
            }
        }while(!flag);
    }

    public void set_mailCap(){
        System.out.println("Current Capacity = " + this.mailCapacity + "mb");
        System.out.println("Enter new mailbox capacity: ");
        this.mailCapacity = s.nextInt();
        System.out.println("Mailbox capacity is successfully changed");
    }

    public void alternate_email(){
        System.out.println("Enter new alternate mail: ");
        this.alter_email = s.next();
        System.out.println("Alternative email is set");
    }

    public void getInfo(){
        System.out.println("Name: "+this.fname+" "+this.lname);
        System.out.println("Department: "+this.dept);
        System.out.println("Email: "+this.email);
        System.out.println("Password: "+this.password);
        System.out.println("Mailbox Capacity: "+this.mailCapacity);
        System.out.println("Alternative Email: "+this.alter_email);
    }

    public void storeFile(){
        try{
            FileWriter in = new FileWriter("C:\\Users\\rahul\\Desktop\\info.txt");
            in.write("First Name: "+this.fname);
            in.append("\nLast Name: "+this.lname);
            in.append("\nEmail: "+this.email);
            in.append("\nPassword: "+ this.password);
            in.append("\nCapacity"+this.mailCapacity);
            in.append("\nAlternate Email: "+this.alter_email);
            in.close();
            System.out.println("Data Stored....");
        }catch (Exception e){
            System.out.println(e);
        }


    }
    public void read_file(){
        // Reading file method
        try {
            FileReader f1 = new FileReader("C:\\Users\\rahul\\Desktop\\info.txt");
            int i;
            while((i=f1.read())!= -1){
                System.out.print((char)i);
            }
            f1.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }


}
