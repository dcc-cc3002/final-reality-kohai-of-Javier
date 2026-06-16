package spells
import characters._
import characters.enemies._
import weapons._

/** Class for testing the Healing spell.
 *  For more tests, @see AbstractSpellTest
 */
class HealingTest extends AbstractSpellTest {

    val healingSpell: Spell = new Healing

    /** Function to test the execution of the spell, given the damage given to blackChar
     * @param damage The damage given to blackChar
     */
    def executeSpell(damage: Int): Unit = {
        val testEnemy: TEnemy = new Enemy("Enemy", 100, blackChar.getDefense + damage, 50, 70)
        testEnemy.attack(blackChar)

        healingSpell.execute(whiteChar, blackChar)
        assertEquals(whiteChar.getManaPoints, 25)
        assertEquals(blackChar.getHealthPoints, 100.min(100 - damage + 30))//Remember blackChar has 100 initial HP
    }

    test("Execute spell with full 30% recovery") {
        executeSpell(50)

    }

    test("Execute spell with less than 30% recovery") {
        executeSpell(10)
    }

}
