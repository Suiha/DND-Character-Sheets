public class DiceRoller
{
    public DiceRoller() {}

    /**
     * The following are standard dice rolls that result in a value between 1
     * and its maximum value.
     * @return random number between 1 and its max value
     */
    public int d20() { return (int) (Math.random() * 20) + 1; }
    public int d12() { return (int) (Math.random() * 12) + 1; }
    public int d10() { return (int) (Math.random() * 10) + 1; }
    public int d8()  { return (int) (Math.random() * 8)  + 1; }
    public int d6()  { return (int) (Math.random() * 6)  + 1; }
    public int d4()  { return (int) (Math.random() * 4)  + 1; }

    /**
     * The d100 roll is the only dice roll whose minimum value is 0
     * and maximum value is 1 less than its stated value.
     * @return a random number between 0 and 99
     */
    public int d100() { return (int) (Math.random() * 100); }

    /**
     * d20's have a special property in which they can be rolled
     * at advantage or disadvantage.
     * If the roller has advantage, they roll twice and take the higher number.
     * If the roller has disadvantage, they roll twice and take the lower number.
     * @return
     */
    public int d20adv() { return Math.max(d20(), d20()); }
    public int d20dis() { return Math.min(d20(), d20()); }
}
