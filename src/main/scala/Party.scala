import scala.collection.mutable.ArrayBuffer
import characters.CharacterTrait

/** Class for a Party
 * It could be either the player's party or the enemy party
 *
 * @param warriors An array of Characters. If no array is given, then an empty array is created by default
 */
class Party(private var warriors: ArrayBuffer[CharacterTrait] = ArrayBuffer[CharacterTrait]()) extends PartyTrait {

    /** Add a new Character to the Party */
    def addCharacter(newCharacter: CharacterTrait): Unit = {
        warriors += newCharacter
    }
    /** Returns true if and only if there are no Characters left in the warriors array */
    def isDefeated(): Boolean = warriors.isEmpty
}
