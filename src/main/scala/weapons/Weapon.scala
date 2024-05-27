package weapons
import characters.WCharacter

/** Trait for a Weapon
 *
 * For the implementation of these methods, @see AbstractWeapon
 *
 * Also, there is a checker for each type of character to check if the weapon
 * and the character in question are compatible. See the implementation of
 * each weapon class for more details.
 */
trait Weapon {

    /** Getter for the name of the weapon.*/
    def getName(): String

    /** Getter for the number of attack points of the weapon.*/
    def getAttackPoints(): Int

    /** Getter for the weight of the weapon.*/
    def getWeight(): Int

    /** Getter for the owner of the weapon.*/
    def getOwner(): WCharacter


    /** Checks whether the weapon can be equipped to a Paladin.*/
    def checkPaladin: Boolean

    /** Checks whether the weapon can be equipped to a Warrior.*/
    def checkWarrior: Boolean

    /** Checks whether the weapon can be equipped to a Ninja.*/
    def checkNinja: Boolean

    /** Checks whether the weapon can be equipped to a Black Mage.*/
    def checkBlackMage: Boolean

    /** Checks whether the weapon can be equipped to a White Mage.*/
    def checkWhiteMage: Boolean


    /** Returns true if and only if the Weapon is magical.*/
    def isMagical: Boolean
}
