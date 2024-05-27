package spells
import characters._
import weapons._

/** Class for testing the Fire spell.
 *  For more tests, @see AbstractSpellTest
 */
class FireTest extends AbstractSpellTest {

    val fireSpell: Spell = new Fire

    test("Execute spell") {
        fireSpell.execute(blackChar, testEnemy)
        assertEquals(blackChar.getManaPoints, 25)
    }
}
