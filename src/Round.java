import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Giotakos Konstantinos
 * @author Panagos Alexandros
 */

public class Round {
    String answear, rightanswear;
    int bet ;
    ArrayList<String> roundtype;
    ArrayList<String> qtype= new ArrayList<String>(5);
    ArrayList<String> alreadyshown= new ArrayList<String>(4);
    String[] questionOfround= {null,null,null,null,null};
    String showQuestionstring;

    /**
     * Κονστράκτορας
     *
     * @param answear η απάντηση του χρήστη.
     * @param rightanswear η σωστή απάντηση.
     */

    public Round(String answear, String rightanswear) {
        this.answear = answear;
        this.rightanswear = rightanswear;
        this.roundtype = new ArrayList<>();
        this.qtype = new ArrayList<>();
        this.bet = 250;
        // roundType();
    }

    /**
     * Κενος βοηθητικός κονστράκτορας
     */

    public Round(){

    }

    /**
     * Η χρησιμότητα της παρακάτω μεθόδου είναι να εμφανίζει τον τύπο του γύρου τυχαία.
     *
     * @param question η ερώτηση που απαντά ο χρήστης.
     */

    public void roundType(Question question) {
        roundtype.add("Betting");
        roundtype.add("Correct Answer");
        Collections.shuffle(roundtype);
        if (roundtype.get(0) == "Betting" ){
            betting(question);
        }
        else if (roundtype.get(0) == "Correct Answer")
            correctanswer(question);
    }

    /**
     * Η παρακάτω μέθοδος χρησιμοποιείται για να δημιουργηθεί η ερώτηση και οι απαντήσεις που θα εμφανιστούν
     */

    public Question showQuestion(){
        Data d1=new Data();
        showQuestionstring = questionType();

        if (showQuestionstring == "Science") {
            questionOfround = d1.Science();
        } else if (showQuestionstring == "Technology") {
            questionOfround = d1.Technology();
        } else if (showQuestionstring == "Space") {
            questionOfround = d1.Space();
        } else{
            questionOfround = d1.Mythology();
        }

        if (!alreadyshown.contains(questionOfround)){
            Question beta = new Question(questionOfround[0],questionOfround[1],questionOfround[2],questionOfround[3],questionOfround[4]);
            return beta;
        }
        return showQuestion();
    }

    /**
     * Η χρησιμότητα της παρακάτω μεθόδου είναι να παίρνει τη απάντηση απο τον χρήστη και να
     * επιστρέφει τους πόντους απο τον κάθε γύρο.
     *
     * @param q η ερώτηση που απαντά ο χρήστης.
     */

    public int getPoints(Question q) {
        if (roundtype.get(0) == "Betting") {
            if (q.checkAnswernotforprint()) {
                return this.bet;
            }
            else {
                return (-1)*this.bet;
            }
        }
        else
        {
            if (q.checkAnswernotforprint()) {
                return 1000;
            }
            else {
                return 0;
            }
        }
    }

    /**
     * Η παρακάτω μέθοδος χρησιμοποιείται για να ποντάρει ο χρήστης στην περίπτωση που ο τύπος του γύρου είναι betting.
     *
     * @param question η ερώτηση που απαντά ο χρήστης.
     */

    private void betting(Question question) {
        System.out.println("Choose your bet: ");

        // betting
        this.bet = 250;
        for (int i = 1; i < 5; i++){
            System.out.println("(" + i + ") " + this.bet*i );
        }

        Scanner s = new Scanner(System.in);
        int userchoice;
        userchoice = s.nextInt();
        while (userchoice > 4 || userchoice < 1){
            userchoice = s.nextInt();
        }

        this.bet = 250 * userchoice;

        getPoints(question);
    }

    /**
     * Η παρακάτω μέθοδος επιστρέφει τους πόντους απο κάθε γύρο στον χρήστη.
     *
     * @param question η ερώτηση που απαντά ο χρήστης
     */

    private void correctanswer(Question question){
        getPoints(question);
    }

    /**
     * Η παρακάτω μέθοδος χρησιμοποιείται για να γυρίσει την κατηγορία της ερώτησης τυχαία.
     */

    private String questionType() {
        qtype.add("Science");
        qtype.add("Technology");
        qtype.add("Space");
        qtype.add("Mythology");
        Collections.shuffle(qtype);
        return qtype.get(0);
    }

    /**
     * Η παρακάτω μέθοδος χρησιμοποιείται για να εξασφαλίζεται ότι στον ίδιο γύρο δε θα εμφανιστεί η ίδια ερώτηση δυο φορές
     */

    public void endofround(){
        alreadyshown.clear();
    }
}