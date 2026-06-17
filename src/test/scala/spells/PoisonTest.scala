package spells
import characters._
import weapons._

/** Class for testing the Poison spell.
 *  For more tests, @see AbstractSpellTest
 */
class PoisonTest extends AbstractSpellTest {

    val poisonSpell: Spell = new Poison

    test("Execute spell") {
        poisonSpell.execute(whiteChar, testEnemy)
        assertEquals(whiteChar.getManaPoints, 10)
    }
}
