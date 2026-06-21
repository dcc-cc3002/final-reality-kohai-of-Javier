package weapons

/** Trait for a Magical Weapon
 * @param getMagicAttack Returns the number of the magical attack points of the weapon
 */
trait MagicWeapon extends Weapon {
    def getMagicAttack(): Int
}
