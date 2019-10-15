import java.util.ArrayList;

public class SimpleBattleship {
    private ArrayList<String> locationCells;
    private String name;

    public void setLocationCells(ArrayList<String> locationCells) {
        this.locationCells = locationCells;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String checkYourself(String userInput) {
        String result = "miss";
        int index = locationCells.indexOf(userInput);
        if (index >= 0) {
            locationCells.remove(index);
            result = "hit";
            return result;
        }
        if (locationCells.isEmpty()) {
            result = "kill";
            System.out.println("Ouch! You sunk " + name + " : ( ");

        } if (index <= 0) {
            result = "miss";
        }
//        else {
//            result = "hit";
//        }
        return result;
    }
}

