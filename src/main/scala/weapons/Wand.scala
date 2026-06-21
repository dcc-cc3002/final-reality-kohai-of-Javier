package weapons
import characters.CharacterTrait

/** Class for Wand magical weapon.
 * @see AbstractMagicWeapon
 */
class Wand(name: String, attackPoints: Double, magicAttack: Double, weight: Double, owner: CharacterTrait) extends AbstractMagicWeapon(name, attackPoints, magicAttack, weight, owner) {
}
