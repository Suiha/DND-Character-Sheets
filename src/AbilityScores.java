import java.util.*;

public class AbilityScores
{
    CharacterSheet character;
    private HashMap<String, Integer> scores;
    private HashMap<String, Integer> modifiers;

    /**
     * Upon creating a character, input their ability scores.
     * The scores will be set using the helper function setScores,
     * and the modifiers will be set using setModifiers
     * @param c: the character sheet this set of ability scores is associated with
     * @param _str: the player character's total strength
     * @param _dex: the player character's total dexterity
     * @param _con: the player character's total constitution
     * @param _int: the player character's total intelligence
     * @param _wis: the player character's total wisdom
     * @param _cha: the player character's total charisma
     */
    public AbilityScores(CharacterSheet c, int _str, int _dex, int _con, int _int, int _wis, int _cha)
    {
        character = c;
        scores = new HashMap<>();
        modifiers = new HashMap<>();

        this.setScores(_str, _dex, _con, _int, _wis, _cha);
    }

    /**
     * A function for setting the total ability scores of a character.
     * This is separate from the constructor in case a player wants to
     * override all their character's ability scores at once.
     */
    public void setScores(int _str, int _dex, int _con, int _int, int _wis, int _cha)
    {
        scores.put("STR", _str);
        scores.put("DEX", _dex);
        scores.put("CON", _con);
        scores.put("INT", _int);
        scores.put("WIS", _wis);
        scores.put("CHA", _cha);

        // Whenever ability scores are changed, their modifiers must be updated
        this.setModifiers();
    }

    /**
     * A function for setting the total score of one ability.
     * The associated modifier will also be updated.
     * @param ability: the ability whose score is being set
     * @param s: the value for the score
     */
    public void setScore(String ability, int s)
    {
        scores.put(ability, s);
        modifiers.put(ability, toModifier(s));
    }

    /**
     * A helper function to set all the modifiers of a character at once.
     * Set as private, since modifiers can only be changed when scores change.
     */
    private void setModifiers()
    {
        modifiers.put("STR", toModifier("STR") );
        modifiers.put("DEX", toModifier("DEX") );
        modifiers.put("CON", toModifier("CON") );
        modifiers.put("INT", toModifier("INT") );
        modifiers.put("WIS", toModifier("WIS") );
        modifiers.put("CHA", toModifier("CHA") );
    }

    /**
     * Getters for scores & modifiers
     * @return: map of scores or modifiers
     */
    public HashMap<String, Integer> getScores() { return scores; }
    public HashMap<String, Integer> getModifiers() { return modifiers; }


    /**
     * Convert a given ability score to its modifier (based on number or ability).
     * @param score: the score of the ability
     * @return the score's modifier
     */
    public int toModifier(int score) { return (int) (score - 10) / 2; }
    public int toModifier(String ability) { return toModifier(scores.get(ability)); }

    @Override
    public String toString()
    {
        String s = character.name + "'s Ability Scores:\n";
        s += "\t STR: " + scores.get("STR") + " (" + modifiers.get("STR") + ")\n";
        s += "\t DEX: " + scores.get("DEX") + " (" + modifiers.get("DEX") + ")\n";
        s += "\t CON: " + scores.get("CON") + " (" + modifiers.get("CON") + ")\n";
        s += "\t INT: " + scores.get("INT") + " (" + modifiers.get("INT") + ")\n";
        s += "\t WIS: " + scores.get("WIS") + " (" + modifiers.get("WIS") + ")\n";
        s += "\t CHA: " + scores.get("CHA") + " (" + modifiers.get("CHA") + ")\n";
        return s;
    }
}
