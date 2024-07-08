package controller.states.magicalstates

import characters.magicalcharacters.{MagicalCharacter, WhiteMage}
import controller.states.AbstractGameStateTest
import spells.Healing

class ChoosingSpellTest extends AbstractGameStateTest {

  test("update test with no spell") {
    val magicChar: MagicalCharacter = new WhiteMage("White Mage", 100, 100, 50, 70)
    controller.state = new ChoosingSpell(magicChar)
    controller.update

    assert(controller.state.isChoosingSpell)
  }

  test("update test with a Healing spell") {
    val magicChar: MagicalCharacter = new WhiteMage("White Mage", 100, 100, 50, 70)
    controller.state = new ChoosingSpell(magicChar, Some(new Healing))
    controller.update

    assert(controller.state.isMagicalChoosingTarget)
  }
}
