import weapons.{Weapon, AuxiliaryWeapon}
import characters.CharacterTrait

/** The trait for an enemy.
 * An enemy is a character opposing to the player's party.
 * Each enemy has a name, health points, attack, defense and a weight
 * In this case it's attack is implemented using a Weapon, this if for making the implementation of combats easier
 *
 * @param name The name of the enemy
 * @param healthPoints The number of health points of the enemy. It must be >= 0
 * @param attack The attack of the enemy. It must be >= 0
 * @param defense The defense of the enemy. It must be >= 0
 * @param weight The weight of the enemy. It must be >= 0
 */
class Enemy(val name: String, var healthPoints: Double, val attack: Double, val defense: Double, val weight: Double) extends CharacterTrait {
    var weapon: Option[Weapon] = Some(new AuxiliaryWeapon("attack", attack, 0, this))

    def maxActionBar(): Double = weight
}
