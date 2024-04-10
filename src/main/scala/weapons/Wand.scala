package weapons
import characters.CharacterTrait

class Wand(name: String, attackPoints: Double, magicAttack: Double, weight: Double, owner: CharacterTrait) extends AbstractMagicWeapon(name, attackPoints, magicAttack, weight, owner) {
}
