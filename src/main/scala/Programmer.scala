import characters.CharacterTrait
import scala.collection.mutable

/** Trait for the turns programmer, it determines which character plays next.
* @param addCharacter Adds a character to the task programmer
* @param removeCharacter Eliminates a character from the task programmer
* @param maxActionBar Calculates the maximum of the action bar of all characters
* @param restartActionBar Restarts the action bar of each character
* @param augmentActionBar Aguments simultaneously the action bar of all characters by an arbitrary amount
* @param completedActionBar Indicates whether a character completed their action bar
* @param throwCompleteCharacters Delivers all characters who completed their action bar, in non-increasing order
* @param selectCharacter Indicates the only character who plays the turn
* @param charactersAdded Iterable with the list of characters considered by the turns programmer
* @param actionBar The value of the action bar for each character
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
