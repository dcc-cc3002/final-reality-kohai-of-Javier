package controller.states

import characters.TCharacter
import controller.GameController

/** State class when there is a defeated character who has to be eliminated.
 *
 * @param toEliminate The character to be eliminated. */
class CharacterElimination(toEliminate: TCharacter) extends AbstractGameState {

  def update(controller: GameController): Unit = {
    controller.turnProgrammer.removeCharacter(toEliminate)
    controller.state = new TurnProgramming
  }

}
