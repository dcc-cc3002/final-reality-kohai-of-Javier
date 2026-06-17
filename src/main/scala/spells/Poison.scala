package spells

import characters._
import characters.magicalcharacters._
import exceptions._

/** Class for Poison White spell.
 * It can only be used by a white mage.
 */
class Poison extends AbstractSpell {
    def execute(user: MagicalCharacter, target: TCharacter): Unit = {
        negativeWhite(user, target, 30)
    }
}
