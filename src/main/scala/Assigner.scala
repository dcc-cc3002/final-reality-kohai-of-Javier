import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer
import scala.collection.immutable.List
import characters.CharacterTrait

/** Task programmer class that assigns the character to play in any given moment.*/
class Assigner extends Programmer {
    /** HashMap with the characters added to the task programmer.
        The first element stores the current value of the action bar (when a new character is added it starts at 0).
        The second element stores the character itself.
    */
    private var added: HashMap[CharacterTrait, Double] = HashMap()

    /** Adds a character to the task programmer.
        @param newCharacter The character to be added
    */
    def addCharacter(newCharacter: CharacterTrait): Unit = {
        added.addOne(newCharacter -> 0.0)
    }

    /** Removes a character from the task programmer.
        @param toRemove The character to be removed
    */
    def removeCharacter(toRemove: CharacterTrait): Unit = {
        added.remove(toRemove)
    }

    /** Calculates the maximum of the action bar from all characters.*/
    def maxActionBar(): Double = {
        var ans: Double = 0
        for((c, v) <- added) {
            val action: Double = v
            if(ans < action) ans = v
        }
        ans
    }

    /** Restarts the action bar of each character
        @param toRestart The character whose action bar must be restarted
    */
    def restartActionBar(toRestart: CharacterTrait): Unit = {
        added.update(toRestart, 0.0)
    }

    /** Increases the action bar of all characters by an arbitrary amount k.*/
    def augmentActionBar(k: Double): Unit = {
        for((key, value) <- added) {
            added.addOne((key, value+k))
        }
    }

    /** Indicates whether a character completed their action bar.
        @param myCharacter The character whose action bar we want to know is completed
    */
    def completedActionBar(myCharacter: CharacterTrait): Boolean = {
        added.apply(myCharacter) >= myCharacter.maxActionBar()
    }

    /** Delivers all characters who completed their action bar, in non-increasing order of the difference between the current value of the action bar and the expected value of the action bar.
        The function returns a list with each character who completed their action bar.
    */
    def throwCompleteCharacters(): List[CharacterTrait] = {
        //buffer contains all the complete characters
        var buffer: ArrayBuffer[(Double, CharacterTrait)] = ArrayBuffer()
        for((c, v) <- added) {
            if(v >= c.maxActionBar()) {
                buffer.addOne((v-c.maxActionBar(), c))
            }
        }

        //Sort buffer by the current value in the action bar
        buffer.sortInPlaceWith((A, B) => A._1 > B._1)

        //newBuffer is like buffer but without the values of the action bar
        var newBuffer: ArrayBuffer[CharacterTrait] = ArrayBuffer()
        for((v, c) <- buffer) {
            newBuffer.addOne(c)
        }
        newBuffer.toList
    }

    /** Indicates the only character who plays the turn.*/
    def selectCharacter(): CharacterTrait = {
        val allCompleteCharacters: List[CharacterTrait] = throwCompleteCharacters()
        allCompleteCharacters.head
    }

    /** Returns a list of all characters added to the task programmer, with the current value of their action bar.*/
    def getCharacters(): List[(Double, CharacterTrait)] = {
        val buffer: ArrayBuffer[(Double, CharacterTrait)] = ArrayBuffer()
        for((k, v) <- added) {
            buffer.addOne((v, k))
        }
        buffer.toList
    }
}
