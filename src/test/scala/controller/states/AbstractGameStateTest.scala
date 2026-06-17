package controller.states

import characters.{TCharacter, Warrior}
import controller.GameController

abstract class AbstractGameStateTest extends munit.FunSuite {
  protected var controller: GameController = _
  protected var characters: List[TCharacter] = _
  override def beforeEach(context: BeforeEach) = {
    characters = List(new Warrior("Warrior", 100, 50, 70))
    controller = new GameController(characters)
  }

}
