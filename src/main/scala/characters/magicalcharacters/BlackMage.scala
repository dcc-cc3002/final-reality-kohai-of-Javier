package characters.magicalcharacters

import characters._
import weapons.{Weapon}
import weapons.magicweapons.MagicWeapon
import exceptions.InvalidUserException

/** Class for Magical Character: Black Mage */
class BlackMage(name: String, healthPoints: Int, defense: Int, weight: Int, manaPoints: Int) extends AbstractMagicalCharacter(name, healthPoints, defense, weight, manaPoints) {

    /** Setter of the weapon of the character.*/
    def setWeapon(wp: Weapon): Unit = {
        checkOwner(wp)
        wp.checkBlackMage
        weapon = Some(wp)
    }

    /** The character applies a black spell.
        @param manaCost The cost of applying the spell
    */
    def blackSpell(manaCost: Int) = {
        applySpell(manaCost)
    }

    /** The character tries to apply a white spell, but an InvalidUserException is thrown.*/
    def whiteSpell(manaCost: Int) = throw new InvalidUserException("A Black Mage can not use a white spell")
}
