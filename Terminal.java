import java.util.*;
public class Terminal extends Accounts{
    
    public void sayWelcome(){
        System.out.println("\nWelcome!");
        loginHere();
    }

    public void loginHere(){
        try (Scanner sc = new Scanner(System.in)) {
            int userAccount, userPin;
            System.out.print("Please enter your account number: ");
            userAccount = sc.nextInt();
            System.out.print("Please enter your 5-digit pin: ");
            userPin = sc.nextInt();
            if(accountChecker(userAccount, userPin) == true){
                mainMenu();
            }
            else {
                System.out.println("-- Account Not Found! --");
                sayWelcome();
            }
        }
    }
    
    public void mainMenu(){
        int userChoice;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("\nMain Menu:");
            System.out.println("1 - View my balance\n2 - Withdraw cash\n3 - Deposit funds\n4 - Exit");
            System.out.print("Enter a choice: ");
            userChoice = sc.nextInt();
            switch(userChoice){
                case 1: balanceInquiry();
                break;
                case 2: withdrawal();
                break;
                case 3: deposit();
                break;
                case 4: System.out.println("-- Thankyou for using our service! --");  
                sayWelcome();
                break;
            }
        }
    }

    public void balanceInquiry(){
            System.out.println("Balance Information:");
            System.out.println("Available Balance: $" + getBalance(getcurrentAccount()));   
            mainMenu();      
    }

    public void withdrawal(){
        int userPick;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("\nWithdraw Amount:");
            System.out.println("1 - $20\n2 - $40\n3 - $60\n4 - $100\n5 - $200\n6 - Cancel");
            System.out.print("Enter a choice: ");
            userPick = sc.nextInt();
            switch(userPick){
                case 1: if(getBalance(getcurrentAccount()) < 20){
                    System.out.println("-- Insufficient remaining balance. --\n-- Please choose a smaller amount --");
                    withdrawal();
                }
                else {
                    reduceBalance(getcurrentAccount(), 20);
                    System.out.println("-- You can now take the money! --");
                }
                break;
                case 2: if(getBalance(getcurrentAccount()) < 40){
                    System.out.println("-- Insufficient remaining balance. --\n-- Please choose a smaller amount --");
                    withdrawal();
                }
                else {
                    reduceBalance(getcurrentAccount(), 40);
                    System.out.println("-- You can now take the money! --");
                }
                break;
                case 3: if(getBalance(getcurrentAccount()) < 60){
                    System.out.println("-- Insufficient remaining balance. --\n-- Please choose a smaller amount --");
                    withdrawal();
                }
                else {
                    reduceBalance(getcurrentAccount(), 60);
                    System.out.println("-- You can now take the money! --");
                }
                break;
                case 4: if(getBalance(getcurrentAccount()) < 100){
                    System.out.println("-- Insufficient remaining balance. --\n-- Please choose a smaller amount --");
                    withdrawal();
                }
                else {
                    reduceBalance(getcurrentAccount(), 100);
                    System.out.println("-- You can now take the money! --");
                }
                break;
                case 5: if(getBalance(getcurrentAccount()) < 200){
                    System.out.println("-- Insufficient remaining balance. --\n-- Please choose a smaller amount --");
                    withdrawal();
                }
                else {
                    reduceBalance(getcurrentAccount(), 200);
                    System.out.println("-- You can now take the money! --");
                }
                break;
                case 6: mainMenu();
                break; 
            }mainMenu();
        }
    }

    public void deposit(){
        int depositAmount;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Please enter a deposit amount (or 0 to cancel): ");
            depositAmount = sc.nextInt();
            if (depositAmount == 0){
                mainMenu();                 
            }
            else if (depositAmount >= 1){
                setBalance(getcurrentAccount(), depositAmount);
                System.out.println("Please enter a deposit envelope containing $" + depositAmount);
                System.out.println("Your envelope has been received.");  
            }
            else mainMenu();
            mainMenu();
        }  
    }
}


