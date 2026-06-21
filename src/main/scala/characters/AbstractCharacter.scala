package characters
import weapons.Weapon

/** An abstract class for a Character
 * @param name The name of the character
 * @param healthPoints The number of initial health points of the character
 * @param defense The defense of the character
 * @param weight The weight of the character
 */
abstract class AbstractCharacter(val name: String, var healthPoints: Double, val defense: Double, val weight: Double) extends CharacterTrait {
    var weapon: Option[Weapon] = None
}
