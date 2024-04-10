package characters
import weapons.Weapon

abstract class AbstractCharacter(val name: String, var healthPoints: Double, val defense: Double, val weight: Double) extends CharacterTrait {
    var weapon: Option[Weapon] = None
}
