package controller.states

import characters.TCharacter
import controller.GameController
import spells.{Fire, Spell}

/** State class used when the (magic) character chooses a spell to cast.
 * @param magicChar The character who will throw the spell.
 * @param sp Option for testing purposes
 * */
class ChoosingSpell(magicChar: TCharacter, sp: Option[Spell] = None) extends AbstractGameState {
  private var spell: Option[Spell] = sp

  /** Changes the state of the game controller.*/
  def update(controller: GameController): Unit = {
    if(spell.isDefined)
      controller.state = new ChoosingTarget(magicChar, spell)
  }

  /** Returns true because this state is ChoosingSpell. */
  override def isChoosingSpell(): Boolean = true
}
