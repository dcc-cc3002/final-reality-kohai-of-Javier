import scala.collection.mutable.ArrayBuffer
import characters.TCharacter
import exceptions.PartyLimitException

/** Class for a Party.
 * It could be either the player's party or the enemy party
 *
 * @param warriors An array of Characters. If no array is given, then an empty array is created by default
 */
class Party(private var warriors: ArrayBuffer[TCharacter] = ArrayBuffer[TCharacter]()) extends TParty {

    /** Add a new Character to the Party */
    def addCharacter(newCharacter: TCharacter): Unit = {
        if(warriors.knownSize == 3) throw new PartyLimitException(3)
        warriors += newCharacter
    }
    /** Returns true if and only if there are no Characters left in the warriors array */
    def isDefeated(): Boolean = warriors.isEmpty
}
