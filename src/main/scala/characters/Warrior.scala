package characters
import weapons.Weapon

/** Class for Common Character: Warrior */
class Warrior(name: String, healthPoints: Int, defense: Int, weight: Int) extends CommonCharacter(name, healthPoints, defense, weight) {

      /** Setter of the weapon of the character.*/
      def setWeapon(wp: Weapon): Unit = {
         checkOwner(wp)
         wp.checkWarrior
         weapon = Some(wp)
      }
}
