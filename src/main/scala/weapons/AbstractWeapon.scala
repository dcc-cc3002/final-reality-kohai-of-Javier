package weapons
import characters.CharacterTrait

/** Abstract class for a weapon.
 *
 * @param name The name of the weapon
 * @param attackPoints number of attack points of the weapon
 * @param weight The weight of the weapon
 * @param owner A Character that owns the weapon
 */
abstract class AbstractWeapon(val name: String, val attackPoints: Double, val weight: Double, var owner: CharacterTrait) extends Weapon {
}

