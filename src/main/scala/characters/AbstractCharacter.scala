package characters
import exceptions.{Require, InvalidStatException}

/** Abstract class for a generic character.
 * @param name The name of the character. It must be non-empty
 * @param healthPoints Initial HP of the character. It must be greater than 0
 * @param defense Number of defense points of the character. It must be greater than 0
 * @param weight Weight of the character. It must be greater than 0
 */
abstract class AbstractCharacter(private val name: String, private var healthPoints: Int, private val defense: Int, private val weight: Int) extends TCharacter {

    if(name.isEmpty) throw new InvalidStatException("The name of the character cannot be empty.")
    Require.Stat(healthPoints, "healthPoints") atLeast 1
    Require.Stat(defense, "defense") atLeast 0
    Require.Stat(weight, "weight") atLeast 1

    /** Returns the number of current health points.*/
    def getHealthPoints(): Int = healthPoints

    /** Returns the name of the character.*/
    def getName(): String = name

    /** Returns the number of defense points of the character.*/
    def getDefense(): Int = defense

    /** Returns the weight of the character.*/
    def getWeight(): Int = weight

    /** Function that is called when the character is attacked by another.*/
    def receiveDamage(attackPoints: Int): Unit = {
        if(attackPoints > defense) healthPoints -= attackPoints - defense
        if(healthPoints < 0) healthPoints = 0
    }
}
