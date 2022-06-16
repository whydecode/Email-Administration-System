package emailapp;
import java.util.*;
public class EmailApp {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter First Name");
        String f_name = s.next();
        System.out.println("Enter Last Name");
        String l_name = s.next();
        Email e = new Email(f_name, l_name);
        int choice = -1;
        do{
            System.out.println("\n********\nEnter your choice \n 1. Show Info \n 2. Change Password \n 3. Change mailbox capacity \n 4. Set Alternative Email \n 5. Store Data in file \n 6. Display Data from file \n 7. Exit");
            choice = s.nextInt();
            switch(choice){
                case 1:
                    e.getInfo();
                    break;
                case 2:
                    e.set_password();
                    break;
                case 3:
                    e.set_mailCap();
                    break;
                case 4:
                    e.alternate_email();
                    break;
                case 5:
                    e.storeFile();
                    break;
                case 6:
                    e.read_file();
                case 7:
                    System.out.println("\nThank you for using application!");
                    break;
                default:
                    System.out.println("Invalid choice!! \n Enter proper Choice again");
            }
        }while(choice!=7);
        e.getInfo();
    }
}
