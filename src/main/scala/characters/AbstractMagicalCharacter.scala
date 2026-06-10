package characters
import exceptions.{Require, InvalidStatException}

/** Abstract class for a Magical Character.
 * A magical character also has mana points
 * There are two concrete classes for magical characters: BlackMage and WhiteMage
 * @see AbstractCharacter
 */
abstract class AbstractMagicalCharacter(name: String, healthPoints: Int, defense: Int, weight: Int, private var manaPoints: Int) extends AbstractWCharacter(name, healthPoints, defense, weight) with MagicalCharacter {

    Require.Stat(manaPoints, "manaPoints") atLeast 0

    /** Return the number of mana points of the character.*/
    def getManaPoints(): Int = manaPoints
}
