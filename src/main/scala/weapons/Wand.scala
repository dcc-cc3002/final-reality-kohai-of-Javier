package weapons
import characters.WCharacter
import exceptions.IncompatibleWeaponException

/** Class for Wand magical weapon.
 * @see AbstractMagicWeapon
 */
class Wand(name: String, attackPoints: Int, magicAttack: Int, weight: Int, owner: WCharacter) extends AbstractMagicWeapon(name, attackPoints, magicAttack, weight, owner) {

    /** Checks whether this weapon can be equiped to a Paladin.
     * Otherwise, it throws an IncompatibleWeaponException.*/
     def checkPaladin: Boolean = throw new IncompatibleWeaponException("Wand")

    /** Checks whether this weapon can be equiped to a Warrior.
     * Otherwise, it throws an IncompatibleWeaponException.*/
     def checkWarrior: Boolean = throw new IncompatibleWeaponException("Wand")

    /** Checks whether this weapon can be equiped to a Ninja.
     * Otherwise, it throws an IncompatibleWeaponException.*/
     def checkNinja: Boolean = true

     /** Checks whether this weapon can be equiped to a Black Mage.
     * Otherwise, it throws an IncompatibleWeaponException.*/
     def checkBlackMage: Boolean = true

     /** Checks whether this weapon can be equiped to a White Mage.
     * Otherwise, it throws an IncompatibleWeaponException.*/
     def checkWhiteMage: Boolean = true
}
