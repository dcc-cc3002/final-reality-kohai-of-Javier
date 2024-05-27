package weapons
import characters.WCharacter
import exceptions.{Require, InvalidStatException}

/** Abstract class for magical weapon.
 * The main difference with an ordinary weapon is that
 * the magical weapons has a magic attack
 *
 * @see AbstractWeapon
 * @param magicAttack Number of magic attack points of the weapon.
 */
abstract class AbstractMagicWeapon(name: String, attackPoints: Int, private val magicAttack: Int, weight: Int, owner: WCharacter) extends AbstractWeapon(name, attackPoints, weight, owner) with MagicWeapon {

    Require.Stat(magicAttack, "magicAttack") atLeast 1

    /** Return the number of magic attack points of the weapon.*/
    def getMagicAttack(): Int = magicAttack

    /** Returns true because the Weapon is magical.*/
    override def isMagical: Boolean = true
}

