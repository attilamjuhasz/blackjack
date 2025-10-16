import java.util.Scanner;

public class Black {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Buy in: ");
        double money = scanner.nextDouble();
        
        System.out.println("Bet: ");
        double bet = scanner.nextDouble();
        money -= bet;


        int card1 = (int)(Math.random() * 10) + 2;
        int card2 = (int)(Math.random() * 10) + 2;
        int pTotal = card1 + card2;

        int dealer1 = (int)(Math.random() * 10) + 2;
        int dealer2 = (int)(Math.random() * 10) + 2;
        int dealerTotal = dealer1 + dealer2;

        System.out.println("");
        System.out.println("Your cards: " + card1 + " and " + card2);
        System.out.println("");
        System.out.println("Dealer has: " + dealer1);

        while (pTotal < 22){
            System.out.println("");
            System.out.println("Hit or Stand?");
            String choice = scanner.next();
        }


    }
}