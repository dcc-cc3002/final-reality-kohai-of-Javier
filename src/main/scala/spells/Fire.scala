package spells

import characters._
import characters.magicalcharacters._
import effects.Burned
import exceptions._

/** Class for Fire Black spell.
 * It can only be used by a black mage.
 */
class Fire extends AbstractSpell {

    def execute(user: MagicalCharacter, target: TCharacter): Unit = {
        negativeBlack(user, target, 15) // Check whether it is possible to throw the spell
        val magicDamage: Int = user.getMagicWeapon.get.getMagicAttack
        target.receiveMagicDamage(magicDamage)

        if(hasEffect(20)) target.addEffect(new Burned(magicDamage))
    }
}
