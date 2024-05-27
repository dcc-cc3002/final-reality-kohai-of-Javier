package spells
import characters.{MagicalCharacter, TCharacter}
import exceptions._

/** Abstract Class for a magic spell.*/
abstract class AbstractSpell extends Spell {

    /** Executes a negative black spell.
     * If it is not possible, an exception is thrown.
     */
    protected def negativeBlack(user: MagicalCharacter, target: TCharacter, manaCost: Int): Unit = {
        target.negativeSpell
        user.blackSpell(manaCost)
    }

    /** Executes a positive black spell.
     * If it is not possible, an exception is thrown.
     */
    protected def positiveBlack(user: MagicalCharacter, target: TCharacter, manaCost: Int): Unit = {
        target.positiveSpell
        user.blackSpell(manaCost)
    }

    /** Executes a negative white spell.
     * If it is not possible, an exception is thrown.
     */
    protected def negativeWhite(user: MagicalCharacter, target: TCharacter, manaCost: Int): Unit = {
        target.negativeSpell
        user.whiteSpell(manaCost)
    }

    /** Executes a positive white spell.
     * If it is not possible, an exception is thrown.
     */
    protected def positiveWhite(user: MagicalCharacter, target: TCharacter, manaCost: Int): Unit = {
        target.positiveSpell
        user.whiteSpell(manaCost)
    }
}
