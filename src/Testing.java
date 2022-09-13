public class Testing
{
    public static void main(String[] args)
    {
        // Dice Rolling
        DiceRoller d = new DiceRoller();
        System.out.println( d.d20() );

        // Ability Scores
        CharacterSheet adrian = new CharacterSheet("Adrian");
        AbilityScores as = new AbilityScores(adrian, 8, 14, 14, 12, 18, 11);
        System.out.println(as);
    }
}
