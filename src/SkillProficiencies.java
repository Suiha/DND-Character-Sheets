import java.util.*;

public class SkillProficiencies
{
    CharacterSheet character;
    HashMap<String, String> s = new HashMap<>();
    String[] skills = { "Acrobatics", "Animal Handling", "Arcana", "Athletics",
            "Deception", "History", "Insight", "Intimidation",
            "Investigation", "Medicine", "Nature", "Perception",
            "Performance", "Persuasion", "Religion",
            "Sleight of Hand", "Stealth", "Survival" };

    // Not Proficient = 0         Proficient = 1          Expertise = 2
    HashMap<String, Integer> sp;
    HashMap<String, Integer> skillBonuses;

    public SkillProficiencies(CharacterSheet c)
    {
        character = c;
        sp = new HashMap<>();

        // Initially no proficiencies
        for (String s : skills) { sp.put(s, 0); };
    }

    public void setSkills()
    {
        // Strength
        s.put("Athletics", "STR");

        // Dexterity
        s.put("Acrobatics", "DEX");
        s.put("Sleight of Hand", "DEX");
        s.put("Stealth", "DEX");

        // Intelligence
        s.put("Arcana", "INT");
        s.put("History", "INT");
        s.put("Investigation", "INT");
        s.put("Nature", "INT");
        s.put("Religion", "INT");

        // Wisdom
        s.put("Animal Handling", "WIS");
        s.put("Insight", "WIS");
        s.put("Medicine", "WIS");
        s.put("Perception", "WIS");
        s.put("Survival", "WIS");

        // Charisma
        s.put("Deception", "CHA");
    }

    public void setProficiency(String skillName, int p) throws Exception
    {
        if (!Arrays.asList(skills).contains(skillName)) { throw new Exception("Invalid skill proficiency"); }
        if (p < 0 || p > 2) { throw new Exception("Invalid proficiency level"); }

        sp.put(skillName, p);
    }

    public void setSkillBonuses()
    {
        int pb = character.proficiencyBonus;
        HashMap<String, Integer> mods = character.abilities.getModifiers();
        int _str = mods.get("STR");
        int _dex = mods.get("DEX");
        int _int = mods.get("INT");
        int _wis = mods.get("WIS");
        int _cha = mods.get("CHA");

        // Strength
        skillBonuses.put("Athletics", _str + (pb * sp.get("Athletics")) );

        // Dexterity
        skillBonuses.put("Acrobatics", _dex + (pb));
    }
}
