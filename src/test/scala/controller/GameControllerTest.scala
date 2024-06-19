package controller

import characters.enemies.{Enemy, TEnemy}
import controller.states.TurnProgramming
import characters.{Ninja, Paladin, TCharacter, WCharacter, Warrior}

class GameControllerTest extends munit.FunSuite {


  test("Constructor test with less than 3 characters") {
    val newChar: WCharacter = new Warrior("Warrior", 100, 50, 70)
    val newEn: TEnemy = new Enemy("Enemy", 100, 100, 100, 100)
    intercept[Exception]( new GameController(List(newChar), List(newEn)))
  }

  test("Constructor test with 3 characters and no enemy") {
    val charList: List[WCharacter] = List(new Warrior("Warrior", 100, 50, 70), new Ninja("Ninja", 100, 50, 70), new Paladin("Paladin", 100, 50, 70))
    intercept[Exception](new GameController(charList, List()))
  }

  private def buildController(): GameController = {
    val charList: List[WCharacter] = List(new Warrior("Warrior", 100, 50, 70), new Ninja("Ninja", 100, 50, 70), new Paladin("Paladin", 100, 50, 70))
    val newEn: TEnemy = new Enemy("Enemy", 100, 100, 100, 100)
    new GameController(charList, List(newEn))
  }
  test("Constructor test with 3 characters and an enemy") {
    val controller: GameController = buildController()
    val programmerCharacters: List[(Int, TCharacter)] = controller.turnProgrammer.getCharacters()

    assertEquals(programmerCharacters.size, 4)
    assert(controller.state.isTurnProgramming())
    assert(!controller.playerParty.isDefeated())
  }

  test("win, lose and isFinished test") {
    val controller: GameController = buildController()
    assert(!controller.win())
    assert(!controller.lose())
    assert(!controller.isFinished)
  }
}
