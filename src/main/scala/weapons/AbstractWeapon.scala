package weapons
import characters.WCharacter
import exceptions.{Require, InvalidStatException}

/** Abstract class for a weapon.
 *
 * @param name The name of the weapon. It cannot be empty
 * @param attackPoints number of attack points of the weapon.
 * @param weight The weight of the weapon.
 * @param owner A Character that owns the weapon
 */
abstract class AbstractWeapon(private val name: String, private val attackPoints: Int, private val weight: Int, private var owner: WCharacter) extends Weapon {

    if(name.isEmpty) throw new InvalidStatException("Name cannot be an empty string")
    Require.Stat(attackPoints, "attackPoints") atLeast 1
    Require.Stat(weight, "weight") atLeast 1

    /** Return the name of the weapon.*/
    def getName(): String = name

    /** Return the number of attack points of the weapon.*/
    def getAttackPoints(): Int = attackPoints

    /** Return the weight of the weapon.*/
    def getWeight(): Int = weight

    /** Getter for the owner of the weapon.*/
    def getOwner(): WCharacter = owner

}

