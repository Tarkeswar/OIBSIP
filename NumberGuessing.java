package guessno;

import java.util.*;

public class NumberGuessing {
    static ArrayList<Integer> score = new ArrayList<Integer>();

    public static void main(String[] args) {
        NumberGuessing ng = new NumberGuessing();
        ng.menu(score);
    }

    public void menu(ArrayList<Integer> score) {
        NumberGuessing ng = new NumberGuessing();
        Scanner input = new Scanner(System.in);
        System.out.println("--------------------");
        System.out.println("Welcome to the number guessing game\n");
        System.out.println("1) Play the Game");
        System.out.println("2) Display score ");
        System.out.println("3) Exit the game");
        System.out.println("--------------------");
        try {
            System.out.print("What action would you like to do? ");
            int ch = input.nextInt();
            switch (ch) {
                case 1:
                    System.out.print("\nEnter the range of numbers? ");
                    int nr = input.nextInt();
                    int randomno = ng.randomNumber(nr);
                    ng.guessNumber(randomno);
                    break;
                case 2:
                    ng.displayScore();
                    break;
                case 3:
                    System.out.println("\nThank you for playing the game!");
                    System.exit(1);
                    break;
                default:
                    throw new InputMismatchException("Invalid  entry.Please Try again ");
            }
        } catch (InputMismatchException e) {
            System.err.println("\n" + e.getMessage() + "\n");
            menu(score);
        }
    }

   
     public void displayScore() {
        System.out.println("--------------------");
        System.out.println("Score ");
        System.out.println("--------------------");
        System.out.println("Your fastest games today out  are: " + "\n");
        Collections.sort(score);
        for (Integer scores : score) {
            System.out.println("Finished the number game in " + scores + " tries");
        }
        System.out.println(" ");
        menu(score);
    }
  
    public void guessNumber(int nr) {
        Scanner input = new Scanner(System.in);
        int userGuess;
        int guess = 0;
        do {
            System.out.print("Enter your guess number: ");
            userGuess = input.nextInt();
            guess++;
            if (userGuess < nr) {
                System.out.println("Higher\n");
            } else if (userGuess > nr) {
                System.out.println("Lower\n");
            }
        } while (nr != userGuess);
        System.out.println(" ");
        if (guess == 1) {
            System.out.println("You answered number is right in " + guess + " try!");
        } else {
            System.out.println("You answered number is right in " + guess + " tries!");
        }
        score.add(guess);
        System.out.println(" ");

        menu(score);
    }
  
   public int randomNumber(int nr) {
        Random random = new Random();
        int randomno = random.nextInt(nr) + 1;
        return randomno;
    }

   
}
