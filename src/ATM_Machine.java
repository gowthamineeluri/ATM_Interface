import java.util.Scanner;

public class ATM_Machine {

    public static User user;

    public static void main(String[] args) {
        user=new User();
        atm_operations();
    }

    public static void atm_operations(){
        System.out.println();
        System.out.println("------ Welcome to ABC ATM Machine -------");
        System.out.println();
        while (true) {
            System.out.println("1. Deposit Amount ");
            System.out.println("2. Withdraw Amount");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.println();

            Scanner scanner = new Scanner(System.in);
            int choice = -1;

            while (true) {
                try {
                    System.out.println("Please choose your operation (1-4): ");
                    choice = scanner.nextInt();

                    if (choice >= 1 && choice <= 4) {
                        break;
                    } else {
                        System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a number between 1 and 4.");
                    scanner.next(); // Clear the invalid input
                }
            }

            switch (choice) {
                case 1:
                    deposit_amount();
                    break;
                case 2:
                    withdraw_amount();
                    break;
                case 3:
                    check_balance();
                    break;
                case 4:
                    System.exit(0);
            }

        }


        }

    public static void deposit_amount(){
        int amount = take_amount();
        user.setAccountBalance(
                user.getAccountBalance()+amount);
        atm_operations();

    }

    public static void withdraw_amount(){
        int amount = take_amount();
        if(amount>user.getAccountBalance()){
            System.out.println("Insufficient funds...please make sure to have sufficient money");
            atm_operations();
        }

        user.setAccountBalance(
                user.getAccountBalance()-amount);
        atm_operations();
    }

    public static void check_balance(){
        System.out.println("Your Current Account Balance is... "+ user.getAccountBalance());
        atm_operations();
    }

    public static int take_amount(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please enter the amount");
        int amount=0;
        try {
            amount= scanner.nextInt();
            if(amount<0){
                System.out.println("please enter valid money");
                amount=take_amount();
            }


        }catch (Exception e){
            System.out.println("please enter amount in numbers only");
            amount=take_amount();
        }

        return amount;
    }


}
