package controller.states.magicalstates

import characters.TCharacter
import characters.enemies.TEnemy
import characters.magicalcharacters.MagicalCharacter
import controller.GameController
import controller.states.AbstractGameState
import spells.Spell

/** State class for a magical character doing an action (casting a spell or attacking an enemy)
 *
 * @param attacker The character who is doing the action
 * @param target The target of the action
 * @param spell Option with a spell, if the action consists in throwing a spell
 * */
class MagicalDoingAction(private val attacker: MagicalCharacter, private val target: TCharacter, private val spell: Option[Spell] = None) extends AbstractGameState {

  /** Changes the state of the game controller. */
  def update(controller: GameController): Unit = {
    if(spell.isDefined) {
      try {
        attacker.castSpell(target, spell.get)
      }
      catch {
        case (e) => {
          controller.state = new MagicalChoosingAction(attacker)
        }
      }
    }
  }

  /** Returns true because this state is MagicalDoingAction */
  override def isMagicalDoingAction: Boolean = true
}
