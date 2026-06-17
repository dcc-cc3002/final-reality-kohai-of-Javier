package characters
import weapons.Weapon

/** Class for Ninja Common Character */
class Ninja(name: String, healthPoints: Int, defense: Int, weight: Int) extends CommonCharacter(name, healthPoints, defense, weight) {

    /** Setter of the weapon of the character.*/
    def setWeapon(wp: Weapon): Unit = {
        checkOwner(wp)
        wp.checkNinja
        weapon = Some(wp)
    }
}
