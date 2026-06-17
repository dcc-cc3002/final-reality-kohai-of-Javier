package programmer

import scala.collection.mutable.{Map, HashMap}
import scala.collection.mutable.ArrayBuffer
import scala.collection.immutable.List
import characters.TCharacter

/** Task programmer class that assigns the character to play in any given moment.*/
class Programmer extends TProgrammer {
    /** HashMap with the characters added to the task programmer.
        The first element stores the current value of the action bar (when a new character is added it starts at 0).
        The second element stores the character itself.
    */
    private val added: Map[TCharacter, Int] = HashMap()

    /** Adds a character to the task programmer.
        @param newCharacter The character to be added
    */
    def addCharacter(newCharacter: TCharacter): Unit = {
        added.addOne(newCharacter -> 0)
    }

    /** Removes a character from the task programmer.
        @param toRemove The character to be removed
    */
    def removeCharacter(toRemove: TCharacter): Unit = {
        added.remove(toRemove)
    }

    /** Calculates the maximum of the action bar from all characters.*/
    def maxActionBar(): Int = {
        var ans: Int = 0
        for((c, v) <- added) {
            val action: Int = v
            if(ans < action) ans = v
        }
        ans
    }

    /** Restarts the action bar of each character
        @param toRestart The character whose action bar must be restarted
    */
    def restartActionBar(toRestart: TCharacter): Unit = {
        added.update(toRestart, 0)
    }

    /** Increases the action bar of all characters by an arbitrary amount k.*/
    def augmentActionBar(k: Int): Unit = {
        for((key, value) <- added) {
            added.addOne((key, value+k))
        }
    }

    /** Indicates whether a character completed their action bar.
        @param myCharacter The character whose action bar we want to know is completed
    */
    def completedActionBar(myCharacter: TCharacter): Boolean = {
        added.apply(myCharacter) >= myCharacter.fullActionBar
    }

    /** Delivers all characters who completed their action bar, in non-increasing order of the difference between the current value of the action bar and the expected value of the action bar.
        The function returns a list with each character who completed their action bar.
    */
    def throwCompleteCharacters(): List[TCharacter] = {
        //buffer contains all the complete characters
        var buffer: ArrayBuffer[(Int, TCharacter)] = ArrayBuffer()
        for((c, v) <- added) {
            if(v >= c.fullActionBar) {
                buffer.addOne((v-c.fullActionBar, c))
            }
        }

        //Sort buffer by the current value in the action bar
        buffer.sortInPlaceWith((A, B) => A._1 > B._1)

        //newBuffer is like buffer but without the values of the action bar
        var newBuffer: ArrayBuffer[TCharacter] = ArrayBuffer()
        for((v, c) <- buffer) {
            newBuffer.addOne(c)
        }
        newBuffer.toList
    }

    /** Indicates the only character who plays the turn.*/
    def selectCharacter(): TCharacter = {
        val allCompleteCharacters: List[TCharacter] = throwCompleteCharacters()
        allCompleteCharacters.head
    }

    /** Returns a list of all characters added to the task programmer, with the current value of their action bar.*/
    def getCharacters(): List[(Int, TCharacter)] = {
        val buffer: ArrayBuffer[(Int, TCharacter)] = ArrayBuffer()
        for((k, v) <- added) {
            buffer.addOne((v, k))
        }
        buffer.toList
    }
}
