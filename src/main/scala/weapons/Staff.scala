package weapons
import characters.WCharacter

/** Class for Staff magical weapon.
 * @see AbstractMagicWeapon
 */
class Staff(name: String, attackPoints: Int, magicAttack: Int, weight: Int, owner: WCharacter) extends AbstractMagicWeapon(name, attackPoints, magicAttack, weight, owner) {
}
