package characters
import weapons.Weapon
import exceptions.InvalidUserException

/** Class for Magical Character: White Mage */
class WhiteMage(name: String, healthPoints: Int, defense: Int, weight: Int, manaPoints: Int) extends AbstractMagicalCharacter(name, healthPoints, defense, weight, manaPoints) {

      /** Setter of the weapon of the character.*/
      def setWeapon(wp: Weapon): Unit = {
         checkOwner(wp)
         wp.checkWhiteMage
         weapon = Some(wp)
      }

    /** The character applies a white spell.
        @param manaCost The cost of applying the spell
    */
    def whiteSpell(manaCost: Int) = {
        applySpell(manaCost)
    }

    /** The character tries to apply a black spell, but an InvalidUserException is thrown.*/
    def blackSpell(manaCost: Int) = throw new InvalidUserException("A White Mage can not use a black spell")
}
