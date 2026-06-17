package controller

import controller.states.TurnProgramming
import characters.{Ninja, Paladin, TCharacter, Warrior}

class GameControllerTest extends munit.FunSuite {


  test("Constructor test") {
    val newChar: TCharacter = new Warrior("Warrior", 100, 50, 70)
    val controller: GameController = new GameController(List(newChar))
    val programmerCharacters: List[(Int, TCharacter)] = controller.turnProgrammer.getCharacters()
    assertEquals(programmerCharacters.head, (0, newChar))
    assert(controller.state.isInstanceOf[TurnProgramming])
  }
}
