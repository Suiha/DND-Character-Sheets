package Races;
import java.util.*;

abstract class Race
{
    String name;
    HashMap<String, Integer> abilityScoreIncrease;
    String size;
    int speed;
    boolean darkvision = false;
    ArrayList<String> languages = new ArrayList<>();

    String description() { return "This is the abstract Race class."; }
}
