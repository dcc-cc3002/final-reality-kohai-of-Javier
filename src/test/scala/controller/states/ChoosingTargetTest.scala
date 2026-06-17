package controller.states

class ChoosingTargetTest extends AbstractGameStateTest {

  test("update test") {
    controller.state = new ChoosingTarget(characters.head)
    controller.update
    assert(controller.state.isInstanceOf[ChoosingTarget])
  }
}
