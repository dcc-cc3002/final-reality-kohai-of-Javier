package characters

/** Abstract class for a Magical Character.
 * A magical character also has mana points
 * There are two concrete classes for magical characters: BlackMage and WhiteMage
 * @see AbstractCharacter
 */
abstract class AbstractMagicalCharacter(name: String, healthPoints: Double, defense: Double, weight: Double, var manaPoints: Double) extends AbstractCharacter(name, healthPoints, defense, weight) with MagicalCharacter {

}
