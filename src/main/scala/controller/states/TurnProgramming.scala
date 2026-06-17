package controller.states

import controller.GameController

/** State class for determining the character who will play the next turn. */
class TurnProgramming extends AbstractGameState {
  def update(controller: GameController): Unit = {
    val k: Int = 10
    while(controller.turnProgrammer.throwCompleteCharacters().isEmpty)
      controller.turnProgrammer.augmentActionBar(k)
    controller.state = new ApplyingEffects(controller.turnProgrammer.selectCharacter)
  }
}
