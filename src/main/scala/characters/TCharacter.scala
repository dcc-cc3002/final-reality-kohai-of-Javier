package characters

/** Trait for a Character
 * @param fullActionBar Returns the value of the action bar to be attained for the character to play
 * @param receiveDamage Function that is called when the character is attacked by another
 * @param getName Returns the name of the character
 * @param getDefense Returns the defense of the character
 * @param getDefense Returns the number of defense points of the character
 * @param getWeight Returns the weight of the character
 * @param getHealthPoints Getter for the number of health points of the character
 */
trait TCharacter {
    def fullActionBar(): Int
    def attack(other: TCharacter): Unit
    def receiveDamage(attackPoints: Int): Unit
    def receiveDamagePlayer(attackPoints: Int): Unit
    def receiveDamageEnemy(attackPoints: Int): Unit

    def getName(): String
    def getDefense(): Int
    def getWeight(): Int
    def getHealthPoints(): Int
}
