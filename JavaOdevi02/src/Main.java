import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        System.out.println("Welcome! Please enter 'A' if you are an Admin, please enter 'C' if you are a Client.");
        Scanner signIn = new Scanner(System.in);
        String user = signIn.next();

        if (user.equals("A")){
            System.out.println("You are an Admin!");
        } else if (user.equals("C")) {
            System.out.println("You are a Client!");
        } else {
            System.out.println("Wrong input please re-enter.");
        }


    }
}