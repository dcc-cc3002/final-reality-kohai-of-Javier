package controller.states

import characters.enemies.{Enemy, TEnemy}
import characters.{TCharacter, Warrior}
import controller.states.enemystates.ApplyingEffects

class ApplyingEffectsTest extends AbstractGameStateTest {

  test("update test") {
    val char: TEnemy = new Enemy("Enemy", 100, 50, 70, 50)
    controller.state = new ApplyingEffects(char)
    controller.update()

    assert(controller.state.isEnemyChoosingTarget)

    val char2: TEnemy = new Enemy("Enemy", 0, 50, 70, 50)
    controller.state = new ApplyingEffects(char2)
    controller.update()

    assert(controller.state.isCharacterElimination)
  }
}
