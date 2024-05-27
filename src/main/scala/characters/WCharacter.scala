package characters
import weapons.Weapon

/** Trait for a Character with Weapon.
* It extends TCharacter. The idea is for enemies not to carry Weapons.
* @see TCharacter
*/
trait WCharacter extends TCharacter {

    /** Getter for the character's weapon.*/
    def getWeapon(): Option[Weapon]

    /** Setter for the character's weapon.*/
    def setWeapon(newWeapon: Weapon): Unit

    /** Unequip the character's weapon.*/
    def unsetWeapon(): Unit
}
