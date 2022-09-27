package Races;
import java.util.*;

public abstract class Race
{
    String name;
    LinkedHashMap<String, Integer> abilityScoreIncrease = new LinkedHashMap<>();
    String size;
    LinkedHashMap<String, Integer> speed = new LinkedHashMap<>();
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

    public LinkedHashMap<String, Integer> getAbilityScoreIncrease() { return abilityScoreIncrease; }
    public String getSize() { return size; }
    public LinkedHashMap<String, Integer> getSpeed() { return speed; }
    public ArrayList<String> getLanguages() { return languages; }

    public abstract String age();

    public abstract String description();
}
