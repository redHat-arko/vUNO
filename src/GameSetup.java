import java.util.*;

public class GameSetup {

    ArrayList<String> al;
    ArrayList<String> takenCardsUser;
    ArrayList<String> takenCardsAUTO;
    String currentChoice;
    String lastChoice;
    int noOfRounds;

    GameSetup() {
        al = new ArrayList();
        takenCardsUser = new ArrayList();
        takenCardsAUTO = new ArrayList();

        currentChoice = "";
        lastChoice = "";

        noOfRounds = 0;

        al.add("Y0");
        al.add("Y1");
        al.add("Y2");
        al.add("Y3");
        al.add("Y4");
        al.add("Y5");
        al.add("Y6");
        al.add("Y7");
        al.add("Y8");
        al.add("Y9");
        al.add("Y1");
        al.add("Y2");
        al.add("Y3");
        al.add("Y4");
        al.add("Y5");
        al.add("Y6");
        al.add("Y7");
        al.add("Y8");
        al.add("Y9");
        al.add("G0");
        al.add("G1");
        al.add("G2");
        al.add("G3");
        al.add("G4");
        al.add("G5");
        al.add("G6");
        al.add("G7");
        al.add("G8");
        al.add("G9");
        al.add("G1");
        al.add("G2");
        al.add("G3");
        al.add("G4");
        al.add("G5");
        al.add("G6");
        al.add("G7");
        al.add("G8");
        al.add("G9");
        al.add("B0");
        al.add("B1");
        al.add("B2");
        al.add("B3");
        al.add("B4");
        al.add("B5");
        al.add("B6");
        al.add("B7");
        al.add("B8");
        al.add("B9");
        al.add("B1");
        al.add("B2");
        al.add("B3");
        al.add("B4");
        al.add("B5");
        al.add("B6");
        al.add("B7");
        al.add("B8");
        al.add("B9");
        al.add("R0");
        al.add("R1");
        al.add("R2");
        al.add("R3");
        al.add("R4");
        al.add("R5");
        al.add("R6");
        al.add("R7");
        al.add("R8");
        al.add("R9");
        al.add("R1");
        al.add("R2");
        al.add("R3");
        al.add("R4");
        al.add("R5");
        al.add("R6");
        al.add("R7");
        al.add("R8");
        al.add("R9");
        al.add("S");
        al.add("S");
        al.add("S");
        al.add("S");
        al.add("S");
        al.add("S");
        al.add("S");
        al.add("S");
        al.add("W");
        al.add("W");
        al.add("W");
        al.add("W");
    }

    public void setCards() {
        int i; int x; int y;

        for (i = 1; i<=7; i++) {
            x = (int) (Math.random() * al.size());
            takenCardsUser.add(al.get(x).toString());
            al.remove(x);

            y = (int) (Math.random() * al.size());
            takenCardsAUTO.add(al.get(y).toString());
            al.remove(y);
        }
    }

    public boolean checkChoice(String s1, String s2) {
        char cU1;
        char cU2;
        char cL1;
        char cL2;
        int l1 = s1.length();
        int l2 = s2.length();

        if (l1==2 && l2==2) {
            cU1 = s1.charAt(0);
            cU2 = s1.charAt(1);
            cL1 = s2.charAt(0);
            cL2 = s2.charAt(1);

            if (cU1==cL1)
                return true;
            else if(cL1=='X' && cL2=='X')
                return true;
            else if (cU2==cL2)
                return true;
            else
                return false;
        }

        else if(l1==1) {
            cU1 = s1.charAt(0);
            if(cU1=='W' || cU1=='S')
                return true;
            else if(cU1=='D')
                return true;
            else
                return false;
        }

        else
            return false;
    }

