package spells
import characters._
import weapons._

/** Class for testing the Healing spell.
 *  For more tests, @see AbstractSpellTest
 */
class HealingTest extends AbstractSpellTest {

    val healingSpell: Spell = new Healing

    test("Execute spell") {
        healingSpell.execute(whiteChar, blackChar)
        assertEquals(whiteChar.getManaPoints, 25)
    }
}
