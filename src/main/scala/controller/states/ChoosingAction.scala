package controller.states

import characters.TCharacter
import controller.GameController

/** State class when a character must choose an action (attack, spell or changing weapon)
 * @param currChar The current character in play.
 * @param ac Option for testing purposes
 * */
class ChoosingAction(currChar: TCharacter, ac: Option[String] = None) extends AbstractGameState {
  private var action: Option[String] = ac

  /** Changes the state of the game controller */
  def update(controller: GameController): Unit = {
    if(action.isDefined) {
        if(action.get == "attack")
          controller.state = new ChoosingTarget(currChar)
        else if(action.get == "spell")
          controller.state = new ChoosingSpell(currChar)
        else if(action.get == "weapon")
          controller.state = new ChangingWeapon(currChar)
        else if(action.get == "skip")
          controller.state = new TurnProgramming
    }
  }

  /** Returns true because this state is ChoosingAction. */
  override def isChoosingAction(): Boolean = true
}
