public class Main {

    public static void main(String[] args) {
        //SIZE - amount of tries, can be changed
        int SIZE = 100000;

        //counter - responsible for counting the amount of matching hands
        int counter = 0;

        //main loop
        for (int i = 0; i < SIZE; i++) {
            //initialize of logic and setup of a game
            PokerLogic logic = new PokerLogic();
            logic.gameSetUp();

            //change to logic.checkFlush() if you want to check matching hands considering Flush
            if(logic.checkRoyalFlush()) {
                counter++;

                //prints info only about matching hands
                logic.getInfoAboutHands();
            }
        }

        //prints info about amount of tries and matching hands
        System.out.println("Matching hands: " + counter);
        System.out.println("Tries: " + SIZE);
    }
}