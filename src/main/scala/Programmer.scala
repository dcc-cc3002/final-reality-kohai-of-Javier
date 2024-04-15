import characters.CharacterTrait
import scala.collections.mutable

/** Trait for the turns programmer, it determines which character plays next.
*
*/
trait Programmer {
    def addCharacter(val newCharacter: CharacterTrait): Unit
    def removeCharacter(val toRemove: CharacterTrait): Unit
    def maxActionBar(): Double
    def restartActionBar(val toRestart: CharacterTrait): Unit
    def augmentActionBar(val howMuch: Double): Unit
    def completedActionBar(val myCharacter: CharacterTrait): Unit
    def throwCompleteCharacters(): Seq[CharacterTrait]
    def selectCharacter(): CharacterTrait
    val actionBar: Seq[Double]

}
