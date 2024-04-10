package weapons
import characters.CharacterTrait

class Staff(name: String, attackPoints: Double, magicAttack: Double, weight: Double, owner: CharacterTrait) extends AbstractMagicWeapon(name, attackPoints, magicAttack, weight, owner) {
}
