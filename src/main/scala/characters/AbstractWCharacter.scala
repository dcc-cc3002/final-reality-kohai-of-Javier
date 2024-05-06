package characters
import weapons.Weapon

/** An abstract class for a Character with a weapon
 * @param name The name of the character
 * @param healthPoints The number of initial health points of the character
 * @param defense The defense of the character
 * @param weight The weight of the character
 */
abstract class AbstractWCharacter(val name: String, var healthPoints: Double, val defense: Double, val weight: Double) extends WCharacter {
    private var weapon: Option[Weapon] = None

    /** Returns the expected value of the character's action bar.*/
    def fullActionBar() = {
        if(weapon.isDefined)
            weight + 0.5*weapon.get.weight
        else
            weight
    }

    /** Returns the number of health points.*/
    def getHealthPoints(): Double = healthPoints

    /** Returns an Option with the current weapon the character carries, or none if it doesn't carry any.*/
    def getWeapon(): Option[Weapon] = weapon

    /** Setter of the weapon of the character.*/
    def setWeapon(newWeapon: Weapon): Unit = {
        weapon = Some(newWeapon)
    }
}
