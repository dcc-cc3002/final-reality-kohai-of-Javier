package controller.states

class ChoosingActionTest extends AbstractGameStateTest {

  test("update test without action") {
    controller.state = new ChoosingAction(characters.head)
    controller.update

    assert(controller.state.isChoosingAction())
  }

  test("update test with action = 'attack'") {
    controller.state = new ChoosingAction(characters.head, Some("attack"))
    controller.update

    assert(controller.state.isChoosingTarget())
  }

  test("update test with action = 'spell'") {
    controller.state = new ChoosingAction(characters.head, Some("spell"))
    controller.update

    assert(controller.state.isChoosingSpell())
  }

  test("update test with action = 'weapon") {
    controller.state = new ChoosingAction(characters.head, Some("weapon"))
    controller.update

    assert(controller.state.isChangingWeapon())
  }

  test("update test with action = 'skip'") {
    controller.state = new ChoosingAction(characters.head, Some("skip"))
    controller.update

    assert(controller.state.isTurnProgramming())
  }
}
