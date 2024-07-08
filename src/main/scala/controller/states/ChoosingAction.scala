package controller.states

import characters.{TCharacter, WCharacter}
import controller.GameController
import controller.states.magicalstates.ChoosingSpell

/** State class when a character must choose an action (attack or changing weapon)
 * @param currChar The current character in play.
 * @param ac Option for testing purposes
 * */
class ChoosingAction(currChar: WCharacter, ac: Option[String] = None) extends AbstractGameState {
  private var action: Option[String] = ac

  /** Handles the input from the user. */
  override def handleInput(controller: GameController): Unit = {
    //Show possible actions
    controller.showActions
    //Make the user select an action
    val userInput: Int = controller.getNumericalInput
    if(userInput == 0) action = Some("attack")
    else if(userInput == 1) action = Some("weapon")
  }
  /** Changes the state of the game controller */
  def update(controller: GameController): Unit = {
    if(action.isDefined) {
        if(action.get == "attack")
          controller.state = new ChoosingTarget(currChar)
        else if(action.get == "weapon")
          controller.state = new ChangingWeapon(currChar)
    }
  }

  /** Returns true because this state is ChoosingAction. */
  override def isChoosingAction: Boolean = true
}
