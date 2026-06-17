package characters.enemies

import characters.{AbstractCharacter, TCharacter}
import effects.TEffect
import exceptions.{InvalidTargetException, Require, SameTypeException}

import scala.collection.mutable.ListBuffer

/** The class for an enemy.
 * An enemy is a character opposing to the player's party.
 * Each enemy has a name, health points, attack, defense and a weight
 *
 * @param name The name of the enemy
 * @param healthPoints The number of health points of the enemy
 * @param attack The attack of the enemy
 * @param defense The defense of the enemy
 * @param weight The weight of the enemy
 */
class Enemy(name: String, healthPoints: Int, private val attack: Int, defense: Int, weight: Int) extends AbstractCharacter(name, healthPoints, defense, weight) with TEnemy {

    Require.Stat(attack, "attack") atLeast 1

    private var action: String = "attack"
    private val effects: ListBuffer[TEffect] = ListBuffer()

    /** Returns the number of attack points of the enemy.*/
    def getAttack: Int = attack

    /** Getter for the default action of the enemy. */
    def getAction(): String = action

    /** Setter for the default action of the enemy.*/
    def setAction(str: String): Unit = action = str

    /** Returns the value of the action bar to be attained for the enemy to attack.*/
    def fullActionBar(): Int = weight

    /** Receive damage from a playable character.*/
    def receiveDamagePlayer(attackPoints: Int): Unit = receiveDamage(attackPoints)

    /** Tries to receive damage from another enemy, but it throws an exception.*/
    def receiveDamageEnemy(attackPoints: Int): Unit = throw new SameTypeException("Enemy")

    /** Attacks another character.*/
    def attack(other: TCharacter): Unit = other.receiveDamageEnemy(attack)

    /** Receives a positive spell.
     * It throws an InvalidTargetException.
     */
    override def positiveSpell: Unit = throw new InvalidTargetException("A positive spell can not be used with an Enemy")

     /** Receives a negative spell, checking whether it is possible.
      * It checks the enemy is not dead, otherwise it throws an InvalidTargetException.
      */
    override def negativeSpell: Unit = {
        if(healthPoints == 0) {
            throw new InvalidTargetException("A spell can not be used with a dead target")
        }
    }

    /**  */
    override def addEffect(effect: TEffect): Unit = {
        effects += effect
    }

    /** It applies the effects of spells thrown at this enemy. */
    override def applyEffects(): Unit = {
        for(effect <- effects) {
            effect.apply(this)
            if(effect.getTurns == 0)
                effects -= effect
        }
    }
}
