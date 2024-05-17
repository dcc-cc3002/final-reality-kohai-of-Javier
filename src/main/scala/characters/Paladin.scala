package characters
import weapons.Weapon

/** Class for Common Character: Paladin */
class Paladin(name: String, healthPoints: Int, defense: Int, weight: Int) extends CommonCharacter(name, healthPoints, defense, weight) {

     /** Setter of the weapon of the character.*/
     def setWeapon(wp: Weapon): Unit = {
        wp.checkPaladin
        weapon = Some(wp)
     }
}
