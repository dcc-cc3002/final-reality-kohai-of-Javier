package weapons
import characters.TCharacter

/** Abstract class for magical weapon.
 * The main difference with an ordinary weapon is that
 * the magical weapons has a magic attack
 *
 * @see AbstractWeapon
 * @param magicAttack Number of magic attack points of the weapon
 */
abstract class AbstractMagicWeapon(val name: String, val attackPoints: Double, val magicAttack: Double, val weight: Double, var owner: TCharacter) extends MagicWeapon {

}

