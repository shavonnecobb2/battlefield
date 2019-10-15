import java.net.SocketImpl;
import java.util.ArrayList;
import java.util.Scanner;

public class BattleshipBust {
    private GameHelper helper = new GameHelper();
    private ArrayList<SimpleBattleship> battleshipList = new ArrayList<>();
    private int numOfGuesses = 0;

    private void setUpGame() {
        SimpleBattleship ship1 = new SimpleBattleship();
        ship1.setName("Lucille");
        SimpleBattleship ship2 = new SimpleBattleship();
        ship2.setName("Drax");
        SimpleBattleship ship3 = new SimpleBattleship();
        ship3.setName("Lilith");
//        SimpleBattleship ship4 = new SimpleBattleship();
//        ship4.setName("Vincent");
        battleshipList.add(ship1);
        battleshipList.add(ship2);
        battleshipList.add(ship3);
//        battleshipList.add(ship4);

        System.out.println("Your goal is to sink the three Ships.");
        System.out.println("Lucille, Drax, Lilith");
        System.out.println("Try to sink them all in the fewest number of guesses.");

        for (SimpleBattleship lucilleToSet : battleshipList) {
            ArrayList<String> newLocation = helper.placeBattleship(3);
            ship1.setLocationCells(newLocation);
        }
        for (SimpleBattleship draxToSet : battleshipList) {
            ArrayList<String> newLocation = helper.placeBattleship(3);
            ship2.setLocationCells(newLocation);
        }
        for (SimpleBattleship lilithToSet : battleshipList) {
            ArrayList<String> newLocation = helper.placeBattleship(3);
            ship3.setLocationCells(newLocation);
        }
//        for (SimpleBattleship vincentToSet : battleshipList) {
//            ArrayList<String> newLocation = helper.placeBattleship(3);
//            ship4.setLocationCells(newLocation);
//        }

    }

    public void startPlaying() {
        while(!battleshipList.isEmpty()) {
            String userGuess = helper.getUserInput("Enter a guess");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "miss";
        for (int x = 0; x < battleshipList.size(); x++) {
            result = battleshipList.get(x).checkYourself(userGuess);
            if (result.equals("hit")) {
                break;
            }
            if (result.equals("kill")) {
                battleshipList.remove(x);
                break;
            }
        }
        System.out.println(result);
    }

    private void finishGame() {
        System.out.println("All Ships are dead! Your stock is now worthless.");
        if (numOfGuesses <= 18) {
            System.out.println("Blah blach blach");
        } else {
            System.out.println("more blah");
        }
    }

    public static void main(String[] args) {
        BattleshipBust game = new BattleshipBust();
        game.setUpGame();
        game.startPlaying();
    }
}
