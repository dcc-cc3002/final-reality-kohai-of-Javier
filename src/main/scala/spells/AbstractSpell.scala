package spells

import characters._
import characters.magicalcharacters._
import exceptions._

import scala.util.Random

/** Abstract Class for a magic spell.*/
abstract class AbstractSpell extends Spell {

    /** Determines whether an probable effect will be  applied to the target.
     * @param percentage The probability in percentage of an effect being applied.
     * */
    protected def hasEffect(percentage: Int): Boolean = {
        val rand: Random = new Random
        if(rand.nextInt() % 100 < percentage)
            true
        else
            false
    }

    /** Executes a negative black spell.
     * If it is not possible, an exception is thrown.
     */
    protected def negativeBlack(user: MagicalCharacter, target: TCharacter, manaCost: Int): Unit = {
        target.negativeSpell()
        user.blackSpell(manaCost)
    }

    /** Executes a negative white spell.
     * If it is not possible, an exception is thrown.
     */
    protected def negativeWhite(user: MagicalCharacter, target: TCharacter, manaCost: Int): Unit = {
        target.negativeSpell()
        user.whiteSpell(manaCost)
    }

    /** Executes a positive white spell.
     * If it is not possible, an exception is thrown.
     */
    protected def positiveWhite(user: MagicalCharacter, target: TCharacter, manaCost: Int): Unit = {
        target.positiveSpell()
        user.whiteSpell(manaCost)
    }
}
