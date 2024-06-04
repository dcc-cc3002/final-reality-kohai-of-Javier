package characters.magicalcharacters

import characters._
import weapons.magicweapons.MagicWeapon

/** Trait for Magical Characters.
 * Magical Characters also have a magic attack.
 * For the other methods, @see WCharacter
 */
trait MagicalCharacter extends WCharacter {
    /** Returns the number of mana points of the character.*/
    def getManaPoints(): Int

    /** Getter for the character's magic weapon.
     * It returns None if it hasn't any.*/
    def getMagicWeapon: Option[MagicWeapon]


    /** The character applies a black spell.
        @param manaCost The cost of applying the spell
    */
    def blackSpell(manaCost: Int): Unit

    /** The character applies a white spell.
        @param manaCost The cost of applying the spell
    */
    def whiteSpell(manaCost: Int): Unit
}
