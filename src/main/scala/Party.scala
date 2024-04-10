import scala.collection.mutable.ArrayBuffer
import characters.CharacterTrait

class Party(private var warriors: ArrayBuffer[CharacterTrait] = ArrayBuffer[CharacterTrait]()) extends PartyTrait {

    def addCharacter(newCharacter: CharacterTrait): Unit = {
        warriors += newCharacter
    }
    def isDefeated(): Boolean = warriors.isEmpty
}
