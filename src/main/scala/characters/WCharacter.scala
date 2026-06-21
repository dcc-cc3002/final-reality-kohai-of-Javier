package characters
import weapons.Weapon

/** Trait for a Character with Weapon.
* It extends TCharacter. The idea is for enemies not to carry Weapons.
* @see TCharacter
* @param getWeapon Getter for the current weapon carried by the character
*/
trait WCharacter extends TCharacter {
    def getWeapon(): Option[Weapon]
    def setWeapon(newWeapon: Weapon): Unit
}
