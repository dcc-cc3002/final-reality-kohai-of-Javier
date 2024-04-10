package weapons
import characters.CharacterTrait

abstract class AbstractMagicWeapon(val name: String, val attackPoints: Double, val magicAttack: Double, val weight: Double, var owner: CharacterTrait) extends MagicWeapon {

}

