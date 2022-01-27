import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Giotakos Konstantinos
 */

public class Question {
    String anoun, answer, rightanswer;
    String filler1, filler2, filler3;
    String questiontype;
    ArrayList<String> choices;

    /**
     * Κονστρακτορας
     *
     * @param anoun η εκφώνηση της ερώτησης.
     * @param rightanswer η σωστή απάντηση της ερώτησης.
     * @param filler1 μια απο τις λάθος απαντήσης.
     * @param filler2 μια απο τις λάθος απαντήσης.
     * @param filler3 μια απο τις λάθος απαντήσης.
     */

    public Question(String anoun, String rightanswer, String filler1, String filler2, String filler3) {
        this.anoun = anoun;
        this.rightanswer = rightanswer;
        this.choices = new ArrayList<>();

        choices.add(filler1);
        choices.add(filler2);
        choices.add(filler3);

        choices.add(rightanswer);
    }

    /**
     * Η χρησιμότητα της παρακάτω μεθόδου είναι να επιστρέφει τον τύπο της ερώτησης.
     */

    public String getQuestionType(){
        return this.questiontype;
    }

    /**
     * Η παρακάτω μέθοδος επιστρέφει την σωστή απάντηση.
     */

    public String getRightAnswer(){
        return this.rightanswer;
    }

    /**
     * Η παρακάτω μέθοδος επιστρέφει την απάντηση του χρήστη.
     */

    public String getAnswer(){
        return this.answer;
    }

    /**
     * Η παρακάτω μέθοδος εμφανίζει την ερώτηση και τις επιλογές (με τυχαία σειρά).
     */

    public void showQuestion(){
        Collections.shuffle(choices); //ανακάτεμα επιλογών+
        // System.out.println("Question Type:" + questiontype);
        System.out.println("Question: " + anoun + "\n" );

        int i = 1;
        for (String s : choices){
            System.out.println("(" + i + ") " + s);
            i++;
        }
    }

    /**
     * Η χρησιμότητα της παρακάτω μεθόδου είναι να επιστρέφει μήνυμα στο χρήστη ανάλογα με τη απάντηση που έδωσε
     */

    public boolean checkAnswer(){
        if(this.answer == this.rightanswer)
            return true;
        else{
            System.out.println("Your answer was wrong!\nThe right answer is " + this.rightanswer);
            return false;
        }
    }

    public boolean checkAnswernotforprint(){
        if(this.answer == this.rightanswer)
            return true;
        return false;
    }

    /**
     * Η χρησιμότητα της παρακάτω μεθόδου είναι να παίρνει την απάντηση απο τον χρήστη και να την αποθηκεύει
     */

    public void playersAnswer(){
        System.out.println("Pick the number that corresponds to the right answer: ");
        Scanner s = new Scanner(System.in);
        int userchoice;
        userchoice = s.nextInt();//ανάγνωση απάντησης χρήστη

        while (userchoice > 4 && userchoice < 1){
            userchoice = s.nextInt();
        }

        this.answer = choices.get(userchoice-1); // Εδώ βάζω την τιμη απο το κελί userchoice - 1 μεσα στο answer για να γινει σωστα ο έλεγχος στη μέθοδο checkAnswer.
    }
}