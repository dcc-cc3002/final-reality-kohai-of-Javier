package characters

/** Trait for Magical Characters.
 * Magical Characters also have a magic attack.
 * For the other methods, @see WCharacter
 */
trait MagicalCharacter extends WCharacter {
    /** Returns the number of mana points of the character.*/
    def getManaPoints(): Int


    /** The character applies a black spell.
        @param manaCost The cost of applying the spell
    */
    def blackSpell(manaCost: Int): Unit

    /** The character applies a white spell.
        @param manaCost The cost of applying the spell
    */
    def whiteSpell(manaCost: Int): Unit
}
