package programmer

import characters.TCharacter
import scala.collection.mutable
import scala.collection.immutable.List

/** Trait for the turns programmer, it determines which character plays next.
 *
 * For the implementation, @see Programmer
 */
trait TProgrammer {

    /** Adds a character to the task programmer.*/
    def addCharacter(newCharacter: TCharacter): Unit

    /** Eliminates a character from the task programmer.*/
    def removeCharacter(toRemove: TCharacter): Unit

    /** Calculates the maximum of the action bar from all characters.*/
    def maxActionBar(): Int

    /** Restarts the action bar of each character.*/
    def restartActionBar(toRestart: TCharacter): Unit

    /** Aguments simultaneously the action bar of all characters by an arbitrary amount.*/
    def augmentActionBar(howMuch: Int): Unit

    /** Indicates whether a character completed their action bar.*/
    def completedActionBar(myCharacter: TCharacter): Boolean

    /** Delivers all characters who completed their action bar, in non-increasing order.*/
    def throwCompleteCharacters(): List[TCharacter]

    /** Indicates the only character who plays the turn.*/
    def selectCharacter(): TCharacter

    /** Returns a list of all characters added to the task programmer, with the current value of their action bar.*/
    def getCharacters(): List[(Int, TCharacter)]
}
