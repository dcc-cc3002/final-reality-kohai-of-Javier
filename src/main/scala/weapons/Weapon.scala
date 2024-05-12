package weapons
import characters.WCharacter

/** Trait for Weapons
 * @param getName Returns the name of the weapon
 * @param getAttackPoints Returns the number of attack points of the weapon
 * @param getWeight Returns the weight of the weapon
 * @param getOwner Getter for the character who owns the weapon
 * For the implementation of these methods, @see AbstractWeapon
 */
trait Weapon {
    def getName(): String
    def getAttackPoints(): Int
    def getWeight(): Int
    def getOwner(): WCharacter
}
