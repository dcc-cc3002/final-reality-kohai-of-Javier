package characters
import effects.TEffect
import exceptions.{InvalidTargetException, Require}
import spells.Spell
import weapons.Weapon

/** Abstract class for a generic character.
 * @param name The name of the character. It must be non-empty
 * @param healthPoints Initial and maximum HP of the character. It must be at least 0
 * @param defense Number of defense points of the character. It must be at least 0
 * @param weight Weight of the character. It must be at least 1
 */
abstract class AbstractCharacter(private val name: String, private var healthPoints: Int, private val defense: Int, private val weight: Int) extends TCharacter {

    Require.Stat(name.length, "name length") atLeast 1
    Require.Stat(healthPoints, "healthPoints") atLeast 0
    Require.Stat(defense, "defense") atLeast 0
    Require.Stat(weight, "weight") atLeast 1

    private val maxHP: Int = healthPoints

    /** Returns the number of current health points.*/
    def getHealthPoints(): Int = healthPoints

    /** Returns the maximium number of health points this character can have.*/
    def getMaxHealthPoints(): Int = maxHP

    /** Returns the name of the character.*/
    def getName(): String = name

    /** Returns the number of defense points of the character.*/
    def getDefense(): Int = defense

    /** Returns the weight of the character.*/
    def getWeight(): Int = weight

    /** Function that is called when the character is attacked by another.*/
    def receiveDamage(attackPoints: Int): Unit = {
        if(attackPoints > defense) healthPoints -= attackPoints - defense
        if(healthPoints < 0) healthPoints = 0
    }

    /** Receive damage from a spell.*/
    def receiveMagicDamage(magicDamage: Int): Unit = {
        healthPoints -= magicDamage
        if(healthPoints < 0) healthPoints = 0
    }

    /** Receive healing from a spell.*/
    def receiveMagicHealing(magicHealing: Int): Unit = {
        healthPoints += magicHealing
        if(healthPoints > maxHP) healthPoints = maxHP
    }

    /** Receive a positive spell, checking whether it is possible.
     * It checks the target is not dead, otherwise it throws an InvalidTargetException.
     * Enemies override this method for throwing an InvalidTargetException.
     */
    def positiveSpell(): Unit = {
        if(healthPoints == 0) {
            throw new InvalidTargetException("A spell can not be used with a dead target.")
        }
    }

    /** Receive a negative spell.
     * It throws an InvalidTargetException.
     * Enemies override this method to accept the spell.
     */
    def negativeSpell(): Unit = throw new InvalidTargetException("A negative spell can not be used with an ally")

    /** It does nothing. In AbstractWCharacter it changes the weapon of the character.
     * @see AbstractWCharacter */
    def changeWeapon(wp: Weapon): Unit = {}

    /** It does nothing. In AbstractMagicalCharacter it casts a spell.
     * @see AbstractMagicalCharacter */
    def castSpell(target: TCharacter, spell: Spell): Unit = {}

    /** It does nothing, since only enemies receive effects.
     * @see Enemy */
    def addEffect(e: TEffect): Unit = {}

    /** It does nothing, since only enemies receive effects.
     * @see Enemy */
    def applyEffects(): Unit = {}
}
