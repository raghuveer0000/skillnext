import java.util.Scanner;

class Customer {
    private int accountNo;
    public String name;
    private float balance;


    Customer() {
        accountNo = 1000;
        name = "raghu";
        balance = 100.0f;
    }

    
    void deposit(int amount) {
        balance = balance + amount;
        System.out.println("After deposit, balance is: " + balance);
    }

        void withdraw(int amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance = balance - amount;
            System.out.println("After withdrawal, balance is: " + balance);
        }
    }
    
    void checkBalance() {
        System.out.println("Your current balance is: " + balance);
    }

    public static void main(String args[]) {        
        Customer obj = new Customer();       
        Scanner sc = new Scanner(System.in);        
        System.out.println("Enter amount to deposit:");
        int depositAmount = sc.nextInt();
        obj.deposit(depositAmount);
        System.out.println("Enter amount to withdraw:");
        int withdrawAmount = sc.nextInt();
        obj.withdraw(withdrawAmount);
        obj.checkBalance();
     
    }
}
