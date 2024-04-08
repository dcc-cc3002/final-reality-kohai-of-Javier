package weapons
import characters.CharacterTrait

trait Weapon {
    val name: String
    val attackPoints: Double
    val weight: Double

    var owner: CharacterTrait
}
