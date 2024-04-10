package weapons
import characters.CharacterTrait

class AuxiliaryWeapon(val name: String, val attackPoints: Double, val weight: Double, var owner: CharacterTrait) extends Weapon {
}
