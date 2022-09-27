import Races.*;
import java.util.*;

public class CharacterSheet
{
    DiceRoller roll = new DiceRoller();

    String name;
    Race race;
    String size;

    int speed;

    int level;
    int proficiencyBonus;
    // HashMap<Class, Integer> classes;
    AbilityScores abilities;
    SkillProficiencies skills;

    // Proficiencies
    ArrayList<String> languages = new ArrayList<>();

    public CharacterSheet(String name)
    {
        this.name = name;
        level = 1;
        proficiencyBonus = 2;
    }

    public CharacterSheet(String name, int lvl) throws Exception
    {
        this.name = name;
        this.setLevel(lvl);
    }

    public void setLevel(int lvl) throws Exception
    {
        if (lvl < 1 || lvl > 20) throw new Exception("Invalid level");
        level = lvl;
        setProficiencyBonus();
    }

    public void setProficiencyBonus()
    {
        if (level % 4 != 0) proficiencyBonus = (level / 4) + 2;
        else { proficiencyBonus = (level / 4) + 1; }
    }

    public void setRace(Race r)
    {
        race = r;

        // The character's ability scores are updated based on their
        // race's ASI
        HashMap<String, Integer> current = abilities.getScores();
        HashMap<String, Integer> asi = race.getAbilityScoreIncrease();
        for (String s : race.getAbilityScoreIncrease().keySet())
        {
            abilities.setScore(s, current.get(s) + asi.get(s));
        }
    }
    public Race getRace() { return race; }

    public void setAbilities(AbilityScores a) { abilities = a; }
    public AbilityScores getAbilities() { return abilities; }

    public void setSkills(SkillProficiencies s) { skills = s; }
    public SkillProficiencies getSkills() { return skills; }

    @Override
    public String toString()
    {
        return name + "'s Character Sheet";
    }
}
