package spells
import characters._
import weapons._

/** Class for testing the Thunder spell.
 *  For more tests, @see AbstractSpellTest
 */
class ThunderTest extends AbstractSpellTest {

    val thunderSpell: Spell = new Thunder

    test("Execute spell") {
        thunderSpell.execute(blackChar, testEnemy)
        assertEquals(blackChar.getManaPoints, 20)
    }
}
