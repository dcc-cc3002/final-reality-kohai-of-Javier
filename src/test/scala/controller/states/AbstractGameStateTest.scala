package controller.states

import characters.enemies.{Enemy, TEnemy}
import characters.{Ninja, Paladin, TCharacter, WCharacter, Warrior}
import controller.GameController
import view.GameView

abstract class AbstractGameStateTest extends munit.FunSuite {
  protected var controller: GameController = _
  protected var characters: Array[WCharacter] = _
  protected val testEnemy: TEnemy = new Enemy("Enemy", 50,50,50,50)

  override def beforeEach(context: BeforeEach) = {
    characters = Array(new Warrior("Warrior", 100, 50, 70), new Ninja("Ninja", 100, 50, 70), new Paladin("Paladin", 100, 50, 70))
    controller = new GameController(new GameView, characters, Array(testEnemy))
  }

  test("getters test") {
    controller.state = new TurnProgramming
    assert(!controller.state.isApplyingEffects)
    assert(!controller.state.isChangingWeapon)
    assert(!controller.state.isCharacterElimination)
    assert(!controller.state.isChoosingAction)
    assert(!controller.state.isChoosingSpell)
    assert(!controller.state.isChoosingTarget)
    assert(!controller.state.isDoingAction)
  }
}
