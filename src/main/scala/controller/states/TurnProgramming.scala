package controller.states

import characters.TCharacter
import controller.GameController

/** State class for determining the character who will play the next turn. */
class TurnProgramming extends AbstractGameState {

  /** Changes the state of the game controller */
  def update(controller: GameController): Unit = {
    val k: Int = 10
    while(controller.turnProgrammer.throwCompleteCharacters().isEmpty)
      controller.turnProgrammer.augmentActionBar(k)

    val selected: TCharacter = controller.turnProgrammer.selectCharacter()
    controller.state = selected.setState()
  }

  /** Returns true because this state is TurnProgramming. */
  override def isTurnProgramming(): Boolean = true
}
