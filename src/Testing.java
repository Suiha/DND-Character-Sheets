import Races.Human_Standard;

import java.util.*;

public class Testing
{
    public static void main(String[] args) throws Exception
    {
        // Dice Rolling
        DiceRoller d = new DiceRoller();
        System.out.println("1d20: " + d.d20() );

        testAdrian();

    }

    public static void testAdrian() throws Exception
    {
        // Character
        CharacterSheet adrian = new CharacterSheet("Adrian", 6);

        // Ability Scores (affected by race asi)
        AbilityScores as = new AbilityScores(adrian, 8, 14, 14, 12, 18, 11);
        adrian.setAbilities(as);
        adrian.setRace(new Human_Standard());
        System.out.println(as);

        // SKill Proficiencies
        TreeMap<String, Integer> sp = new TreeMap<>();
        sp.put("Insight", 1);
        sp.put("Medicine", 1);
        sp.put("Sleight of Hand", 1);
        sp.put("Stealth", 1);
        SkillProficiencies profs = new SkillProficiencies(adrian, sp);
        adrian.setSkills(profs);
        System.out.println(profs);

        // Speed and Languages
        adrian.printSpeed();
        adrian.printLanguages();
    }
}
