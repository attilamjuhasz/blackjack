import java.util.Scanner;

public class Black {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("");
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
        int dTotal = dealer1 + dealer2;

        System.out.println("");
        System.out.println("Dealer has: " + dealer1);
        System.out.println("");
        System.out.println("Your cards: " + card1 + " and " + card2);

        String out = "";
        int rep = 0;


        while (pTotal < 22 && out.isEmpty()){
            System.out.println("");
            System.out.println("Hit, Stand, or Double Down?");
            String choice = scanner.next();
            choice = choice.toLowerCase();

            if (choice.equals("hit")) {
                int card = (int)(Math.random() * 10) + 2;
                pTotal += card;
                System.out.println("");
                System.out.println("You were dealt: " + card);
                System.out.println("Total: " + pTotal);
            }
            else if (choice.equals("stand")) {
                out = "stand";
            }
            else if (true) {
                out = "stand";
                money -= bet;
                bet = bet*2;
                int card = (int)(Math.random() * 10) + 2;
                pTotal += card;
                System.out.println("");
                System.out.println("You were dealt: " + card);
                System.out.println("Total: " + pTotal);
            }
        }

        if (pTotal >= 22){
            out = "";
            System.out.println("");
            System.out.println("You bust!");
            System.out.println("Money: " + money);
        }

        while (dTotal < 17 && pTotal < 22) {
            int dealer3 = (int)(Math.random() * 10) + 2;
            dTotal += dealer3;
            System.out.println("");
            System.out.println("Dealer pulled a card: " + dealer3);
            System.out.println("Dealer's new total: " + dTotal);
        }

        if (dTotal > 21) {
            out = "";
            System.out.println("");
            System.out.println("House Bust!");
            System.out.println("You Win!");
            if (card1 + card2 == pTotal && pTotal == 21) {
                money += bet;
                bet = bet * 1.5;
                money +=bet;
                System.out.println("Blackjack!");
                System.out.println("Money: " + money);
            }
            else {
                money += bet;
                money += bet;
                System.out.println("Money: " + money);
            }
        }
        else if (pTotal > dTotal){
            out = "";
            System.out.println("");
            System.out.println("You Win!");
            if (card1 + card2 == pTotal && pTotal == 21) {
                money += bet;
                bet = bet * 1.5;
                money +=bet;
                System.out.println("Blackjack!");
                System.out.println("Money: " + money);
            }
            else {
                money += bet;
                money += bet;
                System.out.println("Money: " + money);
            }
        }
        else if (dTotal > pTotal){
            out = "";
            System.out.println("");
            System.out.println("House Wins!");
            System.out.println("Money: " + money);
        }
        else if (dTotal == pTotal) {
            out = "";
            System.out.println("");
            System.out.println("It's a tie!");
            money += bet;
            System.out.println("Money: " + money);
        }


        scanner.close();
    }
}