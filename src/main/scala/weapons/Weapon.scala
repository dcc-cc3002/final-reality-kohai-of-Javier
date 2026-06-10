package weapons
import characters.CharacterTrait

/** Trait for Weapons
 * @param name Name of the weapon
 * @param attackPoints Number of attack points of the weapon
 * @param weight Weight of the weapon
 * @param owner Character that owns the weapon
 */
trait Weapon {
    val name: String
    val attackPoints: Double
    val weight: Double

    var owner: CharacterTrait
}
