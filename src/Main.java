import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Giotakos Konstantinos
 * @author Panagos Alexandros
 *
 * Η παρακάτω κλάση συνεργάζεται με τις κλασεις (Data, Round & Question) και παράγει μέσω μιας επανάληψης μια σειρά ερωτήσεων.
 *
 * Μεταβλητή: points - πόντοι του παίχτη
 * Μεταβλητή: numberofrounds - σταθερά για τον αριθμό των γύρων
 * Μεταβλητή: numberofturns - σταθερά για τον αριθμό των ερωτήσεων ανα γύρο
 */

public class Main {
    public static void main(String[] args) {
        final int numberofrounds = 2;
        final int numberofquestions = 5;

        int points = 0;
        ArrayList<Question> questions;

        System.out.println("Enter Username:");

        Scanner username = new Scanner(System.in);
        String name = username.nextLine();
        System.out.println("Hi," + name + " and welcome to Buzz!\n");

    for(int i = 0; i < numberofrounds; i++){
        System.out.println("Round "+(i+1)+" starts now!");
        Round round = new Round();
        for (int j = 0; j < numberofquestions; j++) {
            Question questionofround = new Question(null, null, null, null, null);


            questionofround = round.showQuestion();

            questionofround.showQuestion();
            questionofround.playersAnswer();

            Round round2 = new Round(questionofround.getAnswer(), questionofround.getRightAnswer());
            round2.roundType(questionofround);

            points += round2.getPoints(questionofround);
            }
        round.endofround();
        System.out.println("You manages to acquire:" + points + " points\nWell Done!\n");
        }
        System.out.println("Congratulations on finishing the game! See you soon!");
    }
}
