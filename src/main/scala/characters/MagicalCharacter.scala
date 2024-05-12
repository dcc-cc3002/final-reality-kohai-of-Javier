package characters

/** Trait for Magical Characters.
 * @param getManaPoints Returns the number of mana points of the character
 * For the other parameters, @see WCharacter
 */
trait MagicalCharacter extends WCharacter {
    def getManaPoints(): Int
}
