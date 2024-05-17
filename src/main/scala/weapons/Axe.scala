package weapons
import characters.WCharacter
import exceptions.IncompatibleWeaponException

/** Class for Axe ordinary weapon.
 * @see AbstractWeapon
 */
class Axe(name: String, attackPoints: Int, weight: Int, owner: WCharacter) extends AbstractWeapon(name, attackPoints, weight, owner) {

    /** Checks whether this weapon can be equiped to a Paladin.
     * Otherwise, it throws an IncompatibleWeaponException.*/
     def checkPaladin: Boolean = true

    /** Checks whether this weapon can be equiped to a Warrior.
     * Otherwise, it throws an IncompatibleWeaponException.*/
     def checkWarrior: Boolean = true

    /** Checks whether this weapon can be equiped to a Ninja.
     * Otherwise, it throws an IncompatibleWeaponException.*/
     def checkNinja: Boolean = throw new IncompatibleWeaponException("Axe")

     /** Checks whether this weapon can be equiped to a Black Mage.
     * Otherwise, it throws an IncompatibleWeaponException.*/
     def checkBlackMage: Boolean = throw new IncompatibleWeaponException("Axe")

     /** Checks whether this weapon can be equiped to a White Mage.
     * Otherwise, it throws an IncompatibleWeaponException.*/
     def checkWhiteMage: Boolean = throw new IncompatibleWeaponException("Axe")
}
