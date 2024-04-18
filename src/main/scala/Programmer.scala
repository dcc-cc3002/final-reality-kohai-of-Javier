import characters.CharacterTrait
import scala.collection.mutable

/** Trait for the turns programmer, it determines which character plays next.
*
*/
trait Programmer {
    def addCharacter(newCharacter: CharacterTrait): Unit
    def removeCharacter(toRemove: CharacterTrait): Unit
    def maxActionBar(): Double
    def restartActionBar(toRestart: CharacterTrait): Unit
    def augmentActionBar(howMuch: Double): Unit
    def completedActionBar(myCharacter: CharacterTrait): Unit
    def throwCompleteCharacters(): mutable.Iterable[CharacterTrait]
    def selectCharacter(): CharacterTrait
    var charactersAdded: mutable.Iterable[Double]
    var actionBar: mutable.Iterable[Double]
}
