package characters
import weapons.Weapon

/** Class for Magical Character: Black Mage */
class BlackMage(name: String, healthPoints: Int, defense: Int, weight: Int, manaPoints: Int) extends AbstractMagicalCharacter(name, healthPoints, defense, weight, manaPoints) {

    /** Setter of the weapon of the character.*/
    def setWeapon(wp: Weapon): Unit = {
        checkOwner(wp)
        wp.checkBlackMage
        weapon = Some(wp)
    }
}
