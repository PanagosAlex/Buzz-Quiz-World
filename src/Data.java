import java.util.ArrayList;
import java.util.Random;

/**
 * @author Panagos Alexandros
 */

public class Data<data> {
    int randomnum;
    Random r1 = new Random();

    // Το [0] είναι η ερώτηση, το [1] είναι η σωστη απάντηση και τα άλλα 3 είναι το φιλερ.

    String[] S1 = {"Who invented the telephone?","Alexander Graham Bell","Edwin Howard Armstrong","Thomas Edison","Antoine Louis"};
    String[] S2 = {"How many colours can you see in a rainbow?","7","8","6","5"};
    String[] S3 = {"The core of the Earth is made of nickel and which other element?","Iron","Gold","Zinc","Uranium"};
    String[] S4 = {"What is the formula for calculating speed?","Distance / Time","Time * Distance","Time + Distance","Time - Distance"};
    String[] S5 = {"When did the first flight take place?","1903","1900","1906","1897"};

    String[] T1 = {"When was Instagram launched?","2010","2011","2009","2008"};
    String[] T2 = {"What does the 'F' stand for in the acronym FORTRAN?","Formula","Fox","Fair","Faith"};
    String[] T3 = {"Who flew the first airplane?","Wright Brothers","Lumiere Brothers","Graham Bell","Thomas Edison"};
    String[] T4 = {"What science fiction writer wrote the three laws of robotics?","Isaac Asimov","Aldous Huxley","Arthur Clarke","Stephen King"};
    String[] T5 = {"Which car company produces the Civic?","Honda","Audi","Skoda","Nissan"};

    String[] Sp1 = {"Which planet is farthest from the sun?","Neptune","Uranus","Mars","Jupiter"};
    String[] Sp2 = {"Phobos is the moon of which planet?","Mars","Earth","Jupiter","Mercury"};
    String[] Sp3 = {"How many stars are in our solar system?","1","100","100000","50"};
    String[] Sp4 = {"In history, who, in 1969, said 'Houston, Tranquility Base here. Eagle has landed.'","Neil Armstrong","John Glen","Eugene Cernan","Buzz Aldrin"};
    String[] Sp5 = {"What was the name of the first U.S. space station?","Skylab","Apollo","Mir","Salyut 2"};

    String[] M1 = {"In Greek mythology, King Midas had the power to turn everything he touched into ...","Gold","Diamond","Bronze","Silver"};
    String[] M2 = {"In Roman mythology, who was the god of fire?","Vulcan","Mercury","Mars","Neptune"};
    String[] M3 = {"In Norse mythology, what was the name of the ultimate battle?","Ragnarok","Fenrir","Asgard","Jotunheimr"};
    String[] M4 = {"In Greek mythology, which of the below did Prometheus steal from the gods and gifted to humans?","The fire","Free will","Immortality","A Titan"};
    String[] M5 = {"Which mythical king led the Knights of the Round Table?","Arthur","Mark","Jack","Martin"};

    /**
     * Η χρησιμότητα των παρακάτω μεθόδων είναι τυχαία να επιστρέφουν μια ερώτηση της επιθυμητής κατηγορίας
     */

    public String[] Science() {
        randomnum = r1.nextInt(5);

        System.out.println("Question type: Science");

        if(randomnum==0)
            return S1;
        if(randomnum==1)
            return S2;
        if(randomnum==2)
            return S3;
        if(randomnum==3)
            return S4;
        return S5;
    }

    public String[] Technology() {
        randomnum = r1.nextInt(5);

        System.out.println("Question type: Technology");

        if(randomnum==0)
            return T1;
        if(randomnum==1)
            return T2;
        if(randomnum==2)
            return T3;
        if(randomnum==3)
            return T4;
        return T5;
    }

    public String[] Space() {
        randomnum = r1.nextInt(5);

        System.out.println("Question type: Space");

        if(randomnum==0)
            return Sp1;
        if(randomnum==1)
            return Sp2;
        if(randomnum==2)
            return Sp3;
        if(randomnum==3)
            return Sp4;
        return Sp5;
    }

    public String[] Mythology() {
        randomnum = r1.nextInt(5);

        System.out.println("Question type: Mythology");

        if(randomnum==0)
            return M1;
        if(randomnum==1)
            return M2;
        if(randomnum==2)
            return M3;
        if(randomnum==3)
            return M4;
        return M5;
    }
}