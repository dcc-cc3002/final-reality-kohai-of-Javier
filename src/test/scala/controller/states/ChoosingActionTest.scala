package controller.states

import characters.magicalcharacters.WhiteMage
import controller.states.magicalstates.MagicalChoosingAction

class ChoosingActionTest extends AbstractGameStateTest {

  test("update test without action") {
    controller.state = new ChoosingAction(characters.head)
    controller.update

    assert(controller.state.isChoosingAction)
  }

  test("update test with action = 'attack'") {
    controller.state = new ChoosingAction(characters.head, Some("attack"))
    controller.update

    assert(controller.state.isChoosingTarget)
  }

  test("update test with action = 'spell'") {
    controller.state = new MagicalChoosingAction(new WhiteMage("mage",1,1,1,1), Some("spell"))
    controller.update

    assert(controller.state.isChoosingSpell)
  }

  test("update test with action = 'weapon") {
    controller.state = new ChoosingAction(characters.head, Some("weapon"))
    controller.update

    assert(controller.state.isChangingWeapon)
  }

}
