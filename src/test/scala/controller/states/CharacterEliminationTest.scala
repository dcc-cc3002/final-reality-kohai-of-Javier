package controller.states

import characters.Ninja

class CharacterEliminationTest extends AbstractGameStateTest {

  test("update test") {
    controller.state = new CharacterElimination(characters.head)
    controller.update

    assert(controller.state.isInstanceOf[TurnProgramming])
  }
}
