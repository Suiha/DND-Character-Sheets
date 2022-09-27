import java.util.*;

/**
 * The SkillProficiencies class keeps track of a character's skill proficiencies
 * and calculates the bonus a character has to a skill roll.
 */
public class SkillProficiencies
{
    CharacterSheet character;
    TreeMap<String, String> skills = new TreeMap<>();

    // The proficiency level of each skill.
    // Not Proficient = 0         Proficient = 1          Expertise = 2
    TreeMap<String, Integer> sp;

    // The bonus the character gets to each skill roll.
    TreeMap<String, Integer> skillBonuses = new TreeMap<>();

    /**
     * Rudimentary way to establish a character's skill proficiencies and skill bonuses.
     * @param c: character sheet these skill proficiencies are associated with
     * @param profs: inputted skill proficiency levels
     * @throws Exception: if given proficiency level is invalid (< 0 or > 2)
     */
    public SkillProficiencies(CharacterSheet c, TreeMap<String, Integer> profs) throws Exception
    {
        character = c;
        sp = new TreeMap<>();
        setSkills(); // Is called here for now, later will be called when application is launched/downloaded

        // Initializes the character's skill proficiency levels
        for (String s : skills.keySet())
        {
            if (profs.get(s) == null)
            {
                setProficiency(s, 0);
            } else {
                setProficiency(s, profs.get(s));
            }
        }

        // Initializes the character's skill bonuses
        for (String s : skills.keySet())
        {
            this.setSkillBonus(s);
        }
    }

    /**
     * Initializes what ability each skill is typically associated with.
     */
    public void setSkills()
    {
        // Strength
        skills.put("Athletics", "STR");

        // Dexterity
        skills.put("Acrobatics", "DEX");
        skills.put("Sleight of Hand", "DEX");
        skills.put("Stealth", "DEX");

        // Intelligence
        skills.put("Arcana", "INT");
        skills.put("History", "INT");
        skills.put("Investigation", "INT");
        skills.put("Nature", "INT");
        skills.put("Religion", "INT");

        // Wisdom
        skills.put("Animal Handling", "WIS");
        skills.put("Insight", "WIS");
        skills.put("Medicine", "WIS");
        skills.put("Perception", "WIS");
        skills.put("Survival", "WIS");

        // Charisma
        skills.put("Deception", "CHA");
        skills.put("Performance", "CHA");
        skills.put("Persuasion", "CHA");
    }

    /**
     * Sets the proficiency level of a certain skill.
     * @param skillName: the skill whose proficiency is being set
     * @param p: the proficiency level of the skill
     * @throws Exception
     */
    public void setProficiency(String skillName, int p) throws Exception
    {
        if (skills.get(skillName) == null) { throw new Exception("Invalid skill proficiency"); }
        if (p < 0 || p > 2) { throw new Exception("Invalid proficiency level"); }

        sp.put(skillName, p);
    }

    /*
    public void setSkillBonuses() throws Exception
    {
        for (String s : skills.keySet())
        {
            this.setSkillBonus(s);
        }
    }*/

    public void setSkillBonus(String skillName) throws Exception
    {
        if (skills.get(skillName) == null) { throw new Exception("Invalid skill proficiency"); }

        int pb = character.proficiencyBonus;
        // Gets the associated ability modifier for the given skill
        String ability = skills.get(skillName);
        int mod = character.getAbilities().getModifiers().get(ability);

        skillBonuses.put(skillName, mod + (pb * sp.get(skillName)));
    }

    @Override
    public String toString()
    {
        String s = character.name + "'s Skill Proficiencies:\n";
        for (String a : skills.keySet().toArray(new String[0]))
        {
            s += "\t" + a + ": " + skillBonuses.get(a) + "\n";
        }
        return s;
    }
}
