package weapons
import characters.CharacterTrait

/** Abstract class for magical weapon.
 * The main difference with an ordinary weapon is that
 * the magical weapons has a magic attack
 *
 * @see AbstractWeapon
 */
abstract class AbstractMagicWeapon(val name: String, val attackPoints: Double, val magicAttack: Double, val weight: Double, var owner: CharacterTrait) extends MagicWeapon {

}

