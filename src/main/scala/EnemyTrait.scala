/** The trait for an enemy.
 * An enemy is a character opposing to the player's party.
 * Each enemy has a name, health points, attack, defense and a weight
 */
trait EnemyTrait {
    val name: String
    var healthPoints: Double
    val attack: Double
    val defense: Double
    val weight: Double
}