    public void playUser(String gameID) {
        int n = 1;

        GameSetup ob = new GameSetup();

        n = takenCardsUser.size();
        System.out.print(gameID +  ": ");

        try{
            Thread.sleep(250);
        }
        catch(InterruptedException e) {

        }
        System.out.println(takenCardsUser);

        Scanner sc = new Scanner(System.in);
        currentChoice = sc.nextLine().toUpperCase();

        while(noOfRounds==0) {
            if(currentChoice.equalsIgnoreCase("S")==false)
                lastChoice = currentChoice;
            else
                lastChoice="XX";
            noOfRounds++;

        }
        boolean b;
        if(currentChoice.equalsIgnoreCase("D"))
            b = true;
        else
            b = takenCardsUser.contains(currentChoice);
        boolean b1 = ob.checkChoice(currentChoice, lastChoice);
        if(b==true && b1==true) {
            if(currentChoice.equalsIgnoreCase("W")) {
                System.out.println("WILDCARD PLAYED");

                try {
                    Thread.sleep(250);
                }
                catch (InterruptedException ex) {

                }

                System.out.print("CHOOSE A CARD: ");

                takenCardsUser.remove(currentChoice);
                System.out.print(takenCardsUser);
                System.out.println();
                String tempChoice = sc.nextLine();

                while(takenCardsUser.contains(tempChoice.toUpperCase())==false) {
                    System.out.println("YOUR PREVIOUS CHOICE WAS INVALID; CHOOSE AGAIN");

                    System.out.print("CHOOSE A CARD: ");

                    try {
                        Thread.sleep(250);
                    }
                    catch (InterruptedException ex) {

                    }
                    System.out.print(takenCardsUser);
                    tempChoice = sc.nextLine().toUpperCase();
                }
                currentChoice = tempChoice;

                lastChoice = currentChoice.charAt(0) + "X";
                takenCardsUser.remove(currentChoice);
            }
            else if(currentChoice.equalsIgnoreCase("S")) {
                System.out.println("SKIP CARD PLAYED");

                try {
                    Thread.sleep(250);
                }
                catch (InterruptedException ex) {

                }

                takenCardsUser.remove(currentChoice);
            }
            else if(currentChoice.equalsIgnoreCase("D")) {
                System.out.println("DRAWING CARD...");
                System.out.println();
                int a = (int) (Math.random() * al.size());
                takenCardsUser.add(al.get(a).toString());

                try {
                    Thread.sleep(250);
                }
                catch (InterruptedException ex) {

                }
                System.out.println("YOU HAVE DRAWN: " + al.get(a));

                al.remove(a);
            }
            else {
                lastChoice = currentChoice;
                takenCardsUser.remove(currentChoice);
            }
        }
        else {
            System.out.println("YOUR PREVIOUS CHOICE WAS INVALID; CHOOSE AGAIN");
        }
    }

    public void playComputer(int m) {
        int n = 1;
        GameSetup ob = new GameSetup();
        n = takenCardsAUTO.size();
        int flag = 0, i;

        if(m==0) {
            flag = 0;
            int x = (int) (Math.random()*takenCardsAUTO.size());
            if(ob.checkChoice(takenCardsAUTO.get(x).toString(), lastChoice)) {
                currentChoice = takenCardsAUTO.get(x).toString();
                flag = 1;
            }
        }

        if(m==1) {
            flag = 0;
            while(flag!=1) {
                if(noOfRounds!=0) {
                    for(i=0; i<n; i++) {
                        if(ob.checkChoice(takenCardsAUTO.get(i).toString(), lastChoice)) {
                            currentChoice = takenCardsAUTO.get(i).toString();
                            flag = 1;
                            break;
                        }
                    }
                    if(i>=n) {
                        break;
                    }
                }
                else {
                    int x = (int) (Math.random() * n);
                    currentChoice = takenCardsAUTO.get(x).toString();
                    flag = 1;
                }
            }

        }

        if(flag==1) {
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException ex) {

            }
            System.out.println("COMPUTER: " + currentChoice);

            if(currentChoice.equalsIgnoreCase("W")) {
                System.out.println("WILDCARD PLAYED");
                try {
                    Thread.sleep(250);
                }
                catch (InterruptedException ex) {

                }

                takenCardsAUTO.remove(currentChoice);

                int y = (int) (Math.random() * takenCardsAUTO.size());
                currentChoice = takenCardsAUTO.get(y).toString();
                while(currentChoice.equalsIgnoreCase("W") || currentChoice.equalsIgnoreCase("S")) {
                    y = (int) (Math.random() * takenCardsAUTO.size());
                    currentChoice = takenCardsAUTO.get(y).toString();
                }

                lastChoice = currentChoice.charAt(0) + "X";
                System.out.println("COMPUTER: " + currentChoice);
                try {
                    Thread.sleep(400);
                }
                catch (InterruptedException ex) {

                }

                System.out.println("COLOUR TO MATCH: " + currentChoice.charAt(0));
                try {
                    Thread.sleep(250);
                }
                catch (InterruptedException ex) {

                }

                takenCardsAUTO.remove(currentChoice);
            }
            else if(currentChoice.equalsIgnoreCase("S")) {
                System.out.println("SKIP CARD PLAYED");
                try {
                    Thread.sleep(250);
                }
                catch (InterruptedException ex) {

                }

                takenCardsAUTO.remove(currentChoice);
            }
            else {
                lastChoice = currentChoice;
                takenCardsAUTO.remove(currentChoice);
            }
        }
        else {
            currentChoice = "D";

            try {
                Thread.sleep(250);
            }
            catch(InterruptedException e) {

            }

            System.out.println("COMPUTER: DRAWS CARD");

            int c = (int) (Math.random() * al.size());
            takenCardsAUTO.add(al.get(c).toString());
            al.remove(c);
        }
    }
}