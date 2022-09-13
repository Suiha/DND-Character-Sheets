import java.util.ArrayList;

public class CharacterSheet
{
    DiceRoller roll = new DiceRoller();
    String name;
    // Race race;
    AbilityScores abilities;
    int level;
    int proficiencyBonus;
    int speed;
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

    @Override
    public String toString()
    {
        return name + "'s Character Sheet";
    }
}
