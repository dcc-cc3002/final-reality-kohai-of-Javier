package controller.states

import characters.{TCharacter, Warrior}

class ApplyingEffectsTest extends AbstractGameStateTest {

  test("update test") {
    val char: TCharacter = new Warrior("Warrior", 100, 50, 70)
    controller.state = new ApplyingEffects(char)
    controller.update

    assert(controller.state.isChoosingAction())

    val char2: TCharacter = new Warrior("Warrior", 0, 50, 70)
    controller.state = new ApplyingEffects(char2)
    controller.update

    assert(controller.state.isCharacterElimination())
  }
}
