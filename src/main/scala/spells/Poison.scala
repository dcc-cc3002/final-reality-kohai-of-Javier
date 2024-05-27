package spells
import characters.{MagicalCharacter, TCharacter}
import exceptions._

/** Class for Poison White spell.
 * It can only be used by a white mage.
 */
class Poison extends AbstractSpell {
    def execute(user: MagicalCharacter, target: TCharacter): Unit = {
        negativeWhite(user, target, 30)
    }
}
