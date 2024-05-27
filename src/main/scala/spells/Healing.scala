package spells
import characters.{MagicalCharacter, TCharacter}
import exceptions._

/** Class for Healing White spell.
 * It can only be used by a white mage.
 */
class Healing extends AbstractSpell {
    def execute(user: MagicalCharacter, target: TCharacter): Unit = {
        positiveWhite(user, target, 15)
    }
}
