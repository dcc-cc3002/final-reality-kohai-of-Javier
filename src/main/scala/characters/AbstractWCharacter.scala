package characters
import weapons.Weapon
import exceptions.{DoubleEquipmentException, SameTypeException}

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

    /** Unequip the current weapon.
        If the character has no weapon, then this function has no effect.
    */
    def unsetWeapon(): Unit = {
        weapon = None
    }

    /** Returns the expected value of the character's action bar.*/
    def fullActionBar() = {
        if(weapon.isDefined)
            weight + weapon.get.getWeight/2
        else
            weight
    }

    /** Tries to receive damage from another playable character, but it throws an exception.*/
    def receiveDamagePlayer(attackPoints: Int): Unit = throw new SameTypeException("")

    /** Receives damage from an enemy.*/
    def receiveDamageEnemy(attackPoints: Int): Unit = receiveDamage(attackPoints)

    /** Perform an attack on other character.
        In this case, the attacker character must have a weapon equiped.
        Otherwise, an exception is thrown.
        @param other The character to be attacked
    */
    def attack(other: TCharacter): Unit = {
        if(weapon.isDefined) {
            other.receiveDamagePlayer(weapon.get.getAttackPoints)
        }
        else {
            throw new Exception("No weapon carried by the attacker character")
        }
    }

    /** Throws a DoubleEquipmentException if the weapon has another owner.*/
    protected def checkOwner(wp: Weapon): Unit = {
        if(wp.getOwner != this) throw new DoubleEquipmentException(wp.getName, wp.getOwner.getName, name)
    }
}
