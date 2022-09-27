package Races;

public class Human_Standard extends Race
{
    /**
     * Standard humans lack unique racial features in exchange
     * for getting +1 to every ability score.
     * In addition to Common, they learn an extra language of their choice.
     */
    public Human_Standard()
    {
        super();
        name = "Human";

        // ASI
        abilityScoreIncrease.put("STR", 1);
        abilityScoreIncrease.put("DEX", 1);
        abilityScoreIncrease.put("CON", 1);
        abilityScoreIncrease.put("INT", 1);
        abilityScoreIncrease.put("WIS", 1);
        abilityScoreIncrease.put("CHA", 1);

        size = "Medium";
        speed.put("Walking Speed", 30);

        // Add user choice later; temporary language choice here
        languages.add("Elvish");
    }

    /**
     * Description of a human's typical lifespan and age of maturity
     * @return: human age description
     */
    public String age()
    {
        return "Age. Humans reach adulthood in their late teens and live less than a century.";
    }

    /**
     * Description of humans from the Player's Handbook
     * @return: humans description
     */
    public String description()
    {
        return "In the reckonings of most worlds, humans are the youngest of the common races, " +
                "late to arrive on the world scene and short-lived in comparison to dwarves, elves, " +
                "and dragons. Perhaps it is because of their shorter lives that they strive to achieve " +
                "as much as they can in the years they are given. Or maybe they feel they have " +
                "something to prove to the elder races, and that's why they build their mighty " +
                "empires on the foundation of conquest and trade. Whatever drives them, humans " +
                "are the innovators, the achievers, and the pioneers of the worlds.";
    }
}
