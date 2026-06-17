package spells
import characters._
import weapons._

/** Class for testing the Paralysis spell.
 *  For more tests, @see AbstractSpellTest
 */
class ParalysisTest extends AbstractSpellTest {

    val paralysisSpell: Spell = new Paralysis

    test("Execute spell") {
        paralysisSpell.execute(whiteChar, testEnemy)
        assertEquals(whiteChar.getManaPoints, 15)
    }
}
