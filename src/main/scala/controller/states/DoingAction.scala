package controller.states

import characters.TCharacter
import controller.GameController
import spells.Spell

/** State class for attacking or throwing a spell.
 *
 * @param attacker The attacking character.
 * @param target The target of the attack or spell.
 * @param spell Option with the spell being used, if any.
 * */
class DoingAction(attacker: TCharacter, target: TCharacter, spell: Option[Spell] = None) extends AbstractGameState {

  /** Changes the state of the game controller */
  def update(controller: GameController): Unit = {
    if(spell.isDefined) {
      attacker.castSpell(target, spell.get)
    }
    else
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
