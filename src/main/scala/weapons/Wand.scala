package weapons
import characters.WCharacter

/** Class for Wand magical weapon.
 * @see AbstractMagicWeapon
 */
class Wand(name: String, attackPoints: Int, magicAttack: Int, weight: Int, owner: WCharacter) extends AbstractMagicWeapon(name, attackPoints, magicAttack, weight, owner) {
}
