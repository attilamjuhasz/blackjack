import java.util.Scanner;

public class Blackjack{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("");
        System.out.println("Welcome to Blackjack Table!");
        System.out.println("");
        System.out.println("How much do you want to buy in for? $5 minimum.");
        double money = scanner.nextDouble();
        // consume the leftover newline after nextDouble so subsequent nextLine() works correctly
        scanner.nextLine();




        // Loop: keep playing hands until the player types 'leave' or runs out of money
        while (true) {
            int card1 = (int)(Math.random() * 11) + 1;
            int card2 = (int)(Math.random() * 11) + 1;

            System.out.println("");
            System.out.println("You are dealt two cards: " + card1 + " and " + card2);
            System.out.println("");
            System.out.println("Your total is: " + (card1 + card2));
            int playerScore = card1 + card2;

            int dealer1 = (int)(Math.random() * 11) + 1;
            int dealer2 = (int)(Math.random() * 11) + 1;
            System.out.println("");
            System.out.println("Dealer is dealt two cards. Card 1 is: " + dealer1);
            int dealerScore = dealer1 + dealer2;

            // Ask player how much they'd like to bet for this hand
            double bet = 0.0;
            while (true) {
                System.out.println("");
                System.out.println("You have $" + String.format("%.2f", money) + " available.");
                System.out.print("How much would you like to bet for this hand? $");
                String betInput = scanner.nextLine().trim();
                try {
                    bet = Double.parseDouble(betInput);
                    if (bet <= 0) {
                        System.out.println("Bet must be greater than $0. Try again.");
                    } else if (bet > money) {
                        System.out.println("You don't have enough money to make that bet. Try again.");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid numeric bet amount (e.g. 10 or 5.50).");
                }
            }
            System.out.println("You bet $" + String.format("%.2f", bet) + " for this hand.");

            // Player's turn
            boolean playerBusted = false;
            while (true) {
                System.out.println("");
                System.out.println("Your current score: " + playerScore);
                System.out.print("Do you want to 'hit' or 'stand'? ");
                String choice = scanner.nextLine().trim().toLowerCase();

                if (choice.equals("hit")) {
                    int card = (int)(Math.random() * 11) + 1; // Random card between 1 and 11
                    playerScore += card;
                    System.out.println("You drew a " + card + ". Your new score is " + playerScore);
                    if (playerScore > 21) {
                        System.out.println("You bust! Dealer wins this hand.");
                        playerBusted = true;
                        money -= bet;
                        System.out.println("");
                        System.out.println("You now have $" + String.format("%.2f", money) + " available.");
                        break;
                    }
                } else if (choice.equals("stand")) {
                    break;
                } else {
                    System.out.println("Invalid choice. Please type 'hit' or 'stand'.");
                }
            }

            // Dealer's turn (only if player didn't bust)
            if (!playerBusted) {
                while (dealerScore < 17) {
                    System.out.println("");
                    System.out.println("The dealer has a " + dealer1 + " and a " + dealer2);
                    System.out.println("");
                    System.out.println("Dealer's current score: " + dealerScore);
                    int card = (int)(Math.random() * 11) + 1;
                    dealerScore += card;
                    System.out.println("Dealer drew a " + card + ". Dealer's score is now " + dealerScore);
                }

                // Determine winner
                System.out.println("Your final score: " + playerScore);
                System.out.println("Dealer's final score: " + dealerScore);

                if (dealerScore > 21 || playerScore > dealerScore) {
                    System.out.println("You win this hand!");
                    if (playerScore == 21 && (card1 + card2) == 21) {
                        System.out.println("Blackjack! You win 1.5 times your bet.");
                        money += bet * 1.5;
                    }
                    else {
                        money += bet;
                    }
                } else if (playerScore < dealerScore) {
                    System.out.println("Dealer wins this hand!");
                    money -= bet;
                } else {
                    System.out.println("This hand is a tie!");
                }
                System.out.println("");
                System.out.println("You now have $" + String.format("%.2f", money) + " available.");
            }

            // Check if player ran out of money
            if (money <= 0) {
                System.out.println("You are out of money. Thanks for playing.");
                break;
            }

            // After each hand, ask the player if they want to leave
            System.out.println("");
            System.out.print("Type 'leave' to exit the table, or press Enter to play another hand: ");
            String cont = scanner.nextLine().trim().toLowerCase();
            if (cont.equals("leave")) {
                System.out.println("Thanks for playing! You leave with $" + String.format("%.2f", money));
                break;
            }
            // otherwise loop continues and a new hand is dealt
        }

        scanner.close();

    }
}