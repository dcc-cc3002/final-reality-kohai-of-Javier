package controller.states

class TurnProgrammingTest extends AbstractGameStateTest {

  test("update test") {
    controller.state = new TurnProgramming
    controller.update
    assertEquals(controller.turnProgrammer.selectCharacter(), characters.head)
    assert(controller.state.isInstanceOf[ApplyingEffects])
  }
}
