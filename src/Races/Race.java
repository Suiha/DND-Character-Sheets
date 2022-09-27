package Races;
import java.util.*;

public abstract class Race
{
    String name;
    HashMap<String, Integer> abilityScoreIncrease = new HashMap<>();
    String size;
    int speed;
    boolean darkvision = false;
    ArrayList<String> languages = new ArrayList<>();

    /**
     * Almost every race knows Common by default, so
     * it's added here in the abstract class.
     */
    public Race()
    {
        languages.add("Common");
    }

    public HashMap<String, Integer> getAbilityScoreIncrease() { return abilityScoreIncrease; }

    public abstract String age();

    public abstract String description();
}
