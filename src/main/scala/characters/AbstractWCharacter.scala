package characters
import weapons.Weapon

/** An abstract class for a Character with a weapon
 * @param name The name of the character
 * @param healthPoints The number of initial health points of the character
 * @param defense The defense of the character
 * @param weight The weight of the character
 */
abstract class AbstractWCharacter(name: String, healthPoints: Int, defense: Int, weight: Int) extends AbstractCharacter(name, healthPoints, defense, weight) with WCharacter {
    protected var weapon: Option[Weapon] = None

    /** Returns an Option with the current weapon the character carries.*/
    def getWeapon(): Option[Weapon] = weapon

    /** Returns the expected value of the character's action bar.*/
    def fullActionBar() = {
        if(weapon.isDefined)
            weight + weapon.get.getWeight/2
        else
            weight
    }

    /** Perform an attack on other character.
        In this case, the attacker character must have a weapon equiped.
        Otherwise, an exception is thrown.
        @param other The character to be attacked
    */
    def attack(other: TCharacter): Unit = {
        if(weapon.isDefined) {
            other.receiveDamage(weapon.get.getAttackPoints)
        }
        else {
            throw new Exception("No weapon carried by the attacker character")
        }
    }
}
