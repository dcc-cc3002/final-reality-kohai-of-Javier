package controller.states

import characters.enemies.{Enemy, TEnemy}
import characters.{Ninja, Paladin, TCharacter, WCharacter, Warrior}
import controller.GameController

abstract class AbstractGameStateTest extends munit.FunSuite {
  protected var controller: GameController = _
  protected var characters: List[WCharacter] = _
  protected val testEnemy: TEnemy = new Enemy("Enemy", 50,50,50,50)

  override def beforeEach(context: BeforeEach) = {
    characters = List(new Warrior("Warrior", 100, 50, 70), new Ninja("Ninja", 100, 50, 70), new Paladin("Paladin", 100, 50, 70))
    controller = new GameController(characters, List(testEnemy))
  }

  test("getters test") {
    controller.state = new TurnProgramming
    assert(!controller.state.isApplyingEffects())
    assert(!controller.state.isChangingWeapon())
    assert(!controller.state.isCharacterElimination())
    assert(!controller.state.isChoosingAction())
    assert(!controller.state.isChoosingSpell())
    assert(!controller.state.isChoosingTarget())
    assert(!controller.state.isDoingAction())
  }
}
