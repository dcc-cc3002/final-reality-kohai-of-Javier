package weapons
import characters.CharacterTrait

/** Class for the auxiliary weapon used by Enemies.
 *
 * @param name The name of the weapon
 * @param attackPoints number of attack points of the weapon
 * @param weight The weight of the weapon
 * @param owner The enemy that owns the weapon
 */
class AuxiliaryWeapon(val name: String, val attackPoints: Double, val weight: Double, var owner: CharacterTrait) extends Weapon {
}
