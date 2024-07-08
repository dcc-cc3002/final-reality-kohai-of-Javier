package controller.states.enemystates

import controller.states.AbstractGameStateTest

class EnemyChoosingTargetTest extends AbstractGameStateTest {

  test("update test") {
    controller.update()
    assert(controller.state.isDoingAction)
  }

}
