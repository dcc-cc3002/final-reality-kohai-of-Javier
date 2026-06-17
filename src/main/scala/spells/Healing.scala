package spells

import characters._
import characters.magicalcharacters._
import exceptions._

/** Class for Healing White spell.
 * It can only be used by a white mage.
 */
class Healing extends AbstractSpell {
    def execute(user: MagicalCharacter, target: TCharacter): Unit = {
        positiveWhite(user, target, 15) //Checks whether it is possible to throw the spell
        target.receiveMagicHealing(target.getMaxHealthPoints*3/10)
    }
}
