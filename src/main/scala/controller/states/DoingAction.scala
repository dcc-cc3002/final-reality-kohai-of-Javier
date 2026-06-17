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

  def update(controller: GameController): Unit = {
    if(spell.isDefined) {
      attacker.castSpell(target, spell.get)
    }
    else
      attacker.attack(target)

    if(target.getHealthPoints() == 0)
      controller.state = new CharacterElimination(target)
    else
      controller.state = new TurnProgramming
  }
}
