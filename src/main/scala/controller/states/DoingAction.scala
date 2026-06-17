package controller.states

import characters.TCharacter
import controller.GameController

/** State class for attacking or throwing a spell.
 *
 * @param attacker The attacking character.
 * @param target The target of the attack or spell.
 * */
class DoingAction(private val attacker: TCharacter, private val target: TCharacter) extends AbstractGameState {

  /** Changes the state of the game controller */
  def update(controller: GameController): Unit = {
    attacker.attack(target)

    controller.turnProgrammer.restartActionBar(attacker)

    if(target.getHealthPoints == 0)
      controller.state = new CharacterElimination(target)
    else
      controller.state = new TurnProgramming
  }

  /** Returns true because this state is DoingAction. */
  override def isDoingAction(): Boolean = true
}
