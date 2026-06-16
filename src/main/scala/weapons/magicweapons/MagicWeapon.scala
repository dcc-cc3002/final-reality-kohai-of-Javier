package weapons.magicweapons

import weapons.Weapon

/** Trait for a Magical Weapon.*/
trait MagicWeapon extends Weapon {
    /** Getter for the number of magic attack points of the weapon.*/
    def getMagicAttack(): Int
}
