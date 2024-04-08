package weapons
import characters.CharacterTrait

trait Weapon {
    val nombre: String
    val attackPoints: Double
    val weight: Double

    var owner: CharacterTrait
}
