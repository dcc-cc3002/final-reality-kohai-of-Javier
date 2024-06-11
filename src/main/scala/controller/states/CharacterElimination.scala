package controller.states

import characters.TCharacter
import controller.GameController

/** State class when there is a defeated character who has to be eliminated.
 *
 * @param toEliminate The character to be eliminated. */
class CharacterElimination(toEliminate: TCharacter) extends AbstractGameState {

  /** Changes the state of the game controller */
  def update(controller: GameController): Unit = {
    controller.turnProgrammer.removeCharacter(toEliminate)
    controller.state = new TurnProgramming
  }

  /** Returns true because this state is CharacterElimination. */
  override def isCharacterElimination(): Boolean = true
}
