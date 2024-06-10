package spells

import characters._
import characters.magicalcharacters._
import effects.Paralyzed
import exceptions._

/** Class for Paralysis White spell.
 * It can only be used by a white mage.
 */
class Paralysis extends AbstractSpell {
    def execute(user: MagicalCharacter, target: TCharacter): Unit = {
        negativeWhite(user, target, 25)
        target.addEffect(new Paralyzed)
    }
}
