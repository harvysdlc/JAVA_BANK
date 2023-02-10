public class Accounts {

    private int accountsATM [][] = {
    /*Account 1*/  {201511032, 88888, 80500},
    /*Account 2*/  {201563244, 12345, 3000},
    /*Account 3*/  {201410230, 54321, 27450},
    /*Account 4*/  {201596427, 98765, 6500},
    /*Account 5*/  {201456329, 65432, 13200}
    };
   
    public boolean accountChecker(int userAccount, int userPin){
        int i = 0;
        int existingAccount, correctPin;        
        while (i <= 4) {            
            existingAccount = accountsATM[i][0];
            correctPin = accountsATM[i][1];           
            if(existingAccount == userAccount && correctPin == userPin){
                setcurrentAccount(i);
                return true;
            }
            i++;
        }
        return false;
    }

    private int currentAccount; 
    public int getcurrentAccount() {
        return this.currentAccount;
    }
    public void setcurrentAccount(int i) {
        this.currentAccount = i;
    }
    public int getBalance(int i){
        return this.accountsATM[i][2];
    }   
    public void setBalance(int i, int val){
        this.accountsATM[i][2] += val;
    }  
    public void reduceBalance(int i, int val){
        this.accountsATM[i][2] -= val;   
    }
}
