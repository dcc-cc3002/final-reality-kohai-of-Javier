package controller.states

import characters.TCharacter
import controller.GameController
import spells.Spell

/** State class used when the (magic) character chooses a spell to cast.
 * @param magicChar The character who will throw the spell.
 * */
class ChoosingSpell(magicChar: TCharacter) extends AbstractGameState {
  private var spell: Option[Spell] = None

  /** Changes the state of the game controller */
  def update(controller: GameController): Unit = {
    if(spell.isDefined)
      controller.state = new ChoosingTarget(magicChar, spell)
  }

  /** Returns true because this state is ChoosingSpell. */
  override def isChoosingSpell(): Boolean = true
}
