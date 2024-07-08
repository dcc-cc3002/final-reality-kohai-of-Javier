package controller.states

import characters.enemies.Enemy

class ChoosingTargetTest extends AbstractGameStateTest {

  test("update test with no target") {
    controller.state = new ChoosingTarget(characters.head)
    controller.update

    assert(controller.state.isChoosingTarget)
  }

  test("update test with target") {
    controller.state = new ChoosingTarget(characters.head, Some(new Enemy("Enemy", 100, 50, 50, 50)))
    controller.update

    assert(controller.state.isDoingAction)
  }
}
