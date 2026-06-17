package controller

import characters.enemies.{Enemy, TEnemy}
import controller.states.TurnProgramming
import characters.{Ninja, Paladin, TCharacter, WCharacter, Warrior}
import view.GameView

class GameControllerTest extends munit.FunSuite {


  test("Constructor test with less than 3 characters") {
    val newChar: WCharacter = new Warrior("Warrior", 100, 50, 70)
    val newEn: TEnemy = new Enemy("Enemy", 100, 100, 100, 100)
    intercept[Exception]( new GameController(new GameView, Array(newChar), Array(newEn)))
  }

  test("Constructor test with 3 characters and no enemy") {
    val charList: Array[WCharacter] = Array(new Warrior("Warrior", 100, 50, 70), new Ninja("Ninja", 100, 50, 70), new Paladin("Paladin", 100, 50, 70))
    intercept[Exception](new GameController(new GameView, charList, Array()))
  }

  private def buildController(): GameController = {
    val charList: Array[WCharacter] = Array(new Warrior("Warrior", 100, 50, 70), new Ninja("Ninja", 100, 50, 70), new Paladin("Paladin", 100, 50, 70))
    val newEn: TEnemy = new Enemy("Enemy", 100, 100, 100, 100)
    new GameController(new GameView, charList, Array(newEn))
  }
  test("Constructor test with 3 characters and an enemy") {
    val controller: GameController = buildController()
    val programmerCharacters: Array[(Int, TCharacter)] = controller.turnProgrammer.getCharacters().toArray

    assertEquals(programmerCharacters.length, 4)
    assert(controller.state.isTurnProgramming)
    assert(!controller.playerParty.isDefeated())
  }

  test("win, lose and isFinished test") {
    val controller: GameController = buildController()
    assert(!controller.win())
    assert(!controller.lose())
    assert(!controller.isFinished)
  }
}
