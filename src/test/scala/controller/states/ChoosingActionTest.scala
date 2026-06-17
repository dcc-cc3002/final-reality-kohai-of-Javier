package controller.states

class ChoosingActionTest extends AbstractGameStateTest {

  test("update test") {
    controller.state = new ChoosingAction(characters.head)
    controller.update
    assert(controller.state.isInstanceOf[ChoosingAction])
  }
}
