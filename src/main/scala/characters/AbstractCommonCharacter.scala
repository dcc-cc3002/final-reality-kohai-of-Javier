package characters

/** Abstract class for a Common Character.
 * Concrete classes for Common Characters are Paladin, Ninja and Warrior
 * @param name The name of the character
 * @param healthPoints The number of initial health points of the character
 * @param defense The defense of the character
 * @param weight The weight of the character
 */
abstract class CommonCharacter(name: String, healthPoints: Int, defense: Int, weight: Int) extends AbstractWCharacter(name, healthPoints, defense, weight) {

}
