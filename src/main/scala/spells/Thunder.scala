package spells

import characters._
import characters.magicalcharacters._
import effects.Paralyzed

import scala.util.Random

/** Class for Thunder Black spell.
 * It can only be used by a black mage.
 */
class Thunder extends AbstractSpell {
    def execute(user: MagicalCharacter, target: TCharacter): Unit = {
        negativeBlack(user, target, 20) // Checks whether it is possible to throw the spell
        val magicDamage: Int = user.getMagicWeapon.get.getMagicAttack
        target.receiveMagicDamage(magicDamage)

        if(hasEffect(30)) target.addEffect(new Paralyzed)
    }
}
