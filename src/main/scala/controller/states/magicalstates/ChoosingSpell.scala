package controller.states.magicalstates

import characters.magicalcharacters.MagicalCharacter
import controller.GameController
import controller.states.{AbstractGameState, ChoosingTarget}
import spells._

/** State class used when the (magic) character chooses a spell to cast.
 * @param magicChar The character who will throw the spell.
 * @param sp Option for testing purposes
 * */
class ChoosingSpell(magicChar: MagicalCharacter, sp: Option[Spell] = None) extends AbstractGameState {
  private var spell: Option[Spell] = sp

  /** Handle input from the user. */
  override def handleInput(controller: GameController): Unit = {
    controller.showSpells
    val userInput: Int = controller.getNumericalInput
    if(userInput == 0) spell = Some(new Thunder)
    else if(userInput == 1) spell = Some(new Fire)
    else if(userInput == 2) spell = Some(new Poison)
    else if(userInput == 3) spell = Some(new Paralysis)
    else if(userInput == 4) spell = Some(new Healing)

  }
  /** Changes the state of the game controller.*/
  def update(controller: GameController): Unit = {
    if(spell.isDefined)
      controller.state = new MagicalChoosingTarget(magicChar, spell)
  }

  /** Returns true because this state is ChoosingSpell. */
  override def isChoosingSpell: Boolean = true
}
