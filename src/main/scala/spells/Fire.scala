package spells
import characters.{MagicalCharacter, TCharacter}
import exceptions._

/** Class for Fire Black spell.
 * It can only be used by a black mage.
 */
class Fire extends AbstractSpell {
    def execute(user: MagicalCharacter, target: TCharacter): Unit = {
        negativeBlack(user, target, 15)
    }
}
