package controller.states

import characters.TCharacter
import controller.GameController

/** State class when a character must choose an action (attack, spell or changing weapon)
 * @param currChar The current character in play.
 * */
class ChoosingAction(currChar: TCharacter) extends AbstractGameState {
  private var action: Option[String] = None

  /** Changes the state of the game controller */
  def update(controller: GameController): Unit = {
    if(action.isDefined) {
        if(action.get == "attack")
          controller.state = new ChoosingTarget(currChar)
        else if(action.get == "spell")
          controller.state = new ChoosingSpell(currChar)
        else if(action.get == "weapon")
          controller.state = new ChangingWeapon(currChar)
        else
          controller.state = new TurnProgramming
    }
  }

  /** Returns true because this state is ChoosingAction. */
  override def isChoosingAction(): Boolean = true
}
