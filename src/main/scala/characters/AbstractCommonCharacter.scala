package characters

/** Abstract class for a Common Character.
 * Concrete classes for Common Characters are Paladin, Ninja and Warrior
 * @see AbstractCharacter
 */
abstract class CommonCharacter(name: String, healthPoints: Double, defense: Double, weight: Double) extends AbstractCharacter(name, healthPoints, defense, weight) {

}
