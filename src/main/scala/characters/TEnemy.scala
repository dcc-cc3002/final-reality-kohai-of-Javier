package characters

/** The trait for an enemy.
 * An enemy is a character opposing to the player's party.
 * Each enemy has a name, health points, attack, defense and a weight
 * For an implementation, @see Enemy
 */
trait TEnemy extends TCharacter {
    /** Getter for the attack of the enemy.*/
    def getAttack(): Int

}
