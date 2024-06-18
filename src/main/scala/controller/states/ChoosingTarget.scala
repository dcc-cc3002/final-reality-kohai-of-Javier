package controller.states

import characters.TCharacter
import controller.GameController
import spells.Spell

/** State class for choosing a target
 *
 * @param attackingChar The character currently attacking or throwing a spell.
 * @param spell An option with the spell used.
 * @param ta Option for testing purposes.
 * */
class ChoosingTarget(attackingChar: TCharacter, spell: Option[Spell] = None, ta: Option[TCharacter] = None) extends AbstractGameState {
  private var target: Option[TCharacter] = ta

  /** Changes the state of the game controller */
  def update(controller: GameController): Unit = {
    if(target.isDefined)
      controller.state = new DoingAction(attackingChar, target.get, spell)
  }

  /** Returns true because this state is ChoosingTarget. */
  override def isChoosingTarget(): Boolean = true
}
