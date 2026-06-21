package characters
import weapons.Weapon

trait CharacterTrait {
    val name: String
    var healthPoints: Double
    val defense: Double
    val weight: Double

    var weapon: Option[Weapon]
}
