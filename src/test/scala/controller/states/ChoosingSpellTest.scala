package controller.states

import characters.TCharacter
import characters.magicalcharacters.WhiteMage

class ChoosingSpellTest extends AbstractGameStateTest {

  test("update test") {
    val magicChar: TCharacter = new WhiteMage("White Mage", 100, 100, 50, 70)
    controller.state = new ChoosingSpell(magicChar)
    controller.update
    assert(controller.state.isInstanceOf[ChoosingSpell])
  }
}
