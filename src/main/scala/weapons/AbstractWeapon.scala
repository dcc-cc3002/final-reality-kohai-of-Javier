package weapons
import characters.CharacterTrait

abstract class AbstractWeapon(val name: String, val attackPoints: Double, val weight: Double, var owner: CharacterTrait) extends Weapon {
}

