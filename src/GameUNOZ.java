import java.util.*;

public class GameUNOZ {
    public static void main(String[] args) {
        String str = "vUNO";
        for(int i=0; i<str.length(); i++) {
            try {
                Thread.sleep(250);
            }
            catch (InterruptedException ex) {

            }
            System.out.print(str.charAt(i));
        }
        System.out.println();

        GameSetup ob = new GameSetup();
        for(int i=0; i<4; i++) {
            try {
                Thread.sleep(250);
            }
            catch (InterruptedException ex) {

            }
            System.out.print(".");
        }
        System.out.println();

        Scanner sc = new Scanner(System.in);

        System.out.print("ENTER YOUR GAME ID: ");
        String gameID = sc.next();

        System.out.print("CHOOSE A DIFFICULTY LEVEL (0 or 1): ");
        int m = sc.nextInt();

        int k = (int) (Math.random() * 2);
        if(k==1) {
            System.out.println("THE COMPUTER STARTS THE GAME");
            System.out.println();
        }
        else {
            System.out.println("YOU START THE GAME");
            System.out.println();
        }
        ob.setCards();

        while (true) {
            if(k==0) {
                ob.playUser(gameID);

                if(ob.takenCardsUser.isEmpty()==true) {
                    System.out.println();
                    System.out.println(gameID + " WINS!");
                    try {
                        Thread.sleep(2000);
                    }
                    catch(InterruptedException ex) {

                    }
                    break;
                }
                else if(ob.al.isEmpty()==true)
                    break;
                else if(ob.currentChoice.equalsIgnoreCase("S"))
                    k=0;
                else if(ob.currentChoice.equalsIgnoreCase("D"))
                    k=1;
                else if(ob.checkChoice(ob.currentChoice, ob.lastChoice)==false)
                    k=0;

                else
                    k = 1;
            }
            else if (k==1) {
                ob.playComputer(m);

                if(ob.takenCardsAUTO.isEmpty()==true) {
                    System.out.println();
                    System.out.println("COMPUTER WINS!");
                    try {
                        Thread.sleep(2000);
                    }
                    catch(InterruptedException ex) {

                    }
                    break;
                }
                else if(ob.al.isEmpty()==true)
                    break;
                else if(ob.currentChoice.equalsIgnoreCase("S"))
                    k=1;
                else if(ob.currentChoice.equalsIgnoreCase("D"))
                    k=0;
                else if(ob.checkChoice(ob.currentChoice, ob.lastChoice)==false)
                    k=1;

                else
                    k = 0;
            }

        }

    }
}
