import characters.TCharacter
import scala.collection.mutable
import scala.collection.immutable.List

/** Trait for the turns programmer, it determines which character plays next.
* @param addCharacter Adds a character to the task programmer
* @param removeCharacter Eliminates a character from the task programmer
* @param maxActionBar Calculates the maximum of the action bar from all characters
* @param restartActionBar Restarts the action bar of each character
* @param augmentActionBar Aguments simultaneously the action bar of all characters by an arbitrary amount
* @param completedActionBar Indicates whether a character completed their action bar
* @param throwCompleteCharacters Delivers all characters who completed their action bar, in non-increasing order
* @param selectCharacter Indicates the only character who plays the turn
* @param getCharacters Returns a list of all characters added to the task programmer, with the current value of their action bar.
*
* @see Assigner
*/
trait Programmer {
    def addCharacter(newCharacter: TCharacter): Unit
    def removeCharacter(toRemove: TCharacter): Unit
    def maxActionBar(): Int
    def restartActionBar(toRestart: TCharacter): Unit
    def augmentActionBar(howMuch: Int): Unit
    def completedActionBar(myCharacter: TCharacter): Boolean
    def throwCompleteCharacters(): List[TCharacter]
    def selectCharacter(): TCharacter

    def getCharacters(): List[(Int, TCharacter)]
}
